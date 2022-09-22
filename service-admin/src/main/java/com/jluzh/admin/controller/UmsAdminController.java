package com.jluzh.admin.controller;


import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jluzh.admin.dto.*;
import com.jluzh.admin.dto.admin.AdminListParam;
import com.jluzh.admin.dto.admin.AdminRoleTransferVo;
import com.jluzh.admin.dto.admin.AdminSuperListVo;
import com.jluzh.admin.dto.admin.UpdateRoleParam;
import com.jluzh.admin.model.UmsAdmin;
import com.jluzh.admin.model.UmsRole;
import com.jluzh.admin.service.UmsAdminService;
import com.jluzh.admin.service.UmsMenuService;
import com.jluzh.admin.service.UmsRoleOperationService;
import com.jluzh.admin.service.UmsRoleService;
import com.jluzh.api.CommonPage;
import com.jluzh.api.CommonResult;
import com.jluzh.domain.UserDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 后台用户表 前端控制器
 * </p>
 *
 * @author banana
 * @since 2022-09-15
 */
@RestController
@Api(tags = "UmsAdminController", description = "后台用户管理")
@RequestMapping("/admin")
public class UmsAdminController {
    @Resource(name = "umsAdminServiceImpl")
    private UmsAdminService adminService;
    @Resource(name = "umsRoleServiceImpl")
    private UmsRoleService roleService;
    @Resource(name = "umsMenuServiceImpl")
    private UmsMenuService menuService;
    @Resource(name = "umsRoleOperationServiceImpl")
    private UmsRoleOperationService umsRoleOperationService;

    @ApiOperation(value = "用户注册")
    @PostMapping( "/register")
    public CommonResult<UmsAdmin> register(@Validated @RequestBody UmsAdminParam umsAdminParam) {
        UmsAdmin umsAdmin = adminService.register(umsAdminParam);
        if (umsAdmin == null) {
            return CommonResult.failed();
        }
        return CommonResult.success(umsAdmin);
    }

    @ApiOperation(value = "登录以后返回token")
    @PostMapping( "/login")
    public CommonResult login(@Validated @RequestBody UmsAdminLoginParam umsAdminLoginParam) {
        return adminService.login(umsAdminLoginParam.getUsername(),umsAdminLoginParam.getPassword());
    }

    @ApiOperation(value = "获取当前登录用户信息")
    @GetMapping("/info")
    public CommonResult getAdminInfo() {
        // 从请求头中获取到用户
        UmsAdmin umsAdmin = adminService.getCurrentAdmin();
        Map<String, Object> data = new HashMap<>();
        data.put("username", umsAdmin.getUsername());
        // 根据用户ID获取其相应的多个角色
        List<Long> roleIdsByAdminId = adminService.getRoleIdsByAdminId(umsAdmin.getId());
        List<AsyncMenu> asyncMenus = null;
        List<RoleOperationDto> initRoles = null;
        // 如果当前账号没有任何角色则不进行加载菜单
        // 目前的思想则是默认所有的账号都有一个默认角色
        // TODO
        if(CollUtil.isNotEmpty(roleIdsByAdminId)) {
            asyncMenus = menuService.asyncListByRoleIds(roleIdsByAdminId);
            initRoles = umsRoleOperationService.init(umsAdmin.getId());
        }
        data.put("menus", asyncMenus);
        data.put("icon", umsAdmin.getIcon());
        data.put("loginTime", umsAdmin.getLoginTime());
        // 没有角色就没必要查询了
        data.put("roles", initRoles);
        return CommonResult.success(data);
    }

    @ApiOperation(value = "登出功能")
    @PostMapping("/logout")
    public CommonResult logout() {
        return CommonResult.success(null);
    }

    @ApiOperation("分页获取用户列表")
    @PostMapping("/list")
    public CommonResult<CommonPage<UmsAdmin>> list(@Validated @RequestBody AdminListParam param) {
        Page<UmsAdmin> list = adminService.list(param);
        return CommonResult.success(CommonPage.restPage(list));
    }

    @ApiOperation("分页获取用户角色超级列表")
    @PostMapping("/superList")
    public CommonResult<CommonPage<AdminSuperListVo>> superList(@Validated @RequestBody AdminListParam param) {
        Page<AdminSuperListVo> list = adminService.superList(param);
        return CommonResult.success(CommonPage.restPage(list));
    }
    @ApiOperation("获取指定用户信息")
    @GetMapping("/{id}")
    public CommonResult<UmsAdmin> getItem(@PathVariable Long id) {
        UmsAdmin admin = adminService.getById(id);
        return CommonResult.success(admin);
    }

    @ApiOperation("修改指定用户信息")
    @PostMapping("/update/{id}")
    public CommonResult update(@PathVariable Long id, @Validated @RequestBody UmsAdmin admin) {
        int count = adminService.update(id, admin);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("修改指定用户密码")
    @PostMapping("/updatePassword")
    public CommonResult updatePassword(@Validated @RequestBody UpdateAdminPasswordParam updatePasswordParam) {
        int status = adminService.updatePassword(updatePasswordParam);
        if (status > 0) {
            return CommonResult.success(status);
        } else if (status == -1) {
            return CommonResult.failed("提交参数不合法");
        } else if (status == -2) {
            return CommonResult.failed("找不到该用户");
        } else if (status == -3) {
            return CommonResult.failed("旧密码错误");
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("删除指定用户信息")
    @GetMapping("/delete/{id}")
    public CommonResult delete(@PathVariable Long id) {
        int count = adminService.deleteById(id);
        if (count >= 1) {
            return CommonResult.success("删除成功");
        }
        return CommonResult.failed("删除失败");
    }

    @ApiOperation("修改帐号状态")
    @PostMapping("/updateStatus/{id}")
    public CommonResult updateStatus(@PathVariable Long id,@RequestParam(value = "status") Integer status) {
        UmsAdmin umsAdmin = new UmsAdmin();
        umsAdmin.setStatus(status);
        int count = adminService.update(id,umsAdmin);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("根据用户id修改角色,分配角色")
    @PostMapping("/role/update")
    public CommonResult updateRole(@RequestBody UpdateRoleParam updateRoleParam) {
        int count = adminService.updateRole(updateRoleParam.getAdminId(), updateRoleParam.getRoleIds());
        if (count >= 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("根据用户名字修改角色,分配角色")
    @PostMapping("/role/updateByUsername")
    public CommonResult updateRoleByUsername(@RequestBody UpdateRoleParam updateRoleParam) {
        int count = adminService.updateRoleByUsername(updateRoleParam.getUsername(), updateRoleParam.getRoleIds());
        if (count >= 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取指定用户id的角色")
    @GetMapping("/role/{adminId}")
    public CommonResult<List<UmsRole>> getRoleList(@PathVariable Long adminId) {
        List<UmsRole> roleList = adminService.getRoleList(adminId);
        return CommonResult.success(roleList);
    }

    @ApiOperation("获取指定用户名的角色")
    @GetMapping("/role/{adminName}")
    public CommonResult<List<UmsRole>> getRoleList(@PathVariable String adminName) {
        List<UmsRole> roleList = adminService.getRoleListByAdminName(adminName);
        return CommonResult.success(roleList);
    }

    @ApiOperation("获取分配角色的Vo")
    @GetMapping("/role/transfer/{adminName}")
    public CommonResult<List<AdminRoleTransferVo>> getTransferVo(@PathVariable String adminName) {
        List<AdminRoleTransferVo> voList = adminService.getAdminRoleTransferVo(adminName);
        return CommonResult.success(voList);
    }

    @ApiOperation("根据用户名获取通用用户信息")
    @GetMapping("/loadByUsername")
    public UserDto loadUserByUsername(@RequestParam("username") String username) {
        UserDto userDTO = adminService.loadUserByUsername(username);
        return userDTO;
    }
}

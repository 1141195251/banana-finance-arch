package com.jluzh.admin.controller;


import cn.hutool.core.collection.CollUtil;
import com.jluzh.admin.dto.UmsAdminLoginParam;
import com.jluzh.admin.dto.UmsAdminParam;
import com.jluzh.admin.dto.UpdateAdminPasswordParam;
import com.jluzh.admin.model.UmsAdmin;
import com.jluzh.admin.model.UmsRole;
import com.jluzh.admin.service.UmsAdminService;
import com.jluzh.admin.service.UmsRoleService;
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
import java.util.stream.Collectors;

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
        UmsAdmin umsAdmin = adminService.getCurrentAdmin();
        Map<String, Object> data = new HashMap<>();
        data.put("username", umsAdmin.getUsername());
        data.put("menus", roleService.getMenuList(umsAdmin.getId()));
        data.put("icon", umsAdmin.getIcon());
        data.put("loginTime", umsAdmin.getLoginTime());
        List<UmsRole> roleList = adminService.getRoleList(umsAdmin.getId());
        if(CollUtil.isNotEmpty(roleList)){
            List<String> roles = roleList.stream().map(UmsRole::getName).collect(Collectors.toList());
            data.put("roles",roles);
        }
        return CommonResult.success(data);
    }

    @ApiOperation(value = "登出功能")
    @PostMapping("/logout")
    public CommonResult logout() {
        return CommonResult.success(null);
    }

//    @ApiOperation("根据用户名或姓名分页获取用户列表")
//    @GetMapping("/list")
//    public CommonResult<CommonPage<UmsAdmin>> list(@RequestParam(value = "keyword", required = false) String keyword,
//                                                   @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
//                                                   @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
//        List<UmsAdmin> adminList = adminService.list(keyword, pageSize, pageNum);
//        return CommonResult.success(CommonPage.restPage(adminList));
//    }

    @ApiOperation("获取指定用户信息")
    @GetMapping("/{id}")
    public CommonResult<UmsAdmin> getItem(@PathVariable Long id) {
        UmsAdmin admin = adminService.getById(id);
        return CommonResult.success(admin);
    }

    @ApiOperation("修改指定用户信息")
    @PostMapping("/update/{id}")
    public CommonResult update(@PathVariable Long id, @RequestBody UmsAdmin admin) {
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
    @PostMapping("/delete/{id}")
    public CommonResult delete(@PathVariable Long id) {
        Boolean result = adminService.removeById(id);
        if (result) {
            return CommonResult.success("true");
        }
        return CommonResult.failed();
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

    @ApiOperation("根据用户id修改角色")
    @PostMapping("/role/update")
    public CommonResult updateRole(@RequestParam("adminId") Long adminId,
                                   @RequestParam("roleIds") List<Long> roleIds) {
        int count = adminService.updateRole(adminId, roleIds);
        if (count >= 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取指定用户的角色")
    @GetMapping("/role/{adminId}")
    public CommonResult<List<UmsRole>> getRoleList(@PathVariable Long adminId) {
        List<UmsRole> roleList = adminService.getRoleList(adminId);
        return CommonResult.success(roleList);
    }

    @ApiOperation("根据用户名获取通用用户信息")
    @GetMapping("/loadByUsername")
    public UserDto loadUserByUsername(@RequestParam("username") String username) {
        UserDto userDTO = adminService.loadUserByUsername(username);
        return userDTO;
    }
}

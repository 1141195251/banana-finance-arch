package com.jluzh.admin.controller;


import com.jluzh.admin.model.UmsMenu;
import com.jluzh.admin.model.UmsRole;
import com.jluzh.admin.service.UmsRoleService;
import com.jluzh.api.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 后台用户角色表 前端控制器
 * </p>
 *
 * @author banana
 * @since 2022-09-15
 */
@RestController
@Api(tags = "UmsRoleController", description = "后台用户角色管理")
@RequestMapping("/role")
public class UmsRoleController {
    @Resource(name = "umsRoleServiceImpl")
    private UmsRoleService roleService;

    @ApiOperation("添加角色")
    @PostMapping("/create")
    public CommonResult create(@RequestBody UmsRole role) {
        int count = roleService.create(role);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("修改角色")
    @PostMapping("/update/{id}")
    public CommonResult update(@PathVariable Long id, @RequestBody UmsRole role) {
        int count = roleService.update(id, role);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

//    @ApiOperation("批量删除角色")
//    @PostMapping("/delete")
//    public CommonResult delete(@RequestParam("ids") List<Long> ids) {
//        int count = roleService.delete(ids);
//        if (count > 0) {
//            return CommonResult.success(count);
//        }
//        return CommonResult.failed();
//    }

    @ApiOperation("获取所有角色")
    @GetMapping("/listAll")
    public CommonResult<List<UmsRole>> listAll() {
        List<UmsRole> roleList = roleService.list();
        return CommonResult.success(roleList);
    }

//    @ApiOperation("根据角色名称分页获取角色列表")
//    @GetMapping("/list")
//    public CommonResult<CommonPage<UmsRole>> list(@RequestParam(value = "keyword", required = false) String keyword,
//                                                  @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
//                                                  @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
//        List<UmsRole> roleList = roleService.list(keyword, pageSize, pageNum);
//        return CommonResult.success(CommonPage.restPage(roleList));
//    }

    @ApiOperation("修改角色状态")
    @PostMapping("/updateStatus/{id}")
    public CommonResult updateStatus(@PathVariable Long id, @RequestParam(value = "status") Integer status) {
        UmsRole umsRole = new UmsRole();
        umsRole.setStatus(status);
        int count = roleService.update(id, umsRole);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取角色相关菜单")
    @GetMapping("/listMenu/{roleId}")
    public CommonResult<List<UmsMenu>> listMenu(@PathVariable Long roleId) {
        List<UmsMenu> roleList = roleService.listMenu(roleId);
        return CommonResult.success(roleList);
    }

//    @ApiOperation("获取角色相关资源")
//    @GetMapping("/listResource/{roleId}")
//    public CommonResult<List<UmsResource>> listResource(@PathVariable Long roleId) {
//        List<UmsResource> roleList = roleService.listResource(roleId);
//        return CommonResult.success(roleList);
//    }

//    @ApiOperation("给角色分配菜单")
//    @PostMapping("/allocMenu")
//    public CommonResult allocMenu(@RequestParam Long roleId, @RequestParam List<Long> menuIds) {
//        int count = roleService.allocMenu(roleId, menuIds);
//        return CommonResult.success(count);
//    }

//    @ApiOperation("给角色分配资源")
//    @PostMapping("/allocResource")
//    public CommonResult allocResource(@RequestParam Long roleId, @RequestParam List<Long> resourceIds) {
//        int count = roleService.allocResource(roleId, resourceIds);
//        return CommonResult.success(count);
//    }
}


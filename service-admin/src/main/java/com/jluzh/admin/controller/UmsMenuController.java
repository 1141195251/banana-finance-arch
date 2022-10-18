package com.jluzh.admin.controller;


import com.jluzh.admin.dto.AsyncMenu;
import com.jluzh.admin.dto.UmsMenuNode;
import com.jluzh.admin.model.UmsMenu;
import com.jluzh.admin.service.UmsMenuService;
import com.jluzh.api.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 后台菜单表 前端控制器
 * </p>
 *
 * @author banana
 * @since 2022-09-15
 */
@Api(tags = "UmsMenuController", description = "后台菜单管理")
@RestController
@RequestMapping("/menu")
public class UmsMenuController {
    @Resource(name = "umsMenuServiceImpl")
    private UmsMenuService menuService;


    @ApiOperation("根据roleId加载异步路由菜单")
    @GetMapping("/initRoutesByRoleId/{roleId}")
    public  CommonResult initRoutesByRoleId(@PathVariable Long roleId) {
        // TODO 还要加载没有roleId关联的菜单 这种情况默认是不需要权限
        List<AsyncMenu> list = menuService.asyncList(roleId);
        return CommonResult.success(list);
    }

    @ApiOperation("添加后台菜单")
    @PostMapping("/create")
    public CommonResult create(@RequestBody UmsMenu umsMenu) {
        int count = menuService.create(umsMenu);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
    @ApiOperation("获取所有菜单名和菜单编号")
    @GetMapping("/getMenuName")
    public CommonResult getMenuName() {
        List<UmsMenu> data = menuService.getMenuNameId();
        return CommonResult.success(data);
    }

    @ApiOperation("修改后台菜单")
    @PostMapping("/update/{id}")
    public CommonResult update(@PathVariable Long id,
                               @RequestBody UmsMenu umsMenu) {
        int count = menuService.update(id, umsMenu);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed("父菜单不能是自己!");
        }
    }

    @ApiOperation("根据ID获取菜单详情")
    @GetMapping("/{id}")
    public CommonResult<UmsMenu> getItem(@PathVariable Long id) {
        UmsMenu umsMenu = menuService.getById(id);
        return CommonResult.success(umsMenu);
    }

//    @ApiOperation("根据角色编号获取菜单名")
//    @GetMapping("/menuName/{id}")
//    // TODO
//    public CommonResult<UmsMenu> getMenuName(@PathVariable Long id) {
//        UmsMenu umsMenu = menuService.getMenuNameByRoleId(id);
//        return CommonResult.success(umsMenu);
//    }

    @ApiOperation("根据编号删除后台菜单")
    @DeleteMapping("/delete/{id}")
    public CommonResult delete(@PathVariable Long id) {
        boolean hasRemoved = menuService.removeById(id);
        if (hasRemoved) {
            return CommonResult.success(true);
        } else {
            return CommonResult.failed();
        }
    }

//    @ApiOperation("分页查询后台菜单")
//    @GetMapping("/list/{parentId}")
//    public CommonResult<CommonPage<UmsMenu>> list(@PathVariable Long parentId,
//                                                  @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
//                                                  @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
//        List<UmsMenu> menuList = menuService.list(parentId, pageSize, pageNum);
//        return CommonResult.success(CommonPage.restPage(menuList));
//    }

    @ApiOperation("树形结构返回所有菜单列表")
    @GetMapping("/treeList")
    public CommonResult<List<UmsMenuNode>> treeList() {
        List<UmsMenuNode> list = menuService.treeList();
        return CommonResult.success(list);
    }

    @ApiOperation("修改菜单显示状态")
    @PostMapping("/updateHidden/{id}")
    public CommonResult updateHidden(@PathVariable Long id, @RequestParam("hidden") Integer hidden) {
        int count = menuService.updateHidden(id, hidden);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
}


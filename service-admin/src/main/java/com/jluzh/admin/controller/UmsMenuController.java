package com.jluzh.admin.controller;


import com.jluzh.admin.dto.UmsMenuNode;
import com.jluzh.admin.model.UmsMenu;
import com.jluzh.admin.service.UmsMenuService;
import com.jluzh.api.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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

//    @ApiOperation("添加后台菜单")
//    @PostMapping("/create")
//    public CommonResult create(@RequestBody UmsMenu umsMenu) {
//        int count = menuService.create(umsMenu);
//        if (count > 0) {
//            return CommonResult.success(count);
//        } else {
//            return CommonResult.failed();
//        }
//    }

//    @ApiOperation("修改后台菜单")
//    @PostMapping("/update/{id}")
//    public CommonResult update(@PathVariable Long id,
//                               @RequestBody UmsMenu umsMenu) {
//        int count = menuService.update(id, umsMenu);
//        if (count > 0) {
//            return CommonResult.success(count);
//        } else {
//            return CommonResult.failed();
//        }
//    }

//    @ApiOperation("根据ID获取菜单详情")
//    @GetMapping("/{id}")
//    public CommonResult<UmsMenu> getItem(@PathVariable Long id) {
//        UmsMenu umsMenu = menuService.getItem(id);
//        return CommonResult.success(umsMenu);
//    }

//    @ApiOperation("根据ID删除后台菜单")
//    @PostMapping("/delete/{id}")
//    public CommonResult delete(@PathVariable Long id) {
//        int count = menuService.delete(id);
//        if (count > 0) {
//            return CommonResult.success(count);
//        } else {
//            return CommonResult.failed();
//        }
//    }

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

//    @ApiOperation("修改菜单显示状态")
//    @PostMapping("/updateHidden/{id}")
//    public CommonResult updateHidden(@PathVariable Long id, @RequestParam("hidden") Integer hidden) {
//        int count = menuService.updateHidden(id, hidden);
//        if (count > 0) {
//            return CommonResult.success(count);
//        } else {
//            return CommonResult.failed();
//        }
//    }
}


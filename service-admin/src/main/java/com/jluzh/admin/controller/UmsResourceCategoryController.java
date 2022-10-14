package com.jluzh.admin.controller;


import com.jluzh.admin.model.UmsResourceCategory;
import com.jluzh.admin.service.UmsResourceCategoryService;
import com.jluzh.api.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 资源分类表 前端控制器
 * </p>
 *
 * @author banana
 * @since 2022-09-15
 */
@RestController
@Api(tags = "UmsResourceCategoryController", description = "后台资源分类管理")
@RequestMapping("/resourceCategory")
public class UmsResourceCategoryController {
    @Resource(name = "umsResourceCategoryServiceImpl")
    private UmsResourceCategoryService resourceCategoryService;

    @ApiOperation("查询所有后台资源分类")
    @GetMapping("/listAll")
    public CommonResult<List<UmsResourceCategory>> listAll() {
        List<UmsResourceCategory> resourceList = resourceCategoryService.list();
        return CommonResult.success(resourceList);
    }

//    @ApiOperation("添加后台资源分类")
//    @PostMapping("/create")
//    public CommonResult create(@RequestBody UmsResourceCategory umsResourceCategory) {
//        int count = resourceCategoryService.create(umsResourceCategory);
//        if (count > 0) {
//            return CommonResult.success(count);
//        } else {
//            return CommonResult.failed();
//        }
//    }
//
//    @ApiOperation("修改后台资源分类")
//    @PostMapping("/update/{id}")
//    public CommonResult update(@PathVariable Long id,
//                               @RequestBody UmsResourceCategory umsResourceCategory) {
//        int count = resourceCategoryService.update(id, umsResourceCategory);
//        if (count > 0) {
//            return CommonResult.success(count);
//        } else {
//            return CommonResult.failed();
//        }
//    }
//
//    @ApiOperation("根据ID删除后台资源")
//    @PostMapping("/delete/{id}")
//    public CommonResult delete(@PathVariable Long id) {
//        int count = resourceCategoryService.delete(id);
//        if (count > 0) {
//            return CommonResult.success(count);
//        } else {
//            return CommonResult.failed();
//        }
//    }
}


package com.jluzh.risk.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jluzh.risk.entity.RsRiskCategory;
import com.jluzh.risk.service.RsRiskCategoryService;
import com.jluzh.api.CommonResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import com.jluzh.api.CommonPage;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 风险分类表(RsRiskCategory)表控制层
 *
 * @author panlaoliu
 * @since 2022-10-16 16:46:49
 */
@Api(tags = "风险分类表(RsRiskCategory)")
@RestController
@RequestMapping("/risk/rsRiskCategory")
public class RsRiskCategoryController {
    /**
     * 服务对象
     */
    @Resource
    private RsRiskCategoryService rsRiskCategoryService;

    /**
     * 分页查询所有数据
     *
     * @param page           分页对象
     * @param rsRiskCategory 查询实体
     * @return 所有数据
     */
    @ApiOperation(value = "分页查询所有数据")
    @GetMapping
    public CommonResult selectAll(Page<RsRiskCategory> page, RsRiskCategory rsRiskCategory) {
        return CommonResult.success(CommonPage.restPage(rsRiskCategoryService.page(page, new QueryWrapper<>(rsRiskCategory))));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "通过主键查询单条数据")
    @GetMapping("{id}")
    public CommonResult selectOne(@PathVariable Serializable id) {
        return CommonResult.success(this.rsRiskCategoryService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param rsRiskCategory 实体对象
     * @return 新增结果
     */
    @ApiOperation(value = "新增数据")
    @PostMapping
    public CommonResult insert(@RequestBody RsRiskCategory rsRiskCategory) {
        return CommonResult.success(this.rsRiskCategoryService.save(rsRiskCategory));
    }

    /**
     * 修改数据
     *
     * @param rsRiskCategory 实体对象
     * @return 修改结果
     */
    @ApiOperation(value = "修改数据")
    @PutMapping
    public CommonResult update(@RequestBody RsRiskCategory rsRiskCategory) {
        return CommonResult.success(this.rsRiskCategoryService.updateById(rsRiskCategory));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @ApiOperation(value = "删除数据")
    @DeleteMapping
    public CommonResult delete(@RequestParam("idList") List<Long> idList) {
        return CommonResult.success(this.rsRiskCategoryService.removeByIds(idList));
    }
}


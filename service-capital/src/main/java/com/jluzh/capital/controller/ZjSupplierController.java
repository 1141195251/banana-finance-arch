package com.jluzh.capital.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jluzh.capital.entity.ZjSupplier;
import com.jluzh.capital.service.ZjSupplierService;
import com.jluzh.api.CommonResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import com.jluzh.api.CommonPage;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 供应商(ZjSupplier)表控制层
 *
 * @author panlaoliu
 * @since 2022-10-16 16:57:48
 */
@Api(tags = "供应商(ZjSupplier)")
@RestController
@RequestMapping("/capital/zjSupplier")
public class ZjSupplierController {
    /**
     * 服务对象
     */
    @Resource
    private ZjSupplierService zjSupplierService;

    /**
     * 分页查询所有数据
     *
     * @param page       分页对象
     * @param zjSupplier 查询实体
     * @return 所有数据
     */
    @ApiOperation(value = "分页查询所有数据")
    @GetMapping
    public CommonResult selectAll(Page<ZjSupplier> page, ZjSupplier zjSupplier) {
        return CommonResult.success(CommonPage.restPage(zjSupplierService.page(page, new QueryWrapper<>(zjSupplier))));
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
        return CommonResult.success(this.zjSupplierService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param zjSupplier 实体对象
     * @return 新增结果
     */
    @ApiOperation(value = "新增数据")
    @PostMapping
    public CommonResult insert(@RequestBody ZjSupplier zjSupplier) {
        return CommonResult.success(this.zjSupplierService.save(zjSupplier));
    }

    /**
     * 修改数据
     *
     * @param zjSupplier 实体对象
     * @return 修改结果
     */
    @ApiOperation(value = "修改数据")
    @PutMapping
    public CommonResult update(@RequestBody ZjSupplier zjSupplier) {
        return CommonResult.success(this.zjSupplierService.updateById(zjSupplier));
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
        return CommonResult.success(this.zjSupplierService.removeByIds(idList));
    }
}


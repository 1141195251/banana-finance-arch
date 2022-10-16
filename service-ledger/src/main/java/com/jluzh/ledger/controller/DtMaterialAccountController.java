package com.jluzh.ledger.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jluzh.ledger.entity.DtMaterialAccount;
import com.jluzh.ledger.service.DtMaterialAccountService;
import com.jluzh.api.CommonResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import com.jluzh.api.CommonPage;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 原材料明细账(DtMaterialAccount)表控制层
 *
 * @author panlaoliu
 * @since 2022-10-16 16:39:08
 */
@Api(tags = "原材料明细账(DtMaterialAccount)")
@RestController
@RequestMapping("/ledger/dtMaterialAccount")
public class DtMaterialAccountController {
    /**
     * 服务对象
     */
    @Resource
    private DtMaterialAccountService dtMaterialAccountService;

    /**
     * 分页查询所有数据
     *
     * @param page              分页对象
     * @param dtMaterialAccount 查询实体
     * @return 所有数据
     */
    @ApiOperation(value = "分页查询所有数据")
    @GetMapping
    public CommonResult selectAll(Page<DtMaterialAccount> page, DtMaterialAccount dtMaterialAccount) {
        return CommonResult.success(CommonPage.restPage(dtMaterialAccountService.page(page, new QueryWrapper<>(dtMaterialAccount))));
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
        return CommonResult.success(this.dtMaterialAccountService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param dtMaterialAccount 实体对象
     * @return 新增结果
     */
    @ApiOperation(value = "新增数据")
    @PostMapping
    public CommonResult insert(@RequestBody DtMaterialAccount dtMaterialAccount) {
        return CommonResult.success(this.dtMaterialAccountService.save(dtMaterialAccount));
    }

    /**
     * 修改数据
     *
     * @param dtMaterialAccount 实体对象
     * @return 修改结果
     */
    @ApiOperation(value = "修改数据")
    @PutMapping
    public CommonResult update(@RequestBody DtMaterialAccount dtMaterialAccount) {
        return CommonResult.success(this.dtMaterialAccountService.updateById(dtMaterialAccount));
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
        return CommonResult.success(this.dtMaterialAccountService.removeByIds(idList));
    }
}


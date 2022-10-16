package com.jluzh.ledger.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jluzh.ledger.entity.DtImprest;
import com.jluzh.ledger.service.DtImprestService;
import com.jluzh.api.CommonResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import com.jluzh.api.CommonPage;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 备用金明细账(DtImprest)表控制层
 *
 * @author panlaoliu
 * @since 2022-10-16 16:39:07
 */
@Api(tags = "备用金明细账(DtImprest)")
@RestController
@RequestMapping("/ledger/dtImprest")
public class DtImprestController {
    /**
     * 服务对象
     */
    @Resource
    private DtImprestService dtImprestService;

    /**
     * 分页查询所有数据
     *
     * @param page      分页对象
     * @param dtImprest 查询实体
     * @return 所有数据
     */
    @ApiOperation(value = "分页查询所有数据")
    @GetMapping
    public CommonResult selectAll(Page<DtImprest> page, DtImprest dtImprest) {
        return CommonResult.success(CommonPage.restPage(dtImprestService.page(page, new QueryWrapper<>(dtImprest))));
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
        return CommonResult.success(this.dtImprestService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param dtImprest 实体对象
     * @return 新增结果
     */
    @ApiOperation(value = "新增数据")
    @PostMapping
    public CommonResult insert(@RequestBody DtImprest dtImprest) {
        return CommonResult.success(this.dtImprestService.save(dtImprest));
    }

    /**
     * 修改数据
     *
     * @param dtImprest 实体对象
     * @return 修改结果
     */
    @ApiOperation(value = "修改数据")
    @PutMapping
    public CommonResult update(@RequestBody DtImprest dtImprest) {
        return CommonResult.success(this.dtImprestService.updateById(dtImprest));
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
        return CommonResult.success(this.dtImprestService.removeByIds(idList));
    }
}


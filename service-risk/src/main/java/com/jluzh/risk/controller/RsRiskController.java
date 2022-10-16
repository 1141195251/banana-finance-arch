package com.jluzh.risk.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jluzh.risk.entity.RsRisk;
import com.jluzh.risk.service.RsRiskService;
import com.jluzh.api.CommonResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import com.jluzh.api.CommonPage;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 风险表(RsRisk)表控制层
 *
 * @author panlaoliu
 * @since 2022-10-16 16:46:49
 */
@Api(tags = "风险表(RsRisk)")
@RestController
@RequestMapping("/risk/rsRisk")
public class RsRiskController {
    /**
     * 服务对象
     */
    @Resource
    private RsRiskService rsRiskService;

    /**
     * 分页查询所有数据
     *
     * @param page   分页对象
     * @param rsRisk 查询实体
     * @return 所有数据
     */
    @ApiOperation(value = "分页查询所有数据")
    @GetMapping
    public CommonResult selectAll(Page<RsRisk> page, RsRisk rsRisk) {
        return CommonResult.success(CommonPage.restPage(rsRiskService.page(page, new QueryWrapper<>(rsRisk))));
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
        return CommonResult.success(this.rsRiskService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param rsRisk 实体对象
     * @return 新增结果
     */
    @ApiOperation(value = "新增数据")
    @PostMapping
    public CommonResult insert(@RequestBody RsRisk rsRisk) {
        return CommonResult.success(this.rsRiskService.save(rsRisk));
    }

    /**
     * 修改数据
     *
     * @param rsRisk 实体对象
     * @return 修改结果
     */
    @ApiOperation(value = "修改数据")
    @PutMapping
    public CommonResult update(@RequestBody RsRisk rsRisk) {
        return CommonResult.success(this.rsRiskService.updateById(rsRisk));
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
        return CommonResult.success(this.rsRiskService.removeByIds(idList));
    }
}


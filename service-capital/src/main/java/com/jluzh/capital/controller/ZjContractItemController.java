package com.jluzh.capital.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jluzh.capital.entity.ZjContractItem;
import com.jluzh.capital.service.ZjContractItemService;
import com.jluzh.api.CommonResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import com.jluzh.api.CommonPage;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 合同付款表(ZjContractItem)表控制层
 *
 * @author panlaoliu
 * @since 2022-10-16 16:57:49
 */
@Api(tags = "合同付款表(ZjContractItem)")
@RestController
@RequestMapping("/capital/zjContractItem")
public class ZjContractItemController {
    /**
     * 服务对象
     */
    @Resource
    private ZjContractItemService zjContractItemService;

    /**
     * 分页查询所有数据
     *
     * @param page           分页对象
     * @param zjContractItem 查询实体
     * @return 所有数据
     */
    @ApiOperation(value = "分页查询所有数据")
    @GetMapping
    public CommonResult selectAll(Page<ZjContractItem> page, ZjContractItem zjContractItem) {
        return CommonResult.success(CommonPage.restPage(zjContractItemService.page(page, new QueryWrapper<>(zjContractItem))));
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
        return CommonResult.success(this.zjContractItemService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param zjContractItem 实体对象
     * @return 新增结果
     */
    @ApiOperation(value = "新增数据")
    @PostMapping
    public CommonResult insert(@RequestBody ZjContractItem zjContractItem) {
        return CommonResult.success(this.zjContractItemService.save(zjContractItem));
    }

    /**
     * 修改数据
     *
     * @param zjContractItem 实体对象
     * @return 修改结果
     */
    @ApiOperation(value = "修改数据")
    @PutMapping
    public CommonResult update(@RequestBody ZjContractItem zjContractItem) {
        return CommonResult.success(this.zjContractItemService.updateById(zjContractItem));
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
        return CommonResult.success(this.zjContractItemService.removeByIds(idList));
    }
}


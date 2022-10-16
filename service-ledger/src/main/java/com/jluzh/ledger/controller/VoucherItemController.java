package com.jluzh.ledger.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jluzh.ledger.entity.VoucherItem;
import com.jluzh.ledger.service.VoucherItemService;
import com.jluzh.api.CommonResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import com.jluzh.api.CommonPage;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 凭证单(VoucherItem)表控制层
 *
 * @author panlaoliu
 * @since 2022-10-16 16:39:11
 */
@Api(tags = "凭证单(VoucherItem)")
@RestController
@RequestMapping("/ledger/voucherItem")
public class VoucherItemController {
    /**
     * 服务对象
     */
    @Resource
    private VoucherItemService voucherItemService;

    /**
     * 分页查询所有数据
     *
     * @param page        分页对象
     * @param voucherItem 查询实体
     * @return 所有数据
     */
    @ApiOperation(value = "分页查询所有数据")
    @GetMapping("/list")
    public CommonResult selectAll(Page<VoucherItem> page, VoucherItem voucherItem) {
        return CommonResult.success(CommonPage.restPage(voucherItemService.page(page, new QueryWrapper<>(voucherItem))));
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
        return CommonResult.success(this.voucherItemService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param voucherItem 实体对象
     * @return 新增结果
     */
    @ApiOperation(value = "新增数据")
    @PostMapping
    public CommonResult insert(@RequestBody VoucherItem voucherItem) {
        return CommonResult.success(this.voucherItemService.save(voucherItem));
    }

    /**
     * 修改数据
     *
     * @param voucherItem 实体对象
     * @return 修改结果
     */
    @ApiOperation(value = "修改数据")
    @PutMapping
    public CommonResult update(@RequestBody VoucherItem voucherItem) {
        return CommonResult.success(this.voucherItemService.updateById(voucherItem));
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
        return CommonResult.success(this.voucherItemService.removeByIds(idList));
    }
}


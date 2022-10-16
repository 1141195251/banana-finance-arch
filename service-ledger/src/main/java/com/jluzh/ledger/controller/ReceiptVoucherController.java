package com.jluzh.ledger.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jluzh.ledger.entity.ReceiptVoucher;
import com.jluzh.ledger.service.ReceiptVoucherService;
import com.jluzh.api.CommonResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import com.jluzh.api.CommonPage;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 收款凭证(ReceiptVoucher)表控制层
 *
 * @author panlaoliu
 * @since 2022-10-16 16:39:10
 */
@Api(tags = "收款凭证(ReceiptVoucher)")
@RestController
@RequestMapping("/ledger/receiptVoucher")
public class ReceiptVoucherController {
    /**
     * 服务对象
     */
    @Resource
    private ReceiptVoucherService receiptVoucherService;

    /**
     * 分页查询所有数据
     *
     * @param page           分页对象
     * @param receiptVoucher 查询实体
     * @return 所有数据
     */
    @ApiOperation(value = "分页查询所有数据")
    @GetMapping
    public CommonResult selectAll(Page<ReceiptVoucher> page, ReceiptVoucher receiptVoucher) {
        return CommonResult.success(CommonPage.restPage(receiptVoucherService.page(page, new QueryWrapper<>(receiptVoucher))));
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
        return CommonResult.success(this.receiptVoucherService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param receiptVoucher 实体对象
     * @return 新增结果
     */
    @ApiOperation(value = "新增数据")
    @PostMapping
    public CommonResult insert(@RequestBody ReceiptVoucher receiptVoucher) {
        return CommonResult.success(this.receiptVoucherService.save(receiptVoucher));
    }

    /**
     * 修改数据
     *
     * @param receiptVoucher 实体对象
     * @return 修改结果
     */
    @ApiOperation(value = "修改数据")
    @PutMapping
    public CommonResult update(@RequestBody ReceiptVoucher receiptVoucher) {
        return CommonResult.success(this.receiptVoucherService.updateById(receiptVoucher));
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
        return CommonResult.success(this.receiptVoucherService.removeByIds(idList));
    }
}


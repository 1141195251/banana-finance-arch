package com.jluzh.ledger.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jluzh.ledger.entity.TransferVoucher;
import com.jluzh.ledger.service.TransferVoucherService;
import com.jluzh.api.CommonResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import com.jluzh.api.CommonPage;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 转账凭证(TransferVoucher)表控制层
 *
 * @author panlaoliu
 * @since 2022-10-16 16:39:11
 */
@Api(tags = "转账凭证(TransferVoucher)")
@RestController
@RequestMapping("/ledger/transferVoucher")
public class TransferVoucherController {
    /**
     * 服务对象
     */
    @Resource
    private TransferVoucherService transferVoucherService;

    /**
     * 分页查询所有数据
     *
     * @param page            分页对象
     * @param transferVoucher 查询实体
     * @return 所有数据
     */
    @ApiOperation(value = "分页查询所有数据")
    @GetMapping
    public CommonResult selectAll(Page<TransferVoucher> page, TransferVoucher transferVoucher) {
        return CommonResult.success(CommonPage.restPage(transferVoucherService.page(page, new QueryWrapper<>(transferVoucher))));
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
        return CommonResult.success(this.transferVoucherService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param transferVoucher 实体对象
     * @return 新增结果
     */
    @ApiOperation(value = "新增数据")
    @PostMapping
    public CommonResult insert(@RequestBody TransferVoucher transferVoucher) {
        return CommonResult.success(this.transferVoucherService.save(transferVoucher));
    }

    /**
     * 修改数据
     *
     * @param transferVoucher 实体对象
     * @return 修改结果
     */
    @ApiOperation(value = "修改数据")
    @PutMapping
    public CommonResult update(@RequestBody TransferVoucher transferVoucher) {
        return CommonResult.success(this.transferVoucherService.updateById(transferVoucher));
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
        return CommonResult.success(this.transferVoucherService.removeByIds(idList));
    }
}


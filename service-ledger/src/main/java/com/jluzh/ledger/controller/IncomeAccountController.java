package com.jluzh.ledger.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jluzh.ledger.entity.IncomeAccount;
import com.jluzh.ledger.service.IncomeAccountService;
import com.jluzh.api.CommonResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import com.jluzh.api.CommonPage;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 收入账表(IncomeAccount)表控制层
 *
 * @author panlaoliu
 * @since 2022-10-16 16:39:09
 */
@Api(tags = "收入账表(IncomeAccount)")
@RestController
@RequestMapping("/ledger/incomeAccount")
public class IncomeAccountController {
    /**
     * 服务对象
     */
    @Resource
    private IncomeAccountService incomeAccountService;

    /**
     * 分页查询所有数据
     *
     * @param page          分页对象
     * @param incomeAccount 查询实体
     * @return 所有数据
     */
    @ApiOperation(value = "分页查询所有数据")
    @GetMapping
    public CommonResult selectAll(Page<IncomeAccount> page, IncomeAccount incomeAccount) {
        return CommonResult.success(CommonPage.restPage(incomeAccountService.page(page, new QueryWrapper<>(incomeAccount))));
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
        return CommonResult.success(this.incomeAccountService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param incomeAccount 实体对象
     * @return 新增结果
     */
    @ApiOperation(value = "新增数据")
    @PostMapping
    public CommonResult insert(@RequestBody IncomeAccount incomeAccount) {
        return CommonResult.success(this.incomeAccountService.save(incomeAccount));
    }

    /**
     * 修改数据
     *
     * @param incomeAccount 实体对象
     * @return 修改结果
     */
    @ApiOperation(value = "修改数据")
    @PutMapping
    public CommonResult update(@RequestBody IncomeAccount incomeAccount) {
        return CommonResult.success(this.incomeAccountService.updateById(incomeAccount));
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
        return CommonResult.success(this.incomeAccountService.removeByIds(idList));
    }
}


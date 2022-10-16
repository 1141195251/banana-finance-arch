package com.jluzh.msm.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jluzh.msm.entity.DeptRelation;
import com.jluzh.msm.service.DeptRelationService;
import com.jluzh.api.CommonResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import com.jluzh.api.CommonPage;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 部门关系(DeptRelation)表控制层
 *
 * @author panlaoliu
 * @since 2022-10-16 17:02:39
 */
@Api(tags = "部门关系(DeptRelation)")
@RestController
@RequestMapping("/msm/deptRelation")
public class DeptRelationController {
    /**
     * 服务对象
     */
    @Resource
    private DeptRelationService deptRelationService;

    /**
     * 分页查询所有数据
     *
     * @param page         分页对象
     * @param deptRelation 查询实体
     * @return 所有数据
     */
    @ApiOperation(value = "分页查询所有数据")
    @GetMapping
    public CommonResult selectAll(Page<DeptRelation> page, DeptRelation deptRelation) {
        return CommonResult.success(CommonPage.restPage(deptRelationService.page(page, new QueryWrapper<>(deptRelation))));
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
        return CommonResult.success(this.deptRelationService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param deptRelation 实体对象
     * @return 新增结果
     */
    @ApiOperation(value = "新增数据")
    @PostMapping
    public CommonResult insert(@RequestBody DeptRelation deptRelation) {
        return CommonResult.success(this.deptRelationService.save(deptRelation));
    }

    /**
     * 修改数据
     *
     * @param deptRelation 实体对象
     * @return 修改结果
     */
    @ApiOperation(value = "修改数据")
    @PutMapping
    public CommonResult update(@RequestBody DeptRelation deptRelation) {
        return CommonResult.success(this.deptRelationService.updateById(deptRelation));
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
        return CommonResult.success(this.deptRelationService.removeByIds(idList));
    }
}


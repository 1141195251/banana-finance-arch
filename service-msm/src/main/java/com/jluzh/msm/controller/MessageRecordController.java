package com.jluzh.msm.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jluzh.msm.entity.MessageRecord;
import com.jluzh.msm.service.MessageRecordService;
import com.jluzh.api.CommonResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import com.jluzh.api.CommonPage;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 消息推送记录表(MessageRecord)表控制层
 *
 * @author panlaoliu
 * @since 2022-10-16 03:59:50
 */
@Api(tags = "消息推送记录表(MessageRecord)")
@RestController
@RequestMapping("messageRecord")
public class MessageRecordController {
    /**
     * 服务对象
     */
    @Resource
    private MessageRecordService messageRecordService;

    /**
     * 分页查询所有数据
     *
     * @param page          分页对象
     * @param messageRecord 查询实体
     * @return 所有数据
     */
    @ApiOperation(value = "分页查询所有数据")
    @GetMapping
    public CommonResult selectAll(Page<MessageRecord> page, MessageRecord messageRecord) {
        return CommonResult.success(CommonPage.restPage(messageRecordService.page(page, new QueryWrapper<>(messageRecord))));
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
        return CommonResult.success(this.messageRecordService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param messageRecord 实体对象
     * @return 新增结果
     */
    @ApiOperation(value = "新增数据")
    @PostMapping
    public CommonResult insert(@RequestBody MessageRecord messageRecord) {
        return CommonResult.success(this.messageRecordService.save(messageRecord));
    }

    /**
     * 修改数据
     *
     * @param messageRecord 实体对象
     * @return 修改结果
     */
    @ApiOperation(value = "修改数据")
    @PutMapping
    public CommonResult update(@RequestBody MessageRecord messageRecord) {
        return CommonResult.success(this.messageRecordService.updateById(messageRecord));
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
        return CommonResult.success(this.messageRecordService.removeByIds(idList));
    }
}


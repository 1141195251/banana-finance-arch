package com.jluzh.admin.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jluzh.admin.dto.admin.AdminRoleRelationVo;
import com.jluzh.admin.service.UmsAdminRoleRelationService;
import com.jluzh.api.CommonPage;
import com.jluzh.api.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 后台用户和角色关系表 前端控制器
 * </p>
 *
 * @author banana
 * @since 2022-09-15
 */
@RestController
@RequestMapping("/admin/adminRoleRelation")
@Api(tags = "UmsAdminRoleRelationController", description = "用户角色关系接口")
public class UmsAdminRoleRelationController {
    @Resource(name = "umsAdminRoleRelationServiceImpl")
    UmsAdminRoleRelationService baseService;
    @ApiOperation(value = "查询优化的用户角色关系信息")
    @GetMapping("/getList")
    public CommonResult getAdminRoleRelationList(@RequestParam("pageNum") Long pageNum, @RequestParam("pageSize") Long pageSize) {
        Page<AdminRoleRelationVo> list = baseService.getAdminRoleRelationList(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(list));
    }

}


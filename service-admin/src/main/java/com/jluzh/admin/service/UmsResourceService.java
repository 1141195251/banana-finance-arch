package com.jluzh.admin.service;

import com.jluzh.admin.model.UmsResource;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 后台资源表 服务类
 * </p>
 *
 * @author banana
 * @since 2022-09-15
 */
public interface UmsResourceService extends IService<UmsResource> {
   /* *//**
     * 添加资源
     *//*
    int create(UmsResource umsResource);

    *//**
     * 修改资源
     *//*
    int update(Long id, UmsResource umsResource);

    *//**
     * 获取资源详情
     *//*
    UmsResource getItem(Long id);

    *//**
     * 删除资源
     *//*
    int delete(Long id);

    *//**
     * 分页查询资源
     *//*
    List<UmsResource> list(Long categoryId, String nameKeyword, String urlKeyword, Integer pageSize, Integer pageNum);

    *//**
     * 查询全部资源
     *//*
    List<UmsResource> listAll();

    */

    /**
     * 初始化资源角色规则
     */
    Map<String,List<String>> initResourceRolesMap();
}

package com.jluzh.admin.service;

import com.jluzh.admin.model.UmsResourceCategory;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 资源分类表 服务类
 * </p>
 *
 * @author banana
 * @since 2022-09-15
 */
public interface UmsResourceCategoryService extends IService<UmsResourceCategory> {
   /* *//**
     * 获取所有资源分类
     *//*
    List<UmsResourceCategory> listAll();

    *//**
     * 创建资源分类
     *//*
    int create(UmsResourceCategory umsResourceCategory);

    *//**
     * 修改资源分类
     *//*
    int update(Long id, UmsResourceCategory umsResourceCategory);

    *//**
     * 删除资源分类
     *//*
    int delete(Long id);
*/}

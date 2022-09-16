package com.jluzh.admin.service;

import com.jluzh.admin.model.UmsMenu;
import com.jluzh.admin.model.UmsResource;
import com.jluzh.admin.model.UmsRole;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 后台用户角色表 服务类
 * </p>
 *
 * @author banana
 * @since 2022-09-15
 */
public interface UmsRoleService extends IService<UmsRole> {
    /**
     * 添加角色
     *//*
    int create(UmsRole role);

    *//**
     * 修改角色信息
     *//*
    int update(Long id, UmsRole role);

    *//**
     * 批量删除角色
     *//*
    int delete(List<Long> ids);

    *//**
     * 获取所有角色列表
     *//*
    List<UmsRole> list();

    *//**
     * 分页获取角色列表
     *//*
    List<UmsRole> list(String keyword, Integer pageSize, Integer pageNum);

    *//**
     * 根据管理员ID获取对应菜单
     *//*
    List<UmsMenu> getMenuList(Long adminId);

    */
    /**
     * 获取角色相关菜单
     */
    List<UmsMenu> listMenu(Long roleId);

    /**
     * 获取角色相关资源
     *//*
    List<UmsResource> listResource(Long roleId);

    *//**
     * 给角色分配菜单
     *//*
    @Transactional
    int allocMenu(Long roleId, List<Long> menuIds);

    *//**
     * 给角色分配资源
     *//*
    @Transactional
    int allocResource(Long roleId, List<Long> resourceIds);
*/}

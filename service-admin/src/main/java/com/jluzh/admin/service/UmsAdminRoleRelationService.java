package com.jluzh.admin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jluzh.admin.dto.admin.AdminRoleRelationVo;
import com.jluzh.admin.dto.admin.AdminSuperListVo;
import com.jluzh.admin.model.UmsAdminRoleRelation;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 后台用户和角色关系表 服务类
 * </p>
 *
 * @author banana
 * @since 2022-09-15
 */
public interface UmsAdminRoleRelationService extends IService<UmsAdminRoleRelation> {
    Page<AdminRoleRelationVo> getAdminRoleRelationList(Long pageNum, Long pageSize);
}

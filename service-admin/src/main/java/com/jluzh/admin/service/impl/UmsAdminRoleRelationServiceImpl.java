package com.jluzh.admin.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jluzh.admin.dto.admin.AdminRoleRelationVo;
import com.jluzh.admin.model.UmsAdminRoleRelation;
import com.jluzh.admin.mapper.UmsAdminRoleRelationMapper;
import com.jluzh.admin.service.UmsAdminRoleRelationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户和角色关系表 服务实现类
 * </p>
 *
 * @author banana
 * @since 2022-09-15
 */
@Service
public class UmsAdminRoleRelationServiceImpl extends ServiceImpl<UmsAdminRoleRelationMapper, UmsAdminRoleRelation> implements UmsAdminRoleRelationService {
    @Autowired
    UmsAdminRoleRelationMapper adminRoleRelationMapper;
    @Override
    public Page<AdminRoleRelationVo> getAdminRoleRelationList(Long pageNum, Long pageSize) {
        Page<AdminRoleRelationVo> pageSettings = new Page<>(pageNum, pageSize);
        Page<AdminRoleRelationVo> list = adminRoleRelationMapper.getAdminRoleRelationList(pageSettings);
        return list;
    }
}

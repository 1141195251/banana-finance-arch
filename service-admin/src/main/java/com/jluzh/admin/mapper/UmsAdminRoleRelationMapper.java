package com.jluzh.admin.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jluzh.admin.dto.admin.AdminRoleRelationVo;
import com.jluzh.admin.model.UmsAdminRoleRelation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jluzh.admin.model.UmsResource;
import com.jluzh.admin.model.UmsRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 后台用户和角色关系表 Mapper 接口
 * </p>
 *
 * @author banana
 * @since 2022-09-15
 */
public interface UmsAdminRoleRelationMapper extends BaseMapper<UmsAdminRoleRelation> {
    /**
     * 批量插入用户角色关系
     */
    int insertList(@Param("list") List<UmsAdminRoleRelation> adminRoleRelationList);

    /**
     * 获取用于所有角色
     */
    List<UmsRole> getRoleList(@Param("adminId") Long adminId);

    /**
     * 根据用户名获取其角色
     * @param adminName
     * @return
     */
    List<UmsRole> getRoleListByAdminName(String adminName);

    /**
     *
     */
    Page<AdminRoleRelationVo> getAdminRoleRelationList(Page<AdminRoleRelationVo> pageSetting);
    /**
     * 获取用户所有可访问资源
     */
    List<UmsResource> getResourceList(@Param("adminId") Long adminId);

    /**
     * 获取资源相关用户ID列表
     */
    List<Long> getAdminIdList(@Param("resourceId") Long resourceId);
}

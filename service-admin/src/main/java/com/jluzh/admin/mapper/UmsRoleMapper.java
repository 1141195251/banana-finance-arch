package com.jluzh.admin.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jluzh.admin.dto.admin.RoleAndOperationDto;
import com.jluzh.admin.model.UmsMenu;
import com.jluzh.admin.model.UmsResource;
import com.jluzh.admin.model.UmsRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 后台用户角色表 Mapper 接口
 * </p>
 *
 * @author banana
 * @since 2022-09-15
 */
public interface UmsRoleMapper extends BaseMapper<UmsRole> {
    /**
     * 根据后台用户ID获取菜单
     */
    List<UmsMenu> getMenuList(@Param("adminId") Long adminId);
    /**
     * 根据角色ID获取菜单
     */
    List<UmsMenu> getMenuListByRoleId(@Param("roleId") Long roleId);
    /**
     * 根据角色ID获取资源
     */
    List<UmsResource> getResourceListByRoleId(@Param("roleId") Long roleId);

    /**
     *
     * 根据角色ID选择性更新
     */
    int updateByPrimaryKeySelective(UmsRole record);
    Page<UmsRole> listPage(Page<UmsRole> settings,@Param("role") UmsRole conditions);
    Page<RoleAndOperationDto> listRoleAndOperationPage(Page<RoleAndOperationDto> settings, @Param("conditions") RoleAndOperationDto conditions);
}

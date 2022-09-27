package com.jluzh.admin.mapper;

import com.jluzh.admin.model.UmsMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 后台菜单表 Mapper 接口
 * </p>
 *
 * @author banana
 * @since 2022-09-15
 */
public interface UmsMenuMapper extends BaseMapper<UmsMenu> {
    UmsMenu selectByPrimaryKey(Long id);
    int updateByPrimaryKeySelective(UmsMenu record);
    int updateByPrimaryKey(UmsMenu record);
    List<UmsMenu> selectByRoleIds(List<Long> roleIds);
    List<UmsMenu> getMenuNameId();
    List<String> getMenuNameByRoleId();
}

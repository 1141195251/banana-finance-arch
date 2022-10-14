package com.jluzh.admin.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jluzh.admin.dto.admin.StandardRoleOperationDto;
import com.jluzh.admin.model.UmsRoleOperation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author banana
 * @since 2022-09-17
 */
public interface UmsRoleOperationMapper extends BaseMapper<UmsRoleOperation> {
    Page<StandardRoleOperationDto> selectWithRoleName(Page<StandardRoleOperationDto> settings);
    int updateByPrimaryKeySelective(UmsRoleOperation opr);
}

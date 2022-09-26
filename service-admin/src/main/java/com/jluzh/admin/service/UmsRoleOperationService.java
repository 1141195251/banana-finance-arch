package com.jluzh.admin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jluzh.admin.dto.RoleOperationDto;
import com.jluzh.admin.dto.admin.StandardRoleOperationDto;
import com.jluzh.admin.model.UmsRoleOperation;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author banana
 * @since 2022-09-17
 */
public interface UmsRoleOperationService extends IService<UmsRoleOperation> {
    /**
     * 装载角色操作权限
     */
    List<RoleOperationDto> init(Long adminId);
    Page<StandardRoleOperationDto> selectWithRoleName(Long pageNum, Long pageSize);
}

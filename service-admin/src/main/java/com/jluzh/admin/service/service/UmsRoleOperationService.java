package com.jluzh.admin.service.service;

import com.jluzh.admin.dto.RoleOperationDto;
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
    public List<RoleOperationDto> init(Long adminId);
}

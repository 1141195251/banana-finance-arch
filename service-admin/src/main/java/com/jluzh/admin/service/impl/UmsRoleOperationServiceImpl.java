package com.jluzh.admin.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jluzh.admin.dto.OperationProp;
import com.jluzh.admin.dto.RoleOperationDto;
import com.jluzh.admin.dto.admin.StandardRoleOperationDto;
import com.jluzh.admin.mapper.UmsAdminRoleRelationMapper;
import com.jluzh.admin.model.UmsRole;
import com.jluzh.admin.model.UmsRoleOperation;
import com.jluzh.admin.mapper.UmsRoleOperationMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jluzh.admin.service.UmsRoleOperationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author banana
 * @since 2022-09-17
 */
@Service
public class UmsRoleOperationServiceImpl extends ServiceImpl<UmsRoleOperationMapper, UmsRoleOperation> implements UmsRoleOperationService {
    @Autowired
    private UmsAdminRoleRelationMapper adminRoleRelationMapper;
    @Override
    public List<RoleOperationDto> init(Long adminId) {
        List<UmsRole> roleList = adminRoleRelationMapper.getRoleList(adminId);
        // 当前账户没有角色就别搜了
        if(CollUtil.isEmpty(roleList)) {
            return null;
        }
        List<Long> roleIdList = new ArrayList<>();
        for(UmsRole umsRole: roleList) {
            roleIdList.add(umsRole.getId());
        }
        QueryWrapper<UmsRoleOperation> umsRoleOperationQueryWrapper = new QueryWrapper<>();
        umsRoleOperationQueryWrapper.in("role_id", roleIdList);
        List<UmsRoleOperation> roleOperationList = baseMapper.selectList(umsRoleOperationQueryWrapper);
        List<RoleOperationDto> roleOperationDtos = new ArrayList<>();
        for(UmsRoleOperation opr : roleOperationList) {
            RoleOperationDto oprDto = new RoleOperationDto();
            oprDto.setId(opr.getRoleId().toString());
            List<String> operationProp = new ArrayList<>();
            // TODO
            if(opr.getAdd() != 0) {
                operationProp.add("add");
            }
            if(opr.getEdit() != 0) {
                operationProp.add("edit");
            }
            if(opr.getFind() != 0) {
                operationProp.add("find");
            }
            if(opr.getDelete() != 0) {
                operationProp.add("delete");
            }
            oprDto.setOperation(operationProp);
            roleOperationDtos.add(oprDto);
        }
        return roleOperationDtos;
    }

    @Override
    public Page<StandardRoleOperationDto> selectWithRoleName(Long pageNum, Long pageSize) {
        Page<StandardRoleOperationDto> settings = new Page<>(pageNum, pageSize);
        Page<StandardRoleOperationDto> result = baseMapper.selectWithRoleName(settings);
        return result;
    }
}

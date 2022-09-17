package com.jluzh.admin.service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jluzh.admin.dto.OperationProp;
import com.jluzh.admin.dto.RoleOperationDto;
import com.jluzh.admin.mapper.UmsAdminRoleRelationMapper;
import com.jluzh.admin.model.UmsRole;
import com.jluzh.admin.model.UmsRoleOperation;
import com.jluzh.admin.mapper.UmsRoleOperationMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jluzh.admin.service.service.UmsRoleOperationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
            oprDto.setId(opr.getRoleId());
            OperationProp operationProp = new OperationProp();
            BeanUtils.copyProperties(opr, operationProp);
            oprDto.setOperation(operationProp);
            roleOperationDtos.add(oprDto);
        }
        return roleOperationDtos;
    }

}

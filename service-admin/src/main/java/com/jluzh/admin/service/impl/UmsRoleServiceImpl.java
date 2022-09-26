package com.jluzh.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jluzh.admin.dto.admin.RoleAndOperationDto;
import com.jluzh.admin.dto.admin.RolePageParam;
import com.jluzh.admin.mapper.UmsRoleMenuRelationMapper;
import com.jluzh.admin.mapper.UmsRoleOperationMapper;
import com.jluzh.admin.model.UmsMenu;
import com.jluzh.admin.model.UmsRole;
import com.jluzh.admin.mapper.UmsRoleMapper;
import com.jluzh.admin.model.UmsRoleOperation;
import com.jluzh.admin.service.UmsRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 后台用户角色表 服务实现类
 * </p>
 *
 * @author banana
 * @since 2022-09-15
 */
@Service
public class UmsRoleServiceImpl extends ServiceImpl<UmsRoleMapper, UmsRole> implements UmsRoleService {
    @Autowired
    private UmsRoleMenuRelationMapper roleMenuRelationMapper;
//    @Autowired
//    private UmsRoleResourceRelationMapper roleResourceRelationMapper;
    @Autowired
    private UmsRoleMapper roleMapper;

    @Autowired
    private UmsRoleOperationMapper roleOperationMapper;
//    @Autowired
//    private UmsResourceService resourceService;
    @Override
    public int create(UmsRole role) {
        QueryWrapper<UmsRole> query = new QueryWrapper<>();
        query.eq("name", role.getName());
        boolean isExists = baseMapper.exists(query);
        if(isExists) {
            return 0;
        }
        role.setCreateTime(new Date());
        role.setAdminCount(0);
        role.setSort(0);
        return roleMapper.insert(role);
    }

    @Override
    public int createRoleAndOperation(RoleAndOperationDto params) {
        QueryWrapper<UmsRole> query = new QueryWrapper<>();
        query.eq("name", params.getName());
        boolean isExists = baseMapper.exists(query);
        if(isExists) {
            return 0;
        }
        UmsRole umsRole = convertToRole(params);
        UmsRoleOperation opr = convertToOpr(params);
        int count = roleMapper.insert(umsRole);
        count = count + roleOperationMapper.insert(opr);
        return count;
    }
    private UmsRoleOperation convertToOpr(RoleAndOperationDto source) {
        if(source == null) {
            return null;
        }
        UmsRoleOperation opr = new UmsRoleOperation();
        opr.setAdd(source.getAdd());
        opr.setEdit(source.getEdit());
        opr.setFind(source.getFind());
        opr.setDelete(source.getDelete());
        return opr;
    }
    private UmsRole convertToRole(RoleAndOperationDto source) {
        if(source == null) {
            return null;
        }
        UmsRole target = new UmsRole();
        target.setId(source.getId());
        target.setName(source.getName());
        target.setSort(source.getSort());
        target.setDescription(source.getDescription());
        target.setStatus(source.getStatus());
        target.setCreateTime(new Date());
        target.setAdminCount(0);
        target.setSort(0);
        return target;
    }
    @Override
    public int update(Long id, UmsRole role) {
        role.setId(id);
        return roleMapper.updateByPrimaryKeySelective(role);
    }

    @Override
    public int update(Long id, RoleAndOperationDto role) {
        role.setId(id);
        UmsRole umsRole = convertToRole(role);
        int count = roleMapper.updateByPrimaryKeySelective(umsRole);
        UmsRoleOperation operation = convertToOpr(role);
        count = roleOperationMapper.updateByPrimaryKeySelective(operation);
        return count;
    }

    @Override
    public Page<UmsRole> listPage(RolePageParam param) {
        Page<UmsRole> pageSettings = new Page<>(param.getPageNum(), param.getPageSize());
        UmsRole conditions = convertToRole(param);
        Page<UmsRole> result = roleMapper.listPage(pageSettings, conditions);
        return result;
    }

    @Override
    public Page<RoleAndOperationDto> listRoleAndOperationPage(RoleAndOperationDto params) {
        Page<RoleAndOperationDto> settings = new Page<>(params.getPageNum(), params.getPageSize());
        Page<RoleAndOperationDto> result = roleMapper.listRoleAndOperationPage(settings, params);
        return result;
    }

    private UmsRole convertToRole(RolePageParam param) {
        UmsRole target = new UmsRole();
        target.setId(param.getId());
        target.setName(param.getName());
        target.setSort(param.getSort());
        target.setDescription(param.getDescription());
        target.setCreateTime(param.getCreateTime());
        target.setStatus(param.getStatus());
        target.setAdminCount(param.getAdminCount());
        return target;
    }

    @Override
    public int deleteById(Long id) {
        int rows = baseMapper.deleteById(id);
        return rows;
    }

    //
//    @Override
//    public int delete(List<Long> ids) {
//        UmsRoleExample example = new UmsRoleExample();
//        example.createCriteria().andIdIn(ids);
//        int count = roleMapper.deleteByExample(example);
//        resourceService.initResourceRolesMap();
//        return count;
//    }
//
//    @Override
//    public List<UmsRole> list() {
//        return roleMapper.selectByExample(new UmsRoleExample());
//    }
//
//    @Override
//    public List<UmsRole> list(String keyword, Integer pageSize, Integer pageNum) {
//        PageHelper.startPage(pageNum, pageSize);
//        UmsRoleExample example = new UmsRoleExample();
//        if (!StringUtils.isEmpty(keyword)) {
//            example.createCriteria().andNameLike("%" + keyword + "%");
//        }
//        return roleMapper.selectByExample(example);
//    }
//
    @Override
    public List<UmsMenu> getMenuList(Long adminId) {
        return roleMapper.getMenuList(adminId);
    }
//
    @Override
    public List<UmsMenu> listMenu(Long roleId) {
        return roleMapper.getMenuListByRoleId(roleId);
    }


    //
//    @Override
//    public List<UmsResource> listResource(Long roleId) {
//        return roleDao.getResourceListByRoleId(roleId);
//    }
//
//    @Override
//    public int allocMenu(Long roleId, List<Long> menuIds) {
//        //先删除原有关系
//        UmsRoleMenuRelationExample example=new UmsRoleMenuRelationExample();
//        example.createCriteria().andRoleIdEqualTo(roleId);
//        roleMenuRelationMapper.deleteByExample(example);
//        //批量插入新关系
//        for (Long menuId : menuIds) {
//            UmsRoleMenuRelation relation = new UmsRoleMenuRelation();
//            relation.setRoleId(roleId);
//            relation.setMenuId(menuId);
//            roleMenuRelationMapper.insert(relation);
//        }
//        return menuIds.size();
//    }
//
//    @Override
//    public int allocResource(Long roleId, List<Long> resourceIds) {
//        //先删除原有关系
//        UmsRoleResourceRelationExample example=new UmsRoleResourceRelationExample();
//        example.createCriteria().andRoleIdEqualTo(roleId);
//        roleResourceRelationMapper.deleteByExample(example);
//        //批量插入新关系
//        for (Long resourceId : resourceIds) {
//            UmsRoleResourceRelation relation = new UmsRoleResourceRelation();
//            relation.setRoleId(roleId);
//            relation.setResourceId(resourceId);
//            roleResourceRelationMapper.insert(relation);
//        }
//        resourceService.initResourceRolesMap();
//        return resourceIds.size();
//    }
}

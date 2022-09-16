package com.jluzh.admin.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jluzh.admin.mapper.UmsRoleMapper;
import com.jluzh.admin.mapper.UmsRoleResourceRelationMapper;
import com.jluzh.admin.model.UmsResource;
import com.jluzh.admin.mapper.UmsResourceMapper;
import com.jluzh.admin.model.UmsRole;
import com.jluzh.admin.model.UmsRoleResourceRelation;
import com.jluzh.admin.service.UmsResourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jluzh.constant.AuthConstant;
import com.jluzh.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 * 后台资源表 服务实现类
 * </p>
 *
 * @author banana
 * @since 2022-09-15
 */
@Service
public class UmsResourceServiceImpl extends ServiceImpl<UmsResourceMapper, UmsResource> implements UmsResourceService {
    @Resource(name = "umsResourceMapper")
    private UmsResourceMapper resourceMapper;
    @Resource(name = "umsRoleMapper")
    private UmsRoleMapper roleMapper;
    @Resource(name = "umsRoleResourceRelationMapper")
    private UmsRoleResourceRelationMapper roleResourceRelationMapper;
    @Resource
    private RedisService redisService;
    @Value("${spring.application.name}")
    private String applicationName;
//    @Override
//    public int create(UmsResource umsResource) {
//        umsResource.setCreateTime(new Date());
//        int count = resourceMapper.insert(umsResource);
//        initResourceRolesMap();
//        return count;
//    }
//
//    @Override
//    public int update(Long id, UmsResource umsResource) {
//        umsResource.setId(id);
//        int count = resourceMapper.updateByPrimaryKeySelective(umsResource);
//        initResourceRolesMap();
//        return count;
//    }
//
//    @Override
//    public UmsResource getItem(Long id) {
//        return resourceMapper.selectByPrimaryKey(id);
//    }
//
//    @Override
//    public int delete(Long id) {
//        int count = resourceMapper.deleteByPrimaryKey(id);
//        initResourceRolesMap();
//        return count;
//    }
//
//    @Override
//    public List<UmsResource> list(Long categoryId, String nameKeyword, String urlKeyword, Integer pageSize, Integer pageNum) {
//        PageHelper.startPage(pageNum,pageSize);
//        UmsResourceExample example = new UmsResourceExample();
//        UmsResourceExample.Criteria criteria = example.createCriteria();
//        if(categoryId!=null){
//            criteria.andCategoryIdEqualTo(categoryId);
//        }
//        if(StrUtil.isNotEmpty(nameKeyword)){
//            criteria.andNameLike('%'+nameKeyword+'%');
//        }
//        if(StrUtil.isNotEmpty(urlKeyword)){
//            criteria.andUrlLike('%'+urlKeyword+'%');
//        }
//        return resourceMapper.selectByExample(example);
//    }
//
//    @Override
//    public List<UmsResource> listAll() {
//        return resourceMapper.selectByExample(new UmsResourceExample());
//    }
//
    @Override
    public Map<String,List<String>> initResourceRolesMap() {
        Map<String,List<String>> resourceRoleMap = new TreeMap<>();
        // 查询资源表 TODO 缩小筛选列范围
        List<UmsResource> resourceList = baseMapper.selectList(null);
        // 查询角色表 TODO 缩小筛选列范围
        List<UmsRole> roleList = roleMapper.selectList(null);
        // 查询资源角色关系表
        List<UmsRoleResourceRelation> relationList = roleResourceRelationMapper.selectList(null);
        // 每次循环都是对当前资源对应的所有角色进行筛选
        // 类似数据库表连接，只不过转移到Java层面处理了
        for (UmsResource resource : resourceList) {
            Set<Long> roleIds = relationList.stream().filter(item -> item.getResourceId().equals(resource.getId())).map(UmsRoleResourceRelation::getRoleId).collect(Collectors.toSet());
            List<String> roleNames = roleList.stream().filter(item -> roleIds.contains(item.getId())).map(item -> item.getId() + "_" + item.getName()).collect(Collectors.toList());
            // exp: put("/service-api/user/currentUser", CollUtil.toList("ADMIN", "TEST"))
            resourceRoleMap.put("/"+applicationName+resource.getUrl(),roleNames);
        }
        // 覆盖之前存的
        redisService.del(AuthConstant.RESOURCE_ROLES_MAP_KEY);
        redisService.hSetAll(AuthConstant.RESOURCE_ROLES_MAP_KEY, resourceRoleMap);
        return resourceRoleMap;
    }
}

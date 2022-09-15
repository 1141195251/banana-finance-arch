package com.jluzh.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.jluzh.constant.AuthConstant;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 资源与角色匹配关系管理业务类
 */
@Service
public class ResourceServiceImpl {

    private Map<String, List<String>> resourceRolesMap;
    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @PostConstruct
    public void initData() {
//        // TODO 从数据库查询Role
//        resourceRolesMap = new TreeMap<>();
//        resourceRolesMap.put("/service-api/hello", CollUtil.toList("ADMIN"));
//        resourceRolesMap.put("/service-api/user/currentUser", CollUtil.toList("ADMIN", "TEST"));
//        redisTemplate.opsForHash().putAll(AuthConstant.RESOURCE_ROLES_MAP_KEY, resourceRolesMap);
    }
}

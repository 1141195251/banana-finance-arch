package com.jluzh.admin.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.BCUtil;
import cn.hutool.crypto.digest.BCrypt;
import cn.hutool.json.JSONUtil;
import com.alibaba.nacos.common.utils.CollectionUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jluzh.admin.dto.UmsAdminParam;
import com.jluzh.admin.dto.UpdateAdminPasswordParam;
import com.jluzh.admin.dto.admin.AdminListParam;
import com.jluzh.admin.dto.admin.AdminRoleTransferVo;
import com.jluzh.admin.dto.admin.AdminSuperListVo;
import com.jluzh.admin.mapper.UmsAdminLoginLogMapper;
import com.jluzh.admin.mapper.UmsAdminRoleRelationMapper;
import com.jluzh.admin.mapper.UmsRoleMapper;
import com.jluzh.admin.model.UmsAdmin;
import com.jluzh.admin.mapper.UmsAdminMapper;
import com.jluzh.admin.model.UmsAdminLoginLog;
import com.jluzh.admin.model.UmsAdminRoleRelation;
import com.jluzh.admin.model.UmsRole;
import com.jluzh.admin.service.AuthService;
import com.jluzh.admin.service.UmsAdminRoleRelationService;
import com.jluzh.admin.service.UmsAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jluzh.admin.service.UmsRoleService;
import com.jluzh.api.CommonResult;
import com.jluzh.api.ResultCode;
import com.jluzh.constant.AuthConstant;
import com.jluzh.domain.UserDto;
import com.jluzh.exception.Asserts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author banana
 * @since 2022-09-15
 */
@Service
public class UmsAdminServiceImpl extends ServiceImpl<UmsAdminMapper, UmsAdmin> implements UmsAdminService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UmsAdminServiceImpl.class);
    @Autowired
    private UmsAdminMapper adminMapper;
    @Autowired
    private UmsRoleMapper umsRoleMapper;
    @Autowired
    private UmsAdminRoleRelationMapper adminRoleRelationMapper;
    @Resource(name = "umsAdminLoginLogMapper")
    private UmsAdminLoginLogMapper loginLogMapper;
    @Resource(name = "umsAdminRoleRelationServiceImpl")
    private UmsAdminRoleRelationService umsAdminRoleRelationService;
    @Autowired
    private AuthService authService;
    @Autowired
    private HttpServletRequest request;

    @Override
    public UmsAdmin getAdminByUsername(String username) {
        // mysql数据库查询
        UmsAdmin usrFromDB = baseMapper.selectOne(new QueryWrapper<UmsAdmin>().eq("username", username));
        if (usrFromDB != null) {
            return usrFromDB;
        }
        return null;
    }

    @Override
    public UmsAdmin register(UmsAdminParam umsAdminParam) {
        UmsAdmin umsAdmin = new UmsAdmin();
        BeanUtils.copyProperties(umsAdminParam, umsAdmin);
        umsAdmin.setCreateTime(new Date());
        umsAdmin.setStatus(1);
        // 查询是否有相同用户名的用户
        QueryWrapper<UmsAdmin> umsAdminQueryWrapper = new QueryWrapper<>();
        umsAdminQueryWrapper.eq("username", umsAdminParam.getUsername());
        Long hasSimilar = baseMapper.selectCount(umsAdminQueryWrapper);
        if (hasSimilar > 0) { //  存在相同用户
            return null;
        }
        // 将密码进行加密操作
        String encodePassword = BCrypt.hashpw(umsAdmin.getPassword());
        umsAdmin.setPassword(encodePassword);
        adminMapper.insertSelective(umsAdmin);
        UmsAdminRoleRelation umsAdminRoleRelation = new UmsAdminRoleRelation();
        // 给新注册的账号设置默认角色
        umsAdminRoleRelation.setRoleId(5L);
        umsAdminRoleRelation.setAdminId(umsAdmin.getId());
        umsAdminRoleRelationService.save(umsAdminRoleRelation);
        return umsAdmin;
    }

    @Override
    public CommonResult login(String username, String password) {
        if(StrUtil.isEmpty(username) || StrUtil.isEmpty(password)) {
            Asserts.fail("用户名或密码不能为空！");
        }
        Map<String, String> params = new HashMap<>();
        // 前台登录用PORTAL_CLIENT_ID 后台ADMIN_CLIENT_ID
        params.put("client_id", AuthConstant.PORTAL_CLIENT_ID);
        params.put("client_secret","123456");
        params.put("grant_type","password");
        params.put("username",username);
        params.put("password",password);
        CommonResult restResult = authService.getAccessToken(params);
        // 响应200状态码并且带Data数据
        if(ResultCode.SUCCESS.getCode() == restResult.getCode() && restResult.getData() != null) {
            updateLoginTimeByUsername(username);
            insertLoginLog(username);
        }
        // 返回Token
        return restResult;
    }

    /**
     * 根据用户id获取多个角色id
     * @param adminId
     * @return
     */
    @Override
    public List<Long> getRoleIdsByAdminId(Long adminId) {
        return adminMapper.getRoleIdsByAdminId(adminId);
    }

    /**
     * 添加登录记录
     * @param username 用户名
     */

    private void insertLoginLog(String username) {
        UmsAdmin admin = getAdminByUsername(username);
        if(admin==null) return;
        UmsAdminLoginLog loginLog = new UmsAdminLoginLog();
        loginLog.setAdminId(admin.getId());
        loginLog.setCreateTime(new Date());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 从请求requestContext中获取ip地址
        loginLog.setIp(request.getRemoteAddr());
        loginLogMapper.insert(loginLog);
    }


    /**
     * 根据用户名修改登录时间
     * @param username 用户名
     */

    private void updateLoginTimeByUsername(String username) {
        UmsAdmin record = new UmsAdmin();
        record.setLoginTime(new Date());
        baseMapper.update(record, new UpdateWrapper<UmsAdmin>().eq("username", username));
    }

//    @Override
//    public UmsAdmin getItem(Long id) {
//        return adminMapper.selectByPrimaryKey(id);
//    }
//
    @Override
    public Page<UmsAdmin> list(AdminListParam param) {
        Page<UmsAdmin> pageSetting = new Page<>(param.getPageNum(), param.getPageSize());
        UmsAdmin umsAdmin = new UmsAdmin();
        BeanUtils.copyProperties(param, umsAdmin);
        Page<UmsAdmin> page = adminMapper.listPage(pageSetting, umsAdmin);
        return page;
    }

    @Override
    public Page<AdminSuperListVo> superList(AdminListParam param) {
        Page<UmsAdmin> pageSetting = new Page<>(param.getPageNum(), param.getPageSize());
        UmsAdmin umsAdmin = new UmsAdmin();
        BeanUtils.copyProperties(param, umsAdmin);
        Page<UmsAdmin> page = adminMapper.listPage(pageSetting, umsAdmin);
        List<UmsAdmin> records = page.getRecords();
        Page<AdminSuperListVo> voPage= new Page<>();
        List<AdminSuperListVo> collect = records.stream().map(item -> convertToSuperListVo(item)).collect(Collectors.toList());
        BeanUtils.copyProperties(page, voPage);
        voPage.setRecords(collect);
        return voPage;
    }

    private AdminSuperListVo convertToSuperListVo(UmsAdmin admin) {
        AdminSuperListVo listVo = AdminSuperListVo.builder()
                .email(admin.getEmail())
                .icon(admin.getIcon())
                .note(admin.getNote())
                .createTime(admin.getCreateTime())
                .loginTime(admin.getLoginTime())
                .status(admin.getStatus())
                .nickName(admin.getNickName())
                .innerData(new ArrayList())
                .username(admin.getUsername())
                .id(admin.getId())
                .build();
        return listVo;

    }
//
    @Override
    public int update(Long id, UmsAdmin admin) {
        admin.setId(id);
        UmsAdmin rawAdmin = baseMapper.selectById(admin.getId());
        if(BCrypt.checkpw(admin.getPassword(), rawAdmin.getPassword())){
            // 与原加密密码相同的不需要修改
            admin.setPassword(null);
        }else{
            // 空密码不设置
            if(StrUtil.isEmpty(admin.getPassword())){
                admin.setPassword(null);
            // 与原加密密码不同的需要加密修改
            }else{
                admin.setPassword(BCrypt.hashpw(admin.getPassword()));
            }
        }
        int count = adminMapper.updateByPrimaryKeySelective(admin);
        // TODO 如果用户信息存在了Redis 更新用户信息后需要删除原来的信息
        return count;
    }

    @Override
    public int deleteById(Long id) {
        int count = adminMapper.deleteById(id);
        QueryWrapper<UmsAdminRoleRelation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("admin_id", id);
        int count1 = adminRoleRelationMapper.delete(queryWrapper);
        return count + count1;
    }

    @Override
    public int updateRole(Long adminId, List<Long> roleIds) {
        int count = (roleIds == null || roleIds.isEmpty()) ? 0 : roleIds.size();
        // 先删除原来的关系
        QueryWrapper<UmsAdminRoleRelation> umsAdminRoleRelationQueryWrapper = new QueryWrapper<>();
        umsAdminRoleRelationQueryWrapper.eq("admin_id", adminId);
        adminRoleRelationMapper.delete(umsAdminRoleRelationQueryWrapper);
        // 建立新关系
        if (!CollectionUtils.isEmpty(roleIds)) {
            List<UmsAdminRoleRelation> list = new ArrayList<>();
            for (Long roleId : roleIds) {
                UmsAdminRoleRelation roleRelation = new UmsAdminRoleRelation();
                roleRelation.setAdminId(adminId);
                roleRelation.setRoleId(roleId);
                list.add(roleRelation);
            }
            count = adminRoleRelationMapper.insertList(list);
        }
        return count;
    }

    @Override
    public int updateRoleByUsername(String username, List<Long> roleIds) {
        int count = (roleIds == null || roleIds.isEmpty()) ? 0 : roleIds.size();
        QueryWrapper<UmsAdmin> umsAdminQueryWrapper = new QueryWrapper<>();
        umsAdminQueryWrapper.eq("username", username).select("id");
        UmsAdmin umsAdmin = baseMapper.selectOne(umsAdminQueryWrapper);
        // 先删除原来的关系
        QueryWrapper<UmsAdminRoleRelation> umsAdminRoleRelationQueryWrapper = new QueryWrapper<>();
        umsAdminRoleRelationQueryWrapper.eq("admin_id", umsAdmin.getId());
        adminRoleRelationMapper.delete(umsAdminRoleRelationQueryWrapper);
        if(count != 0) {
            // 建立新关系
            if (!CollectionUtils.isEmpty(roleIds)) {
                List<UmsAdminRoleRelation> list = new ArrayList<>();
                for (Long roleId : roleIds) {
                    UmsAdminRoleRelation roleRelation = new UmsAdminRoleRelation();
                    roleRelation.setAdminId(umsAdmin.getId());
                    roleRelation.setRoleId(roleId);
                    list.add(roleRelation);
                }
                count = adminRoleRelationMapper.insertList(list);
            }
        }
        return count;
    }

    @Override
    public List<UmsRole> getRoleList(Long adminId) {
        return adminRoleRelationMapper.getRoleList(adminId);
    }

    @Override
    public List<UmsRole> getRoleListByAdminName(String adminName) {
        return adminRoleRelationMapper.getRoleListByAdminName(adminName);
    }

    @Override
    public List<AdminRoleTransferVo> getAdminRoleTransferVo(String adminName) {
        List<UmsRole> roleListByAdminName = adminRoleRelationMapper.getRoleListByAdminName(adminName);
        List<UmsRole> allList = umsRoleMapper.selectList(null);
        List<AdminRoleTransferVo> roleListByAdminVo = roleListByAdminName.stream().map(item -> convertToTransferVo(item)).collect(Collectors.toList());
        List<AdminRoleTransferVo> allListVo = allList.stream().map(item -> convertToTransferVo(item)).collect(Collectors.toList());
        // 进行比较以便设置disable属性的值
        List<AdminRoleTransferVo> finalResult = allListVo.stream().map(item -> setChosenProp(item, roleListByAdminVo)).collect(Collectors.toList());
        return finalResult;
    }

    // 当condition的Key没有一个和Vo的Key一致则设置chosen属性为false
    private AdminRoleTransferVo setChosenProp(AdminRoleTransferVo vo, List<AdminRoleTransferVo> condition) {
        String key = vo.getKey();
        for(AdminRoleTransferVo vo1 : condition) {
            if(vo1.getKey().equals(key)) {
                vo.setChosen(true);
            }
        }
        return vo;
    }

    private AdminRoleTransferVo convertToTransferVo(UmsRole role) {
        AdminRoleTransferVo vo = AdminRoleTransferVo.builder()
                .key(role.getId().toString())
                .title(role.getName())
                .description(role.getDescription())
                .chosen(false)
                .build();
        return vo;
    }
//
//    @Override
//    public List<UmsResource> getResourceList(Long adminId) {
//        return adminRoleRelationDao.getResourceList(adminId);
//    }
//
    @Override
    public int updatePassword(UpdateAdminPasswordParam param) {
        if(StrUtil.isEmpty(param.getUsername())
                ||StrUtil.isEmpty(param.getOldPassword())
                ||StrUtil.isEmpty(param.getNewPassword())){
            return -1;
        }
        QueryWrapper<UmsAdmin> umsAdminQueryWrapper = new QueryWrapper<>();
        umsAdminQueryWrapper.eq("username", param.getUsername());
        List<UmsAdmin> umsAdmins = baseMapper.selectList(umsAdminQueryWrapper);
        if(CollUtil.isEmpty(umsAdmins)){
            return -2;
        }
        UmsAdmin umsAdmin = umsAdmins.get(0);
        if(!BCrypt.checkpw(param.getOldPassword(),umsAdmin.getPassword())){
            return -3;
        }
        umsAdmin.setPassword(BCrypt.hashpw(param.getNewPassword()));
        adminMapper.updateByPrimaryKeySelective(umsAdmin);
        return 1;
    }
//
    @Override
    public UserDto loadUserByUsername(String username){
        // 获取用户信息
        UmsAdmin admin = getAdminByUsername(username);
        if (admin != null) {
            List<UmsRole> roleList = getRoleList(admin.getId());
            UserDto userDTO = new UserDto();
            BeanUtils.copyProperties(admin,userDTO);
            if(CollUtil.isNotEmpty(roleList)){
                // 格式化Role然后封装进Dto
                // Exp:id_roleName 1_商品管理员
                List<String> roleStrList = roleList.stream().map(item -> item.getId() + "_" + item.getName()).collect(Collectors.toList());
                userDTO.setRoles(roleStrList);
            }
            return userDTO;
        }
        return null;
    }

    @Override
    public UmsAdmin getCurrentAdmin() {
        String userStr = request.getHeader(AuthConstant.USER_TOKEN_HEADER);
        if(StrUtil.isEmpty(userStr)){
            // 用户请求头为空抛出未授权异常
            Asserts.fail(ResultCode.UNAUTHORIZED);
        }
        UserDto userDto = JSONUtil.toBean(userStr, UserDto.class);
        // TODO 可考虑从缓存中获取用户信息而不是在数据库
        QueryWrapper<UmsAdmin> umsAdminQueryWrapper = new QueryWrapper<>();
        umsAdminQueryWrapper
                .eq("username", userDto.getUsername())
                .or()
                .eq("id", userDto.getId());
        UmsAdmin admin = baseMapper.selectOne(umsAdminQueryWrapper);
        if(admin != null){
            return admin;
        }else {
            // TODO 如果前边用的是Redis查询且查询不到则从数据库查询
            return null;
        }
    }
//
//    @Override
//    public UmsAdminCacheService getCacheService() {
//        return SpringUtil.getBean(UmsAdminCacheService.class);
//    }
//*/
}

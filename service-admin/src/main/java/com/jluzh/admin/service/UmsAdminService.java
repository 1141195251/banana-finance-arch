package com.jluzh.admin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jluzh.admin.dto.UmsAdminParam;
import com.jluzh.admin.dto.UpdateAdminPasswordParam;
import com.jluzh.admin.dto.admin.AdminListParam;
import com.jluzh.admin.dto.admin.AdminRoleTransferVo;
import com.jluzh.admin.dto.admin.AdminSuperListVo;
import com.jluzh.admin.model.UmsAdmin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jluzh.admin.model.UmsResource;
import com.jluzh.admin.model.UmsRole;
import com.jluzh.api.CommonResult;
import com.jluzh.domain.UserDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 后台用户表 服务类
 * </p>
 *
 * @author banana
 * @since 2022-09-15
 */
public interface UmsAdminService extends IService<UmsAdmin> {
    /**
     * 根据用户名获取后台管理员
     */
    UmsAdmin getAdminByUsername(String username);

    /**
     * 注册功能
     */
    UmsAdmin register(UmsAdminParam umsAdminParam);

    /**
     * 登录功能
     * @param username 用户名
     * @param password 密码
     * @return 调用认证中心返回结果
     */
    CommonResult login(String username, String password);

    /**
     * 根据用户id获取用户
     */
//    UmsAdmin getItem(Long id);

    /**
     * 根据用户名或昵称分页查询用户
     */
    Page<UmsAdmin> list(AdminListParam param);

    Page<AdminSuperListVo> superList(AdminListParam param);

    /**
     * 修改指定用户信息
     */
    int update(Long id, UmsAdmin admin);

    /**
     * 删除指定用户包括和他关联的角色关系表
     */
    @Transactional
    int deleteById(Long id);

    /**
     * 修改用户角色关系
     */
    @Transactional
    int updateRole(Long adminId, List<Long> roleIds);

    @Transactional
    int updateRoleByUsername(String username, List<Long> roleIds);
    /**
     * 获取用户对于角色
     */
    List<UmsRole> getRoleList(Long adminId);

    List<Long> getRoleIdsByAdminId(Long adminId);

    public List<UmsRole> getRoleListByAdminName(String adminName);

    public List<AdminRoleTransferVo> getAdminRoleTransferVo(String adminName);
    /**
     * 获取指定用户的可访问资源
     */
//    List<UmsResource> getResourceList(Long adminId);

    /**
     * 修改密码
     */
    int updatePassword(UpdateAdminPasswordParam updatePasswordParam);

    /**
     * 获取用户信息
     */
    UserDto loadUserByUsername(String username);

    /**
     * 获取当前登录后台用户
     */
    UmsAdmin getCurrentAdmin();

    /**
     * 获取缓存服务
     */
//    UmsAdminCacheService getCacheService();
}

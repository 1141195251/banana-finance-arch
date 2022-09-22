package com.jluzh.admin.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jluzh.admin.model.UmsAdmin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 后台用户表 Mapper 接口
 * </p>
 *
 * @author banana
 * @since 2022-09-15
 */
public interface UmsAdminMapper extends BaseMapper<UmsAdmin> {
    int updateByPrimaryKeySelective(UmsAdmin record);
    List<Long> getRoleIdsByAdminId(Long adminId);
    Page<UmsAdmin> listPage(Page<UmsAdmin> page, @Param("admin") UmsAdmin admin);
    long insertSelective(UmsAdmin record);

}

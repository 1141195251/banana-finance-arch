package com.jluzh.msm.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.jluzh.msm.entity.Job;

/**
 * 职位(Job)表数据库访问层
 *
 * @author panlaoliu
 * @since 2022-10-16 17:02:39
 */
public interface JobDao extends BaseMapper<Job> {

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Job> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Job> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Job> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Job> entities);

}


package com.jluzh.dao;


import com.jluzh.entity.TbReimbursementInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (TbReimbursementInfo)表数据库访问层
 *
 * @author makejava
 * @since 2022-10-07 10:36:31
 */
@Repository
public interface TbReimbursementInfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbReimbursementInfo queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param tbReimbursementInfo 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<TbReimbursementInfo> queryAllByLimit(TbReimbursementInfo tbReimbursementInfo, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param tbReimbursementInfo 查询条件
     * @return 总行数
     */
    long count(TbReimbursementInfo tbReimbursementInfo);

    /**
     * 新增数据
     *
     * @param tbReimbursementInfo 实例对象
     * @return 影响行数
     */
    int insert(TbReimbursementInfo tbReimbursementInfo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbReimbursementInfo> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TbReimbursementInfo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbReimbursementInfo> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TbReimbursementInfo> entities);

    /**
     * 修改数据
     *
     * @param tbReimbursementInfo 实例对象
     * @return 影响行数
     */
    int update(TbReimbursementInfo tbReimbursementInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<TbReimbursementInfo> selectAll();

}


package com.jluzh.dao;

import com.jluzh.entity.TbReimbursementItem;
import com.jluzh.entity.TbReimbursementRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (TbReimbursementRecord)表数据库访问层
 *
 * @author makejava
 * @since 2022-10-07 10:36:28
 */

public interface TbReimbursementRecordDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbReimbursementRecord queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param tbReimbursementRecord 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<TbReimbursementRecord> queryAllByLimit(TbReimbursementRecord tbReimbursementRecord, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param tbReimbursementRecord 查询条件
     * @return 总行数
     */
    long count(TbReimbursementRecord tbReimbursementRecord);

    /**
     * 新增数据
     *
     * @param tbReimbursementRecord 实例对象
     * @return 影响行数
     */
    int insert(TbReimbursementRecord tbReimbursementRecord);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbReimbursementRecord> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TbReimbursementRecord> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbReimbursementRecord> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TbReimbursementRecord> entities);

    /**
     * 修改数据
     *
     * @param tbReimbursementRecord 实例对象
     * @return 影响行数
     */
    int update(TbReimbursementRecord tbReimbursementRecord);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<TbReimbursementRecord> queryAll();

}


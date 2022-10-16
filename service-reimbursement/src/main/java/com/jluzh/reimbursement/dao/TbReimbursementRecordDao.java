package com.jluzh.reimbursement.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jluzh.reimbursement.entity.TbReimbursementRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (TbReimbursementRecord)表数据库访问层
 *
 * @author panlaoliu
 * @since 2022-10-16 22:24:10
 */
public interface TbReimbursementRecordDao extends BaseMapper<TbReimbursementRecord> {

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

}


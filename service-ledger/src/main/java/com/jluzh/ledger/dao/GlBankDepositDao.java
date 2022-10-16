package com.jluzh.ledger.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.jluzh.ledger.entity.GlBankDeposit;

/**
 * 银行存款总账(GlBankDeposit)表数据库访问层
 *
 * @author panlaoliu
 * @since 2022-10-16 16:39:08
 */
public interface GlBankDepositDao extends BaseMapper<GlBankDeposit> {

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<GlBankDeposit> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<GlBankDeposit> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<GlBankDeposit> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<GlBankDeposit> entities);

}


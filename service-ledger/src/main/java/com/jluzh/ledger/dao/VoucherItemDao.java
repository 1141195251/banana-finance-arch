package com.jluzh.ledger.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.jluzh.ledger.entity.VoucherItem;

/**
 * 凭证单(VoucherItem)表数据库访问层
 *
 * @author panlaoliu
 * @since 2022-10-16 16:39:11
 */
public interface VoucherItemDao extends BaseMapper<VoucherItem> {

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<VoucherItem> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<VoucherItem> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<VoucherItem> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<VoucherItem> entities);

}


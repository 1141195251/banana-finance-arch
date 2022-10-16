package com.jluzh.risk.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.jluzh.risk.entity.RsRiskCategory;

/**
 * 风险分类表(RsRiskCategory)表数据库访问层
 *
 * @author panlaoliu
 * @since 2022-10-16 16:46:49
 */
public interface RsRiskCategoryDao extends BaseMapper<RsRiskCategory> {

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<RsRiskCategory> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<RsRiskCategory> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<RsRiskCategory> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<RsRiskCategory> entities);

}


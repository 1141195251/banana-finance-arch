package com.jluzh.dao;


import com.jluzh.entity.TbReimbursementInfo;
import com.jluzh.entity.TbReimbursementItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (TbReimbursementItem)表数据库访问层
 *
 * @author makejava
 * @since 2022-10-07 10:36:23
 */

public interface TbReimbursementItemDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbReimbursementItem queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param tbReimbursementItem 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<TbReimbursementItem> queryAllByLimit(TbReimbursementItem tbReimbursementItem, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param tbReimbursementItem 查询条件
     * @return 总行数
     */
    long count(TbReimbursementItem tbReimbursementItem);

    /**
     * 新增数据
     *
     * @param tbReimbursementItem 实例对象
     * @return 影响行数
     */
    int insert(TbReimbursementItem tbReimbursementItem);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbReimbursementItem> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TbReimbursementItem> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbReimbursementItem> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TbReimbursementItem> entities);

    /**
     * 修改数据
     *
     * @param tbReimbursementItem 实例对象
     * @return 影响行数
     */
    int update(TbReimbursementItem tbReimbursementItem);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<TbReimbursementItem> queryAll();

}


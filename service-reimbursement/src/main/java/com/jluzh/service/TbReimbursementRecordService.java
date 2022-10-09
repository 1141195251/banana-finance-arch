package com.jluzh.service;


import com.jluzh.entity.TbReimbursementItem;
import com.jluzh.entity.TbReimbursementRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (TbReimbursementRecord)表服务接口
 *
 * @author makejava
 * @since 2022-10-07 10:36:31
 */
public interface TbReimbursementRecordService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbReimbursementRecord queryById(Integer id);

    /**
     * 分页查询
     *
     * @param tbReimbursementRecord 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<TbReimbursementRecord> queryByPage(TbReimbursementRecord tbReimbursementRecord, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param tbReimbursementRecord 实例对象
     * @return 实例对象
     */
    TbReimbursementRecord insert(TbReimbursementRecord tbReimbursementRecord);

    /**
     * 修改数据
     *
     * @param tbReimbursementRecord 实例对象
     * @return 实例对象
     */
    TbReimbursementRecord update(TbReimbursementRecord tbReimbursementRecord);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    List<TbReimbursementRecord> insertBatch();

    List<TbReimbursementRecord> queryAll();

    Boolean writeExcel();

    void readExcel();

}

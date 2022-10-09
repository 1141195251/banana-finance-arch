package com.jluzh.service;


import com.jluzh.entity.TbReimbursementInfo;
import com.jluzh.entity.TbReimbursementItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (TbReimbursementItem)表服务接口
 *
 * @author makejava
 * @since 2022-10-07 10:36:27
 */
public interface TbReimbursementItemService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbReimbursementItem queryById(Integer id);

    /**
     * 分页查询
     *
     * @param tbReimbursementItem 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<TbReimbursementItem> queryByPage(TbReimbursementItem tbReimbursementItem, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param tbReimbursementItem 实例对象
     * @return 实例对象
     */
    TbReimbursementItem insert(TbReimbursementItem tbReimbursementItem);

    /**
     * 修改数据
     *
     * @param tbReimbursementItem 实例对象
     * @return 实例对象
     */
    TbReimbursementItem update(TbReimbursementItem tbReimbursementItem);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    List<TbReimbursementItem> insertBatch();

    List<TbReimbursementItem> queryAll();

    Boolean writeExcel();

    void readExcel();
}

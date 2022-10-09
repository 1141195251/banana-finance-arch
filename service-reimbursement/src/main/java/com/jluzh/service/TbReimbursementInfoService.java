package com.jluzh.service;


import com.jluzh.entity.TbReimbursementInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (TbReimbursementInfo)表服务接口
 *
 * @author makejava
 * @since 2022-10-07 10:36:31
 */
public interface TbReimbursementInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbReimbursementInfo queryById(Integer id);

    /**
     * 分页查询
     *
     * @param tbReimbursementInfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<TbReimbursementInfo> queryByPage(TbReimbursementInfo tbReimbursementInfo, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param tbReimbursementInfo 实例对象
     * @return 实例对象
     */
    TbReimbursementInfo insert(TbReimbursementInfo tbReimbursementInfo);

    /**
     * 修改数据
     *
     * @param tbReimbursementInfo 实例对象
     * @return 实例对象
     */
    TbReimbursementInfo update(TbReimbursementInfo tbReimbursementInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);


    List<TbReimbursementInfo> insertBatch();

    List<TbReimbursementInfo> queryAll();

    Boolean writeExcel();

    void readExcel();

}

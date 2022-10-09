package com.jluzh.service.impl;


import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.read.builder.ExcelReaderSheetBuilder;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.jluzh.dao.TbReimbursementItemDao;
import com.jluzh.entity.TbReimbursementInfo;
import com.jluzh.entity.TbReimbursementItem;
import com.jluzh.listener.TbReimbursementInfoListener;
import com.jluzh.listener.TbReimbursementItemListener;
import com.jluzh.service.TbReimbursementItemService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (TbReimbursementItem)表服务实现类
 *
 * @author makejava
 * @since 2022-10-07 10:36:28
 */
@Service("tbReimbursementItemService")
public class TbReimbursementItemServiceImpl implements TbReimbursementItemService {
    @Resource
    private TbReimbursementItemDao tbReimbursementItemDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbReimbursementItem queryById(Integer id) {
        return this.tbReimbursementItemDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param tbReimbursementItem 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<TbReimbursementItem> queryByPage(TbReimbursementItem tbReimbursementItem, PageRequest pageRequest) {
        long total = this.tbReimbursementItemDao.count(tbReimbursementItem);
        return new PageImpl<>(this.tbReimbursementItemDao.queryAllByLimit(tbReimbursementItem, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param tbReimbursementItem 实例对象
     * @return 实例对象
     */
    @Override
    public TbReimbursementItem insert(TbReimbursementItem tbReimbursementItem) {
        this.tbReimbursementItemDao.insert(tbReimbursementItem);
        return tbReimbursementItem;
    }

    /**
     * 修改数据
     *
     * @param tbReimbursementItem 实例对象
     * @return 实例对象
     */
    @Override
    public TbReimbursementItem update(TbReimbursementItem tbReimbursementItem) {
        this.tbReimbursementItemDao.update(tbReimbursementItem);
        return this.queryById(tbReimbursementItem.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tbReimbursementItemDao.deleteById(id) > 0;
    }

    @Override
    public List<TbReimbursementItem> insertBatch() {
        String excelPath = "";
        List<TbReimbursementItem> entities = new ArrayList<TbReimbursementItem>();
        this.tbReimbursementItemDao.insert((TbReimbursementItem) entities);
        return entities;
    }

    @Override
    public List<TbReimbursementItem> queryAll() {
        return tbReimbursementItemDao.queryAll();
    }

    @Override
    public Boolean writeExcel() {
        List<TbReimbursementItem> entities = queryAll();
        if (entities == null) {
            return false;
        }
        ExcelWriterBuilder workBook = EasyExcel.write("D:\\Excel\\reimbursementItem.xlsx", TbReimbursementItem.class);
        workBook.sheet().doWrite(entities);
        return true;
    }

    public void readExcel() {

        // 读取文件，读取完之后会自动关闭
        /*
        	head			每行数据对应的实体；Student.class
        	readListener	读监听器，每读一样就会调用一次该监听器的invoke方法

        	sheet方法参数： 工作表的顺序号（从0开始）或者工作表的名字，不传默认为0
        */
        // 封装工作簿对象
        ExcelReaderBuilder workBook = EasyExcel.read
                ("d:\\Excel\\reimbursementItem.xlsx", TbReimbursementItem.class, new TbReimbursementItemListener(tbReimbursementItemDao));

        // 封装工作表
        ExcelReaderSheetBuilder sheet1 = workBook.sheet();
        // 读取
        sheet1.doRead();
    }


}

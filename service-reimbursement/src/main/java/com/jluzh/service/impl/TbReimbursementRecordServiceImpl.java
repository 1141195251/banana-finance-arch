package com.jluzh.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.read.builder.ExcelReaderSheetBuilder;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.jluzh.dao.TbReimbursementRecordDao;
import com.jluzh.entity.TbReimbursementItem;
import com.jluzh.entity.TbReimbursementRecord;
import com.jluzh.entity.TbReimbursementRecord;
import com.jluzh.listener.TbReimbursementItemListener;
import com.jluzh.listener.TbReimbursementRecordListener;
import com.jluzh.service.TbReimbursementRecordService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (TbReimbursementRecord)表服务实现类
 *
 * @author makejava
 * @since 2022-10-07 10:36:31
 */
@Service("tbReimbursementRecordService")
public class TbReimbursementRecordServiceImpl implements TbReimbursementRecordService {
    @Resource
    private TbReimbursementRecordDao tbReimbursementRecordDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbReimbursementRecord queryById(Integer id) {
        return this.tbReimbursementRecordDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param tbReimbursementRecord 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<TbReimbursementRecord> queryByPage(TbReimbursementRecord tbReimbursementRecord, PageRequest pageRequest) {
        long total = this.tbReimbursementRecordDao.count(tbReimbursementRecord);
        return new PageImpl<>(this.tbReimbursementRecordDao.queryAllByLimit(tbReimbursementRecord, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param tbReimbursementRecord 实例对象
     * @return 实例对象
     */
    @Override
    public TbReimbursementRecord insert(TbReimbursementRecord tbReimbursementRecord) {
        this.tbReimbursementRecordDao.insert(tbReimbursementRecord);
        return tbReimbursementRecord;
    }

    /**
     * 修改数据
     *
     * @param tbReimbursementRecord 实例对象
     * @return 实例对象
     */
    @Override
    public TbReimbursementRecord update(TbReimbursementRecord tbReimbursementRecord) {
        this.tbReimbursementRecordDao.update(tbReimbursementRecord);
        return this.queryById(tbReimbursementRecord.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tbReimbursementRecordDao.deleteById(id) > 0;
    }

    @Override
    public List<TbReimbursementRecord> insertBatch() {
        String excelPath = "";
        List<TbReimbursementRecord> entities = new ArrayList<TbReimbursementRecord>();
        this.tbReimbursementRecordDao.insert((TbReimbursementRecord) entities);
        return entities;
    }

    @Override
    public List<TbReimbursementRecord> queryAll() {
        return tbReimbursementRecordDao.queryAll();
    }

    @Override
    public Boolean writeExcel() {
        List<TbReimbursementRecord> entities = queryAll();
        if (entities == null) {
            return false;
        }
        ExcelWriterBuilder workBook = EasyExcel.write("D:\\Excel\\reimbursementRecord.xlsx", TbReimbursementRecord.class);
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
                ("d:\\Excel\\reimbursementItem.xlsx", TbReimbursementRecord.class, new TbReimbursementRecordListener(tbReimbursementRecordDao));

        // 封装工作表
        ExcelReaderSheetBuilder sheet1 = workBook.sheet();
        // 读取
        sheet1.doRead();
    }

}

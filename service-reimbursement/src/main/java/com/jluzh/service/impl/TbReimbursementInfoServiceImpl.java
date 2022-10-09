package com.jluzh.service.impl;


import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.read.builder.ExcelReaderSheetBuilder;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.jluzh.dao.TbReimbursementInfoDao;
import com.jluzh.entity.TbReimbursementInfo;
import com.jluzh.listener.TbReimbursementInfoListener;
import com.jluzh.service.TbReimbursementInfoService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import com.jluzh.entity.TbReimbursementInfo;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (TbReimbursementInfo)表服务实现类
 *
 * @author makejava
 * @since 2022-10-07 10:36:31
 */
@Service("tbReimbursementInfoService")
public class TbReimbursementInfoServiceImpl implements TbReimbursementInfoService {
    @Resource
    private TbReimbursementInfoDao tbReimbursementInfoDao;


    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbReimbursementInfo queryById(Integer id) {
        return this.tbReimbursementInfoDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param tbReimbursementInfo 筛选条件
     * @param pageRequest         分页对象
     * @return 查询结果
     */
    @Override
    public Page<TbReimbursementInfo> queryByPage(TbReimbursementInfo tbReimbursementInfo, PageRequest pageRequest) {
        long total = this.tbReimbursementInfoDao.count(tbReimbursementInfo);
        return new PageImpl<>(this.tbReimbursementInfoDao.queryAllByLimit(tbReimbursementInfo, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param tbReimbursementInfo 实例对象
     * @return 实例对象
     */
    @Override
    public TbReimbursementInfo insert(TbReimbursementInfo tbReimbursementInfo) {
        this.tbReimbursementInfoDao.insert(tbReimbursementInfo);
        return tbReimbursementInfo;
    }

    /**
     * 修改数据
     *
     * @param tbReimbursementInfo 实例对象
     * @return 实例对象
     */
    @Override
    public TbReimbursementInfo update(TbReimbursementInfo tbReimbursementInfo) {
        this.tbReimbursementInfoDao.update(tbReimbursementInfo);
        return this.queryById(tbReimbursementInfo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tbReimbursementInfoDao.deleteById(id) > 0;
    }


    @Override
    public List<TbReimbursementInfo> insertBatch() {
        String excelPath = "";
        List<TbReimbursementInfo> entities = new ArrayList<TbReimbursementInfo>();
        this.tbReimbursementInfoDao.insert((TbReimbursementInfo) entities);
        return entities;
    }

    @Override
    public List<TbReimbursementInfo> queryAll() {
        return tbReimbursementInfoDao.selectAll();
    }


    @Override
    public Boolean writeExcel() {
        List<TbReimbursementInfo> entities = queryAll();
        if (entities == null) {
            return false;
        }
        ExcelWriterBuilder workBook = EasyExcel.write("D:\\Excel\\reimbursementInfo.xlsx", TbReimbursementInfo.class);
        workBook.sheet().doWrite(entities);
        return true;
    }

    public void readExcel() {

        // 读取文件，读取完之后会自动关闭
        /*
        	pathName  		文件路径；"d:\\杭州黑马在线202003班学员信息.xls"
        	head			每行数据对应的实体；Student.class
        	readListener	读监听器，每读一样就会调用一次该监听器的invoke方法

        	sheet方法参数： 工作表的顺序号（从0开始）或者工作表的名字，不传默认为0
        */
        // 封装工作簿对象
        ExcelReaderBuilder workBook = EasyExcel.read
                ("d:\\Excel\\reimbursement.xlsx", TbReimbursementInfo.class, new TbReimbursementInfoListener(tbReimbursementInfoDao));

        // 封装工作表
        ExcelReaderSheetBuilder sheet1 = workBook.sheet();
        // 读取
        sheet1.doRead();
    }
}

package com.jluzh.reimbursement.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jluzh.reimbursement.dao.TbReimbursementRecordDao;
import com.jluzh.reimbursement.entity.TbReimbursementInfo;
import com.jluzh.reimbursement.entity.TbReimbursementRecord;
import com.jluzh.reimbursement.listener.TbReimbursementInfoListener;
import com.jluzh.reimbursement.listener.TbReimbursementRecordListener;
import com.jluzh.reimbursement.service.TbReimbursementRecordService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.List;

/**
 * (TbReimbursementRecord)表服务实现类
 *
 * @author panlaoliu
 * @since 2022-10-16 22:24:11
 */
@Service("tbReimbursementRecordService")
public class TbReimbursementRecordServiceImpl extends ServiceImpl<TbReimbursementRecordDao, TbReimbursementRecord> implements TbReimbursementRecordService {
    @Resource
    private TbReimbursementRecordDao tbReimbursementRecordDao;

    /**
     * 文件下载（失败了会返回一个有部分数据的Excel）
     * <p>
     * 1. 创建excel对应的实体对象 参照DownloadData
     * <p>
     * 2. 设置返回的 参数
     * <p>
     * 3. 直接写，这里注意，finish的时候会自动关闭OutputStream,当然你外面再关闭流问题不大
     */
    @Override
    public Boolean writeExcel(HttpServletResponse response) throws IOException {
        List<TbReimbursementRecord> entities = tbReimbursementRecordDao.selectList(null);
        if (entities == null) {
            return false;
        }
        // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode("测试", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), TbReimbursementRecord.class).sheet("模板").doWrite(entities);
        return true;
    }

    @Override
    public boolean readExcel(MultipartFile file) {
        if(file == null) {
            return false;
        }
        try {
            InputStream inputStream = file.getInputStream();
            // 读取文件，读取完之后会自动关闭
            /*
                pathName  		文件路径；"d:\\杭州黑马在线202003班学员信息.xls"
                head			每行数据对应的实体；Student.class
                readListener	读监听器，每读一样就会调用一次该监听器的invoke方法

                sheet方法参数： 工作表的顺序号（从0开始）或者工作表的名字，不传默认为0
            */
            EasyExcel
                    .read(inputStream, TbReimbursementRecord.class, new TbReimbursementRecordListener(tbReimbursementRecordDao))
                    .sheet()   // 封装工作表
                    .doRead(); // 读取
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}


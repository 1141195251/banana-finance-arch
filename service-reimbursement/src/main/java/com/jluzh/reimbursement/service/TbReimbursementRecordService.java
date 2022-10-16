package com.jluzh.reimbursement.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jluzh.reimbursement.entity.TbReimbursementRecord;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * (TbReimbursementRecord)表服务接口
 *
 * @author panlaoliu
 * @since 2022-10-16 22:24:11
 */
public interface TbReimbursementRecordService extends IService<TbReimbursementRecord> {
    Boolean writeExcel(HttpServletResponse response) throws IOException;
    boolean readExcel(MultipartFile file);
}


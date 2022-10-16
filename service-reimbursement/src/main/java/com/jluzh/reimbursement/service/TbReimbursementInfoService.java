package com.jluzh.reimbursement.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jluzh.reimbursement.entity.TbReimbursementInfo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * (TbReimbursementInfo)表服务接口
 *
 * @author panlaoliu
 * @since 2022-10-16 22:24:12
 */
public interface TbReimbursementInfoService extends IService<TbReimbursementInfo> {
    Boolean writeExcel(HttpServletResponse response) throws IOException;
    boolean readExcel(MultipartFile file);
}


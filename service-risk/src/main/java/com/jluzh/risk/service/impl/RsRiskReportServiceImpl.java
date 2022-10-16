package com.jluzh.risk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jluzh.risk.dao.RsRiskReportDao;
import com.jluzh.risk.entity.RsRiskReport;
import com.jluzh.risk.service.RsRiskReportService;
import org.springframework.stereotype.Service;

/**
 * 风险报告(RsRiskReport)表服务实现类
 *
 * @author panlaoliu
 * @since 2022-10-16 16:46:49
 */
@Service("rsRiskReportService")
public class RsRiskReportServiceImpl extends ServiceImpl<RsRiskReportDao, RsRiskReport> implements RsRiskReportService {

}


package com.jluzh.risk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jluzh.risk.dao.RsRiskDao;
import com.jluzh.risk.entity.RsRisk;
import com.jluzh.risk.service.RsRiskService;
import org.springframework.stereotype.Service;

/**
 * 风险表(RsRisk)表服务实现类
 *
 * @author panlaoliu
 * @since 2022-10-16 16:46:48
 */
@Service("rsRiskService")
public class RsRiskServiceImpl extends ServiceImpl<RsRiskDao, RsRisk> implements RsRiskService {

}


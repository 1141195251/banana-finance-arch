package com.jluzh.ledger.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jluzh.ledger.dao.GlBankDepositDao;
import com.jluzh.ledger.entity.GlBankDeposit;
import com.jluzh.ledger.service.GlBankDepositService;
import org.springframework.stereotype.Service;

/**
 * 银行存款总账(GlBankDeposit)表服务实现类
 *
 * @author panlaoliu
 * @since 2022-10-16 16:39:09
 */
@Service("glBankDepositService")
public class GlBankDepositServiceImpl extends ServiceImpl<GlBankDepositDao, GlBankDeposit> implements GlBankDepositService {

}


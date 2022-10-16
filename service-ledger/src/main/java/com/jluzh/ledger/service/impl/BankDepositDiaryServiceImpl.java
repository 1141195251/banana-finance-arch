package com.jluzh.ledger.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jluzh.ledger.dao.BankDepositDiaryDao;
import com.jluzh.ledger.entity.BankDepositDiary;
import com.jluzh.ledger.service.BankDepositDiaryService;
import org.springframework.stereotype.Service;

/**
 * 银行存款日记(BankDepositDiary)表服务实现类
 *
 * @author panlaoliu
 * @since 2022-10-16 16:39:06
 */
@Service("bankDepositDiaryService")
public class BankDepositDiaryServiceImpl extends ServiceImpl<BankDepositDiaryDao, BankDepositDiary> implements BankDepositDiaryService {

}


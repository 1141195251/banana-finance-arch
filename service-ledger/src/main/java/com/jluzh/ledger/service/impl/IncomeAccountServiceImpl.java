package com.jluzh.ledger.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jluzh.ledger.dao.IncomeAccountDao;
import com.jluzh.ledger.entity.IncomeAccount;
import com.jluzh.ledger.service.IncomeAccountService;
import org.springframework.stereotype.Service;

/**
 * 收入账表(IncomeAccount)表服务实现类
 *
 * @author panlaoliu
 * @since 2022-10-16 16:39:09
 */
@Service("incomeAccountService")
public class IncomeAccountServiceImpl extends ServiceImpl<IncomeAccountDao, IncomeAccount> implements IncomeAccountService {

}


package com.jluzh.ledger.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jluzh.ledger.dao.DtProductionAccountDao;
import com.jluzh.ledger.entity.DtProductionAccount;
import com.jluzh.ledger.service.DtProductionAccountService;
import org.springframework.stereotype.Service;

/**
 * 生产成本明细账(DtProductionAccount)表服务实现类
 *
 * @author panlaoliu
 * @since 2022-10-16 16:39:08
 */
@Service("dtProductionAccountService")
public class DtProductionAccountServiceImpl extends ServiceImpl<DtProductionAccountDao, DtProductionAccount> implements DtProductionAccountService {

}


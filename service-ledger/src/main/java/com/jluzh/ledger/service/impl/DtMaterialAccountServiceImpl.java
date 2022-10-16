package com.jluzh.ledger.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jluzh.ledger.dao.DtMaterialAccountDao;
import com.jluzh.ledger.entity.DtMaterialAccount;
import com.jluzh.ledger.service.DtMaterialAccountService;
import org.springframework.stereotype.Service;

/**
 * 原材料明细账(DtMaterialAccount)表服务实现类
 *
 * @author panlaoliu
 * @since 2022-10-16 16:39:08
 */
@Service("dtMaterialAccountService")
public class DtMaterialAccountServiceImpl extends ServiceImpl<DtMaterialAccountDao, DtMaterialAccount> implements DtMaterialAccountService {

}


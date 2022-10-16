package com.jluzh.ledger.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jluzh.ledger.dao.DtAccountReceivableDao;
import com.jluzh.ledger.entity.DtAccountReceivable;
import com.jluzh.ledger.service.DtAccountReceivableService;
import org.springframework.stereotype.Service;

/**
 * 应收款明细账(DtAccountReceivable)表服务实现类
 *
 * @author panlaoliu
 * @since 2022-10-16 16:39:07
 */
@Service("dtAccountReceivableService")
public class DtAccountReceivableServiceImpl extends ServiceImpl<DtAccountReceivableDao, DtAccountReceivable> implements DtAccountReceivableService {

}


package com.jluzh.ledger.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jluzh.ledger.dao.DtImprestDao;
import com.jluzh.ledger.entity.DtImprest;
import com.jluzh.ledger.service.DtImprestService;
import org.springframework.stereotype.Service;

/**
 * 备用金明细账(DtImprest)表服务实现类
 *
 * @author panlaoliu
 * @since 2022-10-16 16:39:07
 */
@Service("dtImprestService")
public class DtImprestServiceImpl extends ServiceImpl<DtImprestDao, DtImprest> implements DtImprestService {

}


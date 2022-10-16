package com.jluzh.ledger.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jluzh.ledger.dao.TransferVoucherDao;
import com.jluzh.ledger.entity.TransferVoucher;
import com.jluzh.ledger.service.TransferVoucherService;
import org.springframework.stereotype.Service;

/**
 * 转账凭证(TransferVoucher)表服务实现类
 *
 * @author panlaoliu
 * @since 2022-10-16 16:39:11
 */
@Service("transferVoucherService")
public class TransferVoucherServiceImpl extends ServiceImpl<TransferVoucherDao, TransferVoucher> implements TransferVoucherService {

}


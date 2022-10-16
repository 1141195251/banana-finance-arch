package com.jluzh.ledger.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jluzh.ledger.dao.ReceiptVoucherDao;
import com.jluzh.ledger.entity.ReceiptVoucher;
import com.jluzh.ledger.service.ReceiptVoucherService;
import org.springframework.stereotype.Service;

/**
 * 收款凭证(ReceiptVoucher)表服务实现类
 *
 * @author panlaoliu
 * @since 2022-10-16 16:39:10
 */
@Service("receiptVoucherService")
public class ReceiptVoucherServiceImpl extends ServiceImpl<ReceiptVoucherDao, ReceiptVoucher> implements ReceiptVoucherService {

}


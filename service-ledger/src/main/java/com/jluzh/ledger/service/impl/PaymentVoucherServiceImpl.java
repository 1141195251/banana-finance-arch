package com.jluzh.ledger.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jluzh.ledger.dao.PaymentVoucherDao;
import com.jluzh.ledger.entity.PaymentVoucher;
import com.jluzh.ledger.service.PaymentVoucherService;
import org.springframework.stereotype.Service;

/**
 * 付款凭证(PaymentVoucher)表服务实现类
 *
 * @author panlaoliu
 * @since 2022-10-16 16:39:10
 */
@Service("paymentVoucherService")
public class PaymentVoucherServiceImpl extends ServiceImpl<PaymentVoucherDao, PaymentVoucher> implements PaymentVoucherService {

}


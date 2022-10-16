package com.jluzh.ledger.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jluzh.ledger.dao.VoucherItemDao;
import com.jluzh.ledger.entity.VoucherItem;
import com.jluzh.ledger.service.VoucherItemService;
import org.springframework.stereotype.Service;

/**
 * 凭证单(VoucherItem)表服务实现类
 *
 * @author panlaoliu
 * @since 2022-10-16 16:39:11
 */
@Service("voucherItemService")
public class VoucherItemServiceImpl extends ServiceImpl<VoucherItemDao, VoucherItem> implements VoucherItemService {

}


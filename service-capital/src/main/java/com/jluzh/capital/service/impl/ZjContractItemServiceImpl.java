package com.jluzh.capital.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jluzh.capital.dao.ZjContractItemDao;
import com.jluzh.capital.entity.ZjContractItem;
import com.jluzh.capital.service.ZjContractItemService;
import org.springframework.stereotype.Service;

/**
 * 合同付款表(ZjContractItem)表服务实现类
 *
 * @author panlaoliu
 * @since 2022-10-16 16:57:48
 */
@Service("zjContractItemService")
public class ZjContractItemServiceImpl extends ServiceImpl<ZjContractItemDao, ZjContractItem> implements ZjContractItemService {

}


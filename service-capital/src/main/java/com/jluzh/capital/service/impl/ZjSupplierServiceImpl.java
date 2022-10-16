package com.jluzh.capital.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jluzh.capital.dao.ZjSupplierDao;
import com.jluzh.capital.entity.ZjSupplier;
import com.jluzh.capital.service.ZjSupplierService;
import org.springframework.stereotype.Service;

/**
 * 供应商(ZjSupplier)表服务实现类
 *
 * @author panlaoliu
 * @since 2022-10-16 16:57:48
 */
@Service("zjSupplierService")
public class ZjSupplierServiceImpl extends ServiceImpl<ZjSupplierDao, ZjSupplier> implements ZjSupplierService {

}


package com.jluzh.capital.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jluzh.capital.dao.ZjAccountSummaryDao;
import com.jluzh.capital.entity.ZjAccountSummary;
import com.jluzh.capital.service.ZjAccountSummaryService;
import org.springframework.stereotype.Service;

/**
 * 科目汇总表(ZjAccountSummary)表服务实现类
 *
 * @author panlaoliu
 * @since 2022-10-16 16:57:49
 */
@Service("zjAccountSummaryService")
public class ZjAccountSummaryServiceImpl extends ServiceImpl<ZjAccountSummaryDao, ZjAccountSummary> implements ZjAccountSummaryService {

}


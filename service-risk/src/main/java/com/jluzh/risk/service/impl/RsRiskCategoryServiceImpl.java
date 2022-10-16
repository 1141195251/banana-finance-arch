package com.jluzh.risk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jluzh.risk.dao.RsRiskCategoryDao;
import com.jluzh.risk.entity.RsRiskCategory;
import com.jluzh.risk.service.RsRiskCategoryService;
import org.springframework.stereotype.Service;

/**
 * 风险分类表(RsRiskCategory)表服务实现类
 *
 * @author panlaoliu
 * @since 2022-10-16 16:46:49
 */
@Service("rsRiskCategoryService")
public class RsRiskCategoryServiceImpl extends ServiceImpl<RsRiskCategoryDao, RsRiskCategory> implements RsRiskCategoryService {

}


package com.jluzh.msm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jluzh.msm.dao.CompanyDao;
import com.jluzh.msm.entity.Company;
import com.jluzh.msm.service.CompanyService;
import org.springframework.stereotype.Service;

/**
 * 公司(Company)表服务实现类
 *
 * @author panlaoliu
 * @since 2022-10-16 17:02:38
 */
@Service("companyService")
public class CompanyServiceImpl extends ServiceImpl<CompanyDao, Company> implements CompanyService {

}


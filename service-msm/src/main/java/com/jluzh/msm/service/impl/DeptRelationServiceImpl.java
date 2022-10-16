package com.jluzh.msm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jluzh.msm.dao.DeptRelationDao;
import com.jluzh.msm.entity.DeptRelation;
import com.jluzh.msm.service.DeptRelationService;
import org.springframework.stereotype.Service;

/**
 * 部门关系(DeptRelation)表服务实现类
 *
 * @author panlaoliu
 * @since 2022-10-16 17:02:39
 */
@Service("deptRelationService")
public class DeptRelationServiceImpl extends ServiceImpl<DeptRelationDao, DeptRelation> implements DeptRelationService {

}


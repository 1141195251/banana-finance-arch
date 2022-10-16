package com.jluzh.msm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jluzh.msm.dao.DeptDao;
import com.jluzh.msm.entity.Dept;
import com.jluzh.msm.service.DeptService;
import org.springframework.stereotype.Service;

/**
 * 部门(Dept)表服务实现类
 *
 * @author panlaoliu
 * @since 2022-10-16 17:02:39
 */
@Service("deptService")
public class DeptServiceImpl extends ServiceImpl<DeptDao, Dept> implements DeptService {

}


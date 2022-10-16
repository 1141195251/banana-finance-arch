package com.jluzh.msm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jluzh.msm.dao.JobDao;
import com.jluzh.msm.entity.Job;
import com.jluzh.msm.service.JobService;
import org.springframework.stereotype.Service;

/**
 * 职位(Job)表服务实现类
 *
 * @author panlaoliu
 * @since 2022-10-16 17:02:39
 */
@Service("jobService")
public class JobServiceImpl extends ServiceImpl<JobDao, Job> implements JobService {

}


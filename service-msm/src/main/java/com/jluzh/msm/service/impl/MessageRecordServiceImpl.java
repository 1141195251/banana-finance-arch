package com.jluzh.msm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jluzh.msm.dao.MessageRecordDao;
import com.jluzh.msm.entity.MessageRecord;
import com.jluzh.msm.service.MessageRecordService;
import org.springframework.stereotype.Service;

/**
 * 消息推送记录表(MessageRecord)表服务实现类
 *
 * @author panlaoliu
 * @since 2022-10-16 03:59:50
 */
@Service("messageRecordService")
public class MessageRecordServiceImpl extends ServiceImpl<MessageRecordDao, MessageRecord> implements MessageRecordService {

}


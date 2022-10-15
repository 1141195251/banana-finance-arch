package com.jluzh.msm.entity;


import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.*;
import lombok.Data;

/**
 * 消息推送记录表(MessageRecord)表实体类
 *
 * @author panlaoliu
 * @since 2022-10-16 03:59:49
 */
@Data
@ApiModel("消息推送记录表")
public class MessageRecord implements Serializable {
    private static final long serialVersionUID = 112129476201552745L;

    @ApiModelProperty("编号")
    private Long id;

    @ApiModelProperty("消息模板ID")
    private Integer templateId;

    @ApiModelProperty("推送渠道")
    private Integer toType;

    @ApiModelProperty("消息接收者ID")
    private Long receiverId;

    @ApiModelProperty("消息推送内容")
    private String content;

    @ApiModelProperty("创建人")
    private Long createBy;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("修改人")
    private Long updateBy;

    @ApiModelProperty("修改时间")
    private Date updateTime;

}


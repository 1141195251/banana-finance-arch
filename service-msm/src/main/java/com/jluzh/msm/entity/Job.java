package com.jluzh.msm.entity;


import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.*;
import lombok.Data;

/**
 * 职位(Job)表实体类
 *
 * @author panlaoliu
 * @since 2022-10-16 17:02:39
 */
@Data
@ApiModel("职位")
public class Job implements Serializable {
    private static final long serialVersionUID = 586464444851661000L;

    @ApiModelProperty("编号")
    private Integer id;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("描述")
    private String comment;

    @ApiModelProperty("创建日期")
    private Date createTime;

}


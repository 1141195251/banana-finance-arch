package com.jluzh.msm.entity;


import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.*;
import lombok.Data;

/**
 * 公司(Company)表实体类
 *
 * @author panlaoliu
 * @since 2022-10-16 17:02:38
 */
@Data
@ApiModel("公司")
public class Company implements Serializable {
    private static final long serialVersionUID = 801724913560255677L;

    @ApiModelProperty("编号")
    private Long id;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("描述")
    private String comment;

    @ApiModelProperty("创建日期")
    private Date createTime;

}


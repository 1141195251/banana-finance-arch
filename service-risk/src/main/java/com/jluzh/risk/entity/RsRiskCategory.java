package com.jluzh.risk.entity;


import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.*;
import lombok.Data;

/**
 * 风险分类表(RsRiskCategory)表实体类
 *
 * @author panlaoliu
 * @since 2022-10-16 16:46:49
 */
@Data
@ApiModel("风险分类表")
public class RsRiskCategory implements Serializable {
    private static final long serialVersionUID = 694048302427030359L;

    @ApiModelProperty("编号")
    private Long id;

    @ApiModelProperty("风险名称")
    private String riskCategoryName;

    @ApiModelProperty("创建日期")
    private Date createTime;

}


package com.jluzh.ledger.entity;


import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.*;
import lombok.Data;

/**
 * 备用金明细账(DtImprest)表实体类
 *
 * @author panlaoliu
 * @since 2022-10-16 16:39:07
 */
@Data
@ApiModel("备用金明细账")
public class DtImprest implements Serializable {
    private static final long serialVersionUID = -81695715354640623L;

    @ApiModelProperty("编号")
    private Long id;

    @ApiModelProperty("科目ID")
    private Integer accountId;

    @ApiModelProperty("报销金额")
    private Double amount;

    @ApiModelProperty("摘要")
    private String summary;

    @ApiModelProperty("借方金额")
    private Double debitMoney;

    @ApiModelProperty("贷出日期")
    private Date lendDate;

    @ApiModelProperty("凭证字号")
    private String voucherId;

    @ApiModelProperty("收回金额")
    private Double takeAmount;

}


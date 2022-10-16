package com.jluzh.ledger.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 备用金明细账(DtImprest)表实体类
 *
 * @author panlaoliu
 * @since 2022-10-17 01:19:39
 */
@Data
@ApiModel("备用金明细账")
public class DtImprest implements Serializable {
    private static final long serialVersionUID = -18657331831268664L;

    @ApiModelProperty("编号")
    private Long id;

    @ApiModelProperty("科目ID")
    private Integer accountId;

    @ApiModelProperty("报销金额")
    private BigDecimal amount;

    @ApiModelProperty("摘要")
    private String summary;

    @ApiModelProperty("借方金额")
    private BigDecimal debitMoney;

    @ApiModelProperty("贷出日期")
    private Date lendDate;

    @ApiModelProperty("凭证字号")
    private String voucherId;

    @ApiModelProperty("收回金额")
    private BigDecimal takeAmount;

}


package com.jluzh.ledger.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 银行存款总账(GlBankDeposit)表实体类
 *
 * @author panlaoliu
 * @since 2022-10-17 01:19:39
 */
@Data
@ApiModel("银行存款总账")
public class GlBankDeposit implements Serializable {
    private static final long serialVersionUID = -45199803804254507L;

    @ApiModelProperty("编号")
    private Long id;

    @ApiModelProperty("凭证字号")
    private String voucherId;

    @ApiModelProperty("摘要")
    private String summary;

    @ApiModelProperty("借方")
    private BigDecimal debtor;

    @ApiModelProperty("贷方")
    private BigDecimal creditor;

    @ApiModelProperty("借或贷")
    private String jhd;

    @ApiModelProperty("余额")
    private BigDecimal balance;

}


package com.jluzh.ledger.entity;


import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.*;
import lombok.Data;

/**
 * 银行存款总账(GlBankDeposit)表实体类
 *
 * @author panlaoliu
 * @since 2022-10-16 16:39:09
 */
@Data
@ApiModel("银行存款总账")
public class GlBankDeposit implements Serializable {
    private static final long serialVersionUID = 734575926344005842L;

    @ApiModelProperty("编号")
    private Long id;

    @ApiModelProperty("凭证字号")
    private String voucherId;

    @ApiModelProperty("摘要")
    private String summary;

    @ApiModelProperty("借方")
    private Double debtor;

    @ApiModelProperty("贷方")
    private Double creditor;

    @ApiModelProperty("借或贷")
    private String jhd;

    @ApiModelProperty("余额")
    private Double balance;

}


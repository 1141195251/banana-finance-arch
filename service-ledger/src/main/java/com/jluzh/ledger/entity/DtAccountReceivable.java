package com.jluzh.ledger.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 应收款明细账(DtAccountReceivable)表实体类
 *
 * @author panlaoliu
 * @since 2022-10-17 01:19:39
 */
@Data
@ApiModel("应收款明细账")
public class DtAccountReceivable implements Serializable {
    private static final long serialVersionUID = 239642348407736168L;

    @ApiModelProperty("编号")
    private Long id;

    @ApiModelProperty("创建日期")
    private Date createTime;

    @ApiModelProperty("凭证字号")
    private String voucherId;

    @ApiModelProperty("摘要")
    private String summary;

    @ApiModelProperty("借方")
    private BigDecimal debtor;

    @ApiModelProperty("贷方")
    private BigDecimal lender;

    @ApiModelProperty("借或贷")
    private String jhd;

    @ApiModelProperty("余额")
    private BigDecimal balance;

}


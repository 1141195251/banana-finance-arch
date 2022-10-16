package com.jluzh.ledger.entity;


import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.*;
import lombok.Data;

/**
 * 应收款明细账(DtAccountReceivable)表实体类
 *
 * @author panlaoliu
 * @since 2022-10-16 16:39:06
 */
@Data
@ApiModel("应收款明细账")
public class DtAccountReceivable implements Serializable {
    private static final long serialVersionUID = -68889242216462020L;

    @ApiModelProperty("编号")
    private Long id;

    @ApiModelProperty("创建日期")
    private Date createTime;

    @ApiModelProperty("凭证字号")
    private String voucherId;

    @ApiModelProperty("摘要")
    private String summary;

    @ApiModelProperty("借方")
    private Double debtor;

    @ApiModelProperty("贷方")
    private Double lender;

    @ApiModelProperty("借或贷")
    private String jhd;

    @ApiModelProperty("余额")
    private Double balance;

}


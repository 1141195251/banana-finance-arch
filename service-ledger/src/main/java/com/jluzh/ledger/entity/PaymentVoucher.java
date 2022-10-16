package com.jluzh.ledger.entity;


import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.*;
import lombok.Data;

/**
 * 付款凭证(PaymentVoucher)表实体类
 *
 * @author panlaoliu
 * @since 2022-10-16 16:39:10
 */
@Data
@ApiModel("付款凭证")
public class PaymentVoucher implements Serializable {
    private static final long serialVersionUID = -28716350837848033L;

    @ApiModelProperty("凭证字号")
    private String id;

    @ApiModelProperty("贷方科目")
    private Integer creditorAccountId;

    @ApiModelProperty("创建日期")
    private Date createDate;

    @ApiModelProperty("摘要")
    private String summary;

    @ApiModelProperty("借方一级科目")
    private Integer lenderAccountId;

    @ApiModelProperty("借方明细科目")
    private Integer lenderActiveAccountId;

    @ApiModelProperty("一级科目金额")
    private Double accountMoney;

    @ApiModelProperty("明细科目金额")
    private Double activeAcountMoney;

    @ApiModelProperty("审核")
    private Long auditor;

    @ApiModelProperty("会计主管")
    private Long supervisor;

}


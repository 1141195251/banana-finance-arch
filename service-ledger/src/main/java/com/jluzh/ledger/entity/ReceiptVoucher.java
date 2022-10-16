package com.jluzh.ledger.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 收款凭证(ReceiptVoucher)表实体类
 *
 * @author panlaoliu
 * @since 2022-10-17 01:19:39
 */
@Data
@ApiModel("收款凭证")
public class ReceiptVoucher implements Serializable {
    private static final long serialVersionUID = -74475766873214565L;

    @ApiModelProperty("凭证字号")
    private String id;

    @ApiModelProperty("借方科目")
    private Integer lenderAccountId;

    @ApiModelProperty("创建日期")
    private Date createTime;

    @ApiModelProperty("摘要")
    private String summary;

    @ApiModelProperty("贷方一级科目")
    private Integer creditorAccountId;

    @ApiModelProperty("贷方明细科目")
    private Integer creditorActiveAccountId;

    @ApiModelProperty("一级科目金额")
    private BigDecimal accountMoney;

    @ApiModelProperty("明细科目金额")
    private BigDecimal activeAcountMoney;

    @ApiModelProperty("审核")
    private Long auditor;

    @ApiModelProperty("会计主管")
    private Long supervisor;

}


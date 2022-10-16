package com.jluzh.ledger.entity;


import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.*;
import lombok.Data;

/**
 * 收款凭证(ReceiptVoucher)表实体类
 *
 * @author panlaoliu
 * @since 2022-10-16 16:39:10
 */
@Data
@ApiModel("收款凭证")
public class ReceiptVoucher implements Serializable {
    private static final long serialVersionUID = -42786265441195532L;

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
    private Double accountMoney;

    @ApiModelProperty("明细科目金额")
    private Double activeAcountMoney;

    @ApiModelProperty("审核")
    private Long auditor;

    @ApiModelProperty("会计主管")
    private Long supervisor;

}


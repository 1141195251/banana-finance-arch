package com.jluzh.ledger.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 转账凭证(TransferVoucher)表实体类
 *
 * @author panlaoliu
 * @since 2022-10-17 01:19:40
 */
@Data
@ApiModel("转账凭证")
public class TransferVoucher implements Serializable {
    private static final long serialVersionUID = -98942038116124549L;

    @ApiModelProperty("凭证字号")
    private String id;

    @ApiModelProperty("创建日期")
    private Date createTime;

    @ApiModelProperty("摘要")
    private String summary;

    @ApiModelProperty("一级科目")
    private Integer accountId;

    @ApiModelProperty("明细科目")
    private Integer activeAccountId;

    @ApiModelProperty("借方一级科目金额")
    private BigDecimal lenderAccountMoney;

    @ApiModelProperty("借方明细科目金额")
    private BigDecimal lenderActiveAccountMoney;

    @ApiModelProperty("贷方一级科目金额")
    private BigDecimal creditorAccountMoney;

    @ApiModelProperty("贷方明细科目金额")
    private BigDecimal creditorActiveAccountMoney;

    @ApiModelProperty("审核")
    private Long auditor;

    @ApiModelProperty("会计主管")
    private Long supervisor;

}


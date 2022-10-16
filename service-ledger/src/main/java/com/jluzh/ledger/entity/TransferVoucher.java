package com.jluzh.ledger.entity;


import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.*;
import lombok.Data;

/**
 * 转账凭证(TransferVoucher)表实体类
 *
 * @author panlaoliu
 * @since 2022-10-16 16:39:11
 */
@Data
@ApiModel("转账凭证")
public class TransferVoucher implements Serializable {
    private static final long serialVersionUID = -69261475404536506L;

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
    private Double lenderAccountMoney;

    @ApiModelProperty("借方明细科目金额")
    private Double lenderActiveAccountMoney;

    @ApiModelProperty("贷方一级科目金额")
    private Double creditorAccountMoney;

    @ApiModelProperty("贷方明细科目金额")
    private Double creditorActiveAccountMoney;

    @ApiModelProperty("审核")
    private Long auditor;

    @ApiModelProperty("会计主管")
    private Long supervisor;

}


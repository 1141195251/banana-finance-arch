package com.jluzh.ledger.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 银行存款日记(BankDepositDiary)表实体类
 *
 * @author panlaoliu
 * @since 2022-10-17 01:19:38
 */
@Data
@ApiModel("银行存款日记")
public class BankDepositDiary implements Serializable {
    private static final long serialVersionUID = 252028355085274806L;

    @ApiModelProperty("编号")
    private Long id;

    @ApiModelProperty("日期")
    private Date createTime;

    @ApiModelProperty("凭证字号")
    private String voucherId;

    @ApiModelProperty("摘要")
    private String summary;

    @ApiModelProperty("对方科目账号")
    private Integer toAccountId;

    @ApiModelProperty("收入")
    private BigDecimal income;

    @ApiModelProperty("支出")
    private BigDecimal expense;

    @ApiModelProperty("结余")
    private BigDecimal balance;

}


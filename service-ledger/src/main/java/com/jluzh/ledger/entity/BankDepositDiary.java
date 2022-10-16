package com.jluzh.ledger.entity;


import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.*;
import lombok.Data;

/**
 * 银行存款日记(BankDepositDiary)表实体类
 *
 * @author panlaoliu
 * @since 2022-10-16 16:39:06
 */
@Data
@ApiModel("银行存款日记")
public class BankDepositDiary implements Serializable {
    private static final long serialVersionUID = -11821143393575393L;

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
    private Double income;

    @ApiModelProperty("支出")
    private Double expense;

    @ApiModelProperty("结余")
    private Double balance;

}


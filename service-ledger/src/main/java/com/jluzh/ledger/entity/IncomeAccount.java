package com.jluzh.ledger.entity;


import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.*;
import lombok.Data;

/**
 * 收入账表(IncomeAccount)表实体类
 *
 * @author panlaoliu
 * @since 2022-10-16 16:39:09
 */
@Data
@ApiModel("收入账表")
public class IncomeAccount implements Serializable {
    private static final long serialVersionUID = 454240734414554501L;

    @ApiModelProperty("编号")
    private Long id;

    @ApiModelProperty("项目名称")
    private String itemName;

    @ApiModelProperty("本日")
    private Double today;

    @ApiModelProperty("本月累计")
    private Double monthTotal;

    @ApiModelProperty("本年累计")
    private Double yearTotal;

    @ApiModelProperty("昨日结存")
    private Double lastBalance;

    @ApiModelProperty("今日结存")
    private Double balance;

    @ApiModelProperty("出纳员")
    private Integer cashier;

}


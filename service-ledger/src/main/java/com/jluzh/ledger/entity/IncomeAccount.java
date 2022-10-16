package com.jluzh.ledger.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 收入账表(IncomeAccount)表实体类
 *
 * @author panlaoliu
 * @since 2022-10-17 01:19:39
 */
@Data
@ApiModel("收入账表")
public class IncomeAccount implements Serializable {
    private static final long serialVersionUID = 154280568118728696L;

    @ApiModelProperty("编号")
    private Long id;

    @ApiModelProperty("项目名称")
    private String itemName;

    @ApiModelProperty("本日")
    private BigDecimal today;

    @ApiModelProperty("本月累计")
    private BigDecimal monthTotal;

    @ApiModelProperty("本年累计")
    private BigDecimal yearTotal;

    @ApiModelProperty("昨日结存")
    private BigDecimal lastBalance;

    @ApiModelProperty("今日结存")
    private BigDecimal balance;

    @ApiModelProperty("出纳员")
    private Integer cashier;

}


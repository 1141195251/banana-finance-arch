package com.jluzh.ledger.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 原材料明细账(DtMaterialAccount)表实体类
 *
 * @author panlaoliu
 * @since 2022-10-17 01:19:39
 */
@Data
@ApiModel("原材料明细账")
public class DtMaterialAccount implements Serializable {
    private static final long serialVersionUID = 205033756576556203L;

    @ApiModelProperty("编号")
    private Long id;

    @ApiModelProperty("创建日期")
    private Date createTime;

    @ApiModelProperty("凭证字号")
    private String voucherId;

    @ApiModelProperty("摘要")
    private String summary;

    @ApiModelProperty("收入数量")
    private Integer inCount;

    @ApiModelProperty("收入单价")
    private BigDecimal inUnitPrice;

    @ApiModelProperty("收入金额")
    private BigDecimal inPrice;

    @ApiModelProperty("发出数量")
    private Integer outCount;

    @ApiModelProperty("发出单价")
    private BigDecimal outUprice;

    @ApiModelProperty("发出金额")
    private BigDecimal outPrice;

    @ApiModelProperty("结存数量")
    private Integer balanceCount;

    @ApiModelProperty("结存单价")
    private BigDecimal balanceUprice;

    @ApiModelProperty("结存金额")
    private BigDecimal balance;

}


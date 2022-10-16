package com.jluzh.ledger.entity;


import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.*;
import lombok.Data;

/**
 * 原材料明细账(DtMaterialAccount)表实体类
 *
 * @author panlaoliu
 * @since 2022-10-16 16:39:07
 */
@Data
@ApiModel("原材料明细账")
public class DtMaterialAccount implements Serializable {
    private static final long serialVersionUID = -17734884186040155L;

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
    private Double inUnitPrice;

    @ApiModelProperty("收入金额")
    private Double inPrice;

    @ApiModelProperty("发出数量")
    private Integer outCount;

    @ApiModelProperty("发出单价")
    private Double outUprice;

    @ApiModelProperty("发出金额")
    private Double outPrice;

    @ApiModelProperty("结存数量")
    private Integer balanceCount;

    @ApiModelProperty("结存单价")
    private Double balanceUprice;

    @ApiModelProperty("结存金额")
    private Double balance;

}


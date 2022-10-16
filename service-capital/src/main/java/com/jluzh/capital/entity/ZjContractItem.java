package com.jluzh.capital.entity;


import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.*;
import lombok.Data;

/**
 * 合同付款表(ZjContractItem)表实体类
 *
 * @author panlaoliu
 * @since 2022-10-16 16:57:48
 */
@Data
@ApiModel("合同付款表")
public class ZjContractItem implements Serializable {
    private static final long serialVersionUID = 635049944669133224L;

    @ApiModelProperty("编号")
    private Integer id;

    @ApiModelProperty("合同名称")
    private String contractName;

    @ApiModelProperty("供应商")
    private Integer supplierId;

    @ApiModelProperty("收款方")
    private Integer accountId;

    @ApiModelProperty("金额")
    private Double price;

    @ApiModelProperty("已开票金额")
    private Double invoiceAmount;

    @ApiModelProperty("已付款金额")
    private Double paidAmount;

    @ApiModelProperty("未付款金额")
    private Double unpayAmount;

    @ApiModelProperty("创建日期")
    private Date createTime;

}


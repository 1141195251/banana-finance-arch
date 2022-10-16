package com.jluzh.capital.entity;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.*;
import lombok.Data;

/**
 * 科目汇总表(ZjAccountSummary)表实体类
 *
 * @author panlaoliu
 * @since 2022-10-17 01:23:02
 */
@Data
@ApiModel("科目汇总表")
public class ZjAccountSummary implements Serializable {
    private static final long serialVersionUID = -66692588663556927L;

    @ApiModelProperty("编号")
    private Integer id;

    @ApiModelProperty("公司编号")
    private Integer accountId;

    @ApiModelProperty("本期借方发生额")
    private BigDecimal debtorAccrual;

    @ApiModelProperty("本期贷方发生额")
    private BigDecimal creditorAccrual;

    @ApiModelProperty("创建日期")
    private Date createTime;

}


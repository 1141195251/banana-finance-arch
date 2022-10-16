package com.jluzh.ledger.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 凭证单(VoucherItem)表实体类
 *
 * @author panlaoliu
 * @since 2022-10-17 01:19:39
 */
@Data
@ApiModel("凭证单")
public class VoucherItem implements Serializable {
    private static final long serialVersionUID = 565342979504945437L;

    @ApiModelProperty("凭证单号")
    private Long id;

    @ApiModelProperty("流程标题")
    private String title;

    @ApiModelProperty("申请人")
    private Long applicant;

    @ApiModelProperty("申请部门")
    private Integer deptId;

    @ApiModelProperty("申请日期")
    private Date appDate;

    @ApiModelProperty("总金额")
    private BigDecimal total;

    @ApiModelProperty("凭证状态")
    private String status;

    @ApiModelProperty("凭证返回说明")
    private String comment;

}


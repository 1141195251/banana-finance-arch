package com.jluzh.ledger.entity;


import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.*;
import lombok.Data;

/**
 * 凭证单(VoucherItem)表实体类
 *
 * @author panlaoliu
 * @since 2022-10-16 16:39:11
 */
@Data
@ApiModel("凭证单")
public class VoucherItem implements Serializable {
    private static final long serialVersionUID = 561020843062069739L;

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
    private Double total;

    @ApiModelProperty("凭证状态")
    private String status;

    @ApiModelProperty("凭证返回说明")
    private String comment;

}


package com.jluzh.ledger.entity;


import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.*;
import lombok.Data;

/**
 * 生产成本明细账(DtProductionAccount)表实体类
 *
 * @author panlaoliu
 * @since 2022-10-16 16:39:08
 */
@Data
@ApiModel("生产成本明细账")
public class DtProductionAccount implements Serializable {
    private static final long serialVersionUID = -85983817045456146L;

    @ApiModelProperty("编号")
    private Long id;

    @ApiModelProperty("创建日期")
    private Date createTime;

    @ApiModelProperty("凭证字号")
    private String voucherId;

    @ApiModelProperty("摘要")
    private String summary;

    @ApiModelProperty("直接材料")
    private Double materialCost;

    @ApiModelProperty("直接人工")
    private Double labourCost;

    @ApiModelProperty("制造费用")
    private Double productionCost;

    @ApiModelProperty("合计")
    private Double total;

}


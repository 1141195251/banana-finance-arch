package com.jluzh.ledger.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 生产成本明细账(DtProductionAccount)表实体类
 *
 * @author panlaoliu
 * @since 2022-10-17 01:19:39
 */
@Data
@ApiModel("生产成本明细账")
public class DtProductionAccount implements Serializable {
    private static final long serialVersionUID = -67738561769979662L;

    @ApiModelProperty("编号")
    private Long id;

    @ApiModelProperty("创建日期")
    private Date createTime;

    @ApiModelProperty("凭证字号")
    private String voucherId;

    @ApiModelProperty("摘要")
    private String summary;

    @ApiModelProperty("直接材料")
    private BigDecimal materialCost;

    @ApiModelProperty("直接人工")
    private BigDecimal labourCost;

    @ApiModelProperty("制造费用")
    private BigDecimal productionCost;

    @ApiModelProperty("合计")
    private BigDecimal total;

}


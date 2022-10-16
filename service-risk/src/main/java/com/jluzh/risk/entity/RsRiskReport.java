package com.jluzh.risk.entity;


import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.*;
import lombok.Data;

/**
 * 风险报告(RsRiskReport)表实体类
 *
 * @author panlaoliu
 * @since 2022-10-16 16:46:49
 */
@Data
@ApiModel("风险报告")
public class RsRiskReport implements Serializable {
    private static final long serialVersionUID = -85228225523494497L;

    @ApiModelProperty("编号")
    private Integer id;

    @ApiModelProperty("风险ID")
    private Integer riskId;

    @ApiModelProperty("分析")
    private String analysis;

    @ApiModelProperty("措施")
    private String measure;

    @ApiModelProperty("创建日期")
    private Date createTime;

}


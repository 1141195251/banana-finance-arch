package com.jluzh.risk.entity;


import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.*;
import lombok.Data;

/**
 * 风险表(RsRisk)表实体类
 *
 * @author panlaoliu
 * @since 2022-10-16 16:46:48
 */
@Data
@ApiModel("风险表")
public class RsRisk implements Serializable {
    private static final long serialVersionUID = -40346314058650605L;

    @ApiModelProperty("编号")
    private Long id;

    @ApiModelProperty("风险名称")
    private String riskName;

    @ApiModelProperty("风险分类ID")
    private Integer riskCategoryId;

    @ApiModelProperty("创建日期")
    private Date createTime;

}


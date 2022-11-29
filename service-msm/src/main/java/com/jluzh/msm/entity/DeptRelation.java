package com.jluzh.msm.entity;


import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.*;
import lombok.Data;

/**
 * 部门关系(DeptRelation)表实体类
 *
 * @author panlaoliu
 * @since 2022-10-16 17:02:39
 */
@Data
@ApiModel("部门关系")
public class DeptRelation implements Serializable {
    private static final long serialVersionUID = -80936464504323206L;

    @ApiModelProperty("编号")
    private Long id;

    @ApiModelProperty("公司")
    private Integer companyId;

    @ApiModelProperty("部门")
    private Integer deptId;

    @ApiModelProperty("创建日期")
    private Date createTime;

}


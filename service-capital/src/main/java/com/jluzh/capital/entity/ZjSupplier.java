package com.jluzh.capital.entity;


import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.*;
import lombok.Data;

/**
 * 供应商(ZjSupplier)表实体类
 *
 * @author panlaoliu
 * @since 2022-10-16 16:57:48
 */
@Data
@ApiModel("供应商")
public class ZjSupplier implements Serializable {
    private static final long serialVersionUID = 900962185227389240L;

    @ApiModelProperty("编号")
    private Integer id;

    @ApiModelProperty("公司编号")
    private Integer companyId;

    @ApiModelProperty("供应商类型")
    private String supplierType;

    @ApiModelProperty("准入日期")
    private Date accessDate;

    @ApiModelProperty("状态")
    private String status;

    @ApiModelProperty("等级")
    private String grade;

}


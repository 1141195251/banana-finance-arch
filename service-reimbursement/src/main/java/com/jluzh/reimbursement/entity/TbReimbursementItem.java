package com.jluzh.reimbursement.entity;


import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * (TbReimbursementItem)表实体类
 *
 * @author pan-laoliu
 * @since 2022-10-16 22:24:11
 */
@Data
@ApiModel("$tableInfo.comment")
@HeadRowHeight(20)
@ColumnWidth(25)
public class TbReimbursementItem implements Serializable {
    private static final long serialVersionUID = 791140926139213621L;

    @ApiModelProperty("编号")
    @ExcelIgnore
    private Long id;

    @ApiModelProperty("报销单")
    @ExcelProperty("v")
    private Integer claimVoucherId;

    @ApiModelProperty("费用类型")
    @ExcelProperty("费用类型")
    private String item;

    @ApiModelProperty("金额")
    @ExcelProperty("金额")
    private BigDecimal amount;

    @ApiModelProperty("描述")
    @ExcelProperty("描述")
    private String comment;

}


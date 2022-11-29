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
import java.util.Date;

/**
 * (TbReimbursementInfo)表实体类
 *
 * @author pan-laoliu
 * @since 2022-10-16 22:24:12
 */
@Data
@ApiModel("$tableInfo.comment")
@HeadRowHeight(20)
@ColumnWidth(25)
public class TbReimbursementInfo implements Serializable {
    private static final long serialVersionUID = 779654117986987882L;

    @ApiModelProperty("编号")
    @ExcelIgnore
    private Long id;

    @ApiModelProperty("事由")
    @ExcelProperty("事由")
    private String cause;

    @ApiModelProperty("创建人")
    @ExcelProperty("创建人")
    private String createSn;

    @ApiModelProperty("创建时间")
    @ExcelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty("待处理人")
    @ExcelProperty("待处理人")
    private String nextDealSn;

    @ApiModelProperty("总金额")
    @ExcelProperty("总金额")
    private BigDecimal totalAmount;

    @ApiModelProperty("状态")
    @ExcelProperty("状态")
    private String status;

}


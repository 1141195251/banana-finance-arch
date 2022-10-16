package com.jluzh.reimbursement.entity;


import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (TbReimbursementRecord)表实体类
 *
 * @author
 * @since 2022-10-16 22:24:11
 */
@Data
@ApiModel("$tableInfo.comment")
@HeadRowHeight(20)
@ColumnWidth(25)
public class TbReimbursementRecord implements Serializable {
    private static final long serialVersionUID = 989072382812130357L;

    @ApiModelProperty("编号")
    @ExcelIgnore
    private Integer id;

    @ApiModelProperty("报销单")
    @ExcelProperty("报销单")
    private Integer claimVoucherId;

    @ApiModelProperty("处理人")
    @ExcelProperty("处理人")
    private String dealSn;

    @ApiModelProperty("处理时间")
    @ExcelProperty("处理时间")
    private Date dealTime;

    @ApiModelProperty("处理类型")
    @ExcelProperty("处理类型")
    private String dealWay;

    @ApiModelProperty("处理结果")
    @ExcelProperty("处理结果")
    private String dealResult;

    @ApiModelProperty("备注")
    @ExcelProperty("备注")
    private String comment;

}


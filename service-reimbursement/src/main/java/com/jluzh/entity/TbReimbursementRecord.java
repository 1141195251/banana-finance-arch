package com.jluzh.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentStyle;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;

import java.util.Date;
import java.io.Serializable;

/**
 * (TbReimbursementRecord)实体类
 *
 * @author makejava
 * @since 2022-10-07 10:36:28
 */
@HeadRowHeight(20)
@ColumnWidth(25)
public class TbReimbursementRecord implements Serializable {
    private static final long serialVersionUID = 265599555378085535L;
    /**
     * 编号
     */
    @ExcelIgnore
    private Integer id;
    /**
     * 报销单
     */
    @ExcelProperty("报销单")
    private Integer claimVoucherId;
    /**
     * 处理人
     */
    @ExcelProperty("处理人")
    private String dealSn;
    /**
     * 处理时间
     */
    @ExcelProperty("处理时间")
    private Date dealTime;
    /**
     * 处理类型
     */
    @ExcelProperty("处理类型")
    private String dealWay;
    /**
     * 处理结果
     */
    @ExcelProperty("处理结果")
    private String dealResult;
    /**
     * 备注
     */
    @ExcelProperty("备注")
    private String comment;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClaimVoucherId() {
        return claimVoucherId;
    }

    public void setClaimVoucherId(Integer claimVoucherId) {
        this.claimVoucherId = claimVoucherId;
    }

    public String getDealSn() {
        return dealSn;
    }

    public void setDealSn(String dealSn) {
        this.dealSn = dealSn;
    }

    public Date getDealTime() {
        return dealTime;
    }

    public void setDealTime(Date dealTime) {
        this.dealTime = dealTime;
    }

    public String getDealWay() {
        return dealWay;
    }

    public void setDealWay(String dealWay) {
        this.dealWay = dealWay;
    }

    public String getDealResult() {
        return dealResult;
    }

    public void setDealResult(String dealResult) {
        this.dealResult = dealResult;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}


package com.jluzh.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;

import java.util.Date;
import java.io.Serializable;

/**
 * (TbReimbursementInfo)实体类
 *
 * @author makejava
 * @since 2022-10-07 10:36:31
 */
@HeadRowHeight(20)
@ColumnWidth(25)
public class TbReimbursementInfo implements Serializable {
    private static final long serialVersionUID = 132853390954947620L;
    /**
     * 编号
     */
    @ExcelIgnore
    private Integer id;
    /**
     * 事由
     */
    @ExcelProperty("事由")
    private String cause;
    /**
     * 创建人
     */
    @ExcelProperty("创建人")
    private String createSn;
    /**
     * 创建时间
     */

    @ExcelProperty(value = "创建时间")
    private Date createTime;
    /**
     * 待处理人
     */
    @ExcelProperty("待处理人")
    private String nextDealSn;
    /**
     * 总金额
     */
    @ExcelProperty("总金额")
    private Double totalAmount;
    /**
     * 状态
     */
    @ExcelProperty("状态")
    private String status;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getCreateSn() {
        return createSn;
    }

    public void setCreateSn(String createSn) {
        this.createSn = createSn;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getNextDealSn() {
        return nextDealSn;
    }

    public void setNextDealSn(String nextDealSn) {
        this.nextDealSn = nextDealSn;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TbReimbursementInfo{" +
                "id=" + id +
                ", cause='" + cause + '\'' +
                ", createSn='" + createSn + '\'' +
                ", createTime=" + createTime +
                ", nextDealSn='" + nextDealSn + '\'' +
                ", totalAmount=" + totalAmount +
                ", status='" + status + '\'' +
                '}';
    }
}


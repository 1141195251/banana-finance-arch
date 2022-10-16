package com.jluzh.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;

import java.io.Serializable;

/**
 * (TbReimbursementItem)实体类
 *
 * @author makejava
 * @since 2022-10-07 10:36:24
 */
@HeadRowHeight(20)
@ColumnWidth(25)
public class TbReimbursementItem implements Serializable {
    private static final long serialVersionUID = -21749281449988650L;
    /**
     * 编号
     */
    @ExcelIgnore
    private Integer id;
    /**
     * 报销单id
     */
    @ExcelProperty("v")
    private Integer claimVoucherId;
    /**
     * 费用类型
     */
    @ExcelProperty("费用类型")
    private String item;
    /**
     * 金额
     */
    @ExcelProperty("金额")
    private Double amount;
    /**
     * 描述
     */
    @ExcelProperty("描述")
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

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    @Override
    public String toString() {
        return "TbReimbursementItem{" +
                "id=" + id +
                ", claimVoucherId=" + claimVoucherId +
                ", item='" + item + '\'' +
                ", amount=" + amount +
                ", comment='" + comment + '\'' +
                '}';
    }
}


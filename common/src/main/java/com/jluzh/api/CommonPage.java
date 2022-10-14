package com.jluzh.api;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * 分页数据封装类
 */
public class CommonPage<T> {
    private Long pageNum;
    private Long pageSize;
    private Long totalPage;
    private Long total;
    private List<T> list;

    /**
     * 将MybatisPlusInterceptor分页后的list转为分页信息
     */
    public static <T> CommonPage<T> restPage(Page<T> list) {
        CommonPage<T> result = new CommonPage<T>();
        result.setPageNum(list.getCurrent());
        // TODO
        result.setPageSize(list.getSize());
        result.setTotalPage(list.getPages());
        result.setTotal(list.getTotal());
        result.setList(list.getRecords());
        return result;
    }


    public Long getPageNum() {
        return pageNum;
    }

    public void setPageNum(Long pageNum) {
        this.pageNum = pageNum;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    public Long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Long totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}

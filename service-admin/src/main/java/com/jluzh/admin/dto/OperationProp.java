package com.jluzh.admin.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class OperationProp {
    @ApiModelProperty("添加操作")
    private String add;

    @ApiModelProperty("编辑操作")
    private String edit;

    @ApiModelProperty("删除操作")
    private String delete;

    @ApiModelProperty("查询操作")
    private String find;
}

package com.jluzh.admin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@ApiModel("权限属性")
public class PageProp {
    @ApiModelProperty(value = "页面标题")
    private String title;
}

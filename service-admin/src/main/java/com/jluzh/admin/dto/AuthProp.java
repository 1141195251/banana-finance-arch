package com.jluzh.admin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("权限属性")
public class AuthProp {
    @ApiModelProperty(value = "角色", notes = "路由需要的角色。当permission未设置，通过 role 检查权限")
    private String role;
}

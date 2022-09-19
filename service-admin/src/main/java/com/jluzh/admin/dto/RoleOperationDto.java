package com.jluzh.admin.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class RoleOperationDto {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("角色id")
    private String Id;
    private List<String> operation;
}

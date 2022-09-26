package com.jluzh.admin.dto.admin;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@TableName("ums_role_operation")
@ApiModel(value = "StandardRoleOperationDto", description = "")
public class StandardRoleOperationDto implements Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty("角色id")
    private Long roleId;

    @ApiModelProperty("角色名称")
    private String name;

    @ApiModelProperty("添加操作")
    @TableField(value = "`add`")
    private int add;

    @ApiModelProperty("编辑操作")
    @TableField(value = "`edit`")
    private int edit;

    @ApiModelProperty("删除操作")
    @TableField(value = "`delete`")
    private int delete;

    @ApiModelProperty("查询操作")
    @TableField(value = "`find`")
    private int find;
}

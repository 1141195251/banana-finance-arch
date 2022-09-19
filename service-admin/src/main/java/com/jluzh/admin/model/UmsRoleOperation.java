package com.jluzh.admin.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 *
 * </p>
 *
 * @author banana
 * @since 2022-09-17
 */
@Getter
@Setter
@TableName("ums_role_operation")
@ApiModel(value = "UmsRoleOperation对象", description = "")
public class UmsRoleOperation implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("角色id")
    private Long roleId;

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

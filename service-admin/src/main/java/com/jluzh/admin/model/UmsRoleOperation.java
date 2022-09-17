package com.jluzh.admin.model;

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
    private String add;

    @ApiModelProperty("编辑操作")
    private String edit;

    @ApiModelProperty("删除操作")
    private String delete;

    @ApiModelProperty("查询操作")
    private String find;


}

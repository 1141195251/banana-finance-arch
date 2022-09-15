package com.jluzh.admin.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 后台角色资源关系表
 * </p>
 *
 * @author banana
 * @since 2022-09-15
 */
@Getter
@Setter
@TableName("ums_role_resource_relation")
@ApiModel(value = "UmsRoleResourceRelation对象", description = "后台角色资源关系表")
public class UmsRoleResourceRelation implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("角色ID")
    private Long roleId;

    @ApiModelProperty("资源ID")
    private Long resourceId;


}

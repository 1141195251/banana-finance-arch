package com.jluzh.admin.model;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 资源分类表
 * </p>
 *
 * @author banana
 * @since 2022-09-15
 */
@Getter
@Setter
@TableName("ums_resource_category")
@ApiModel(value = "UmsResourceCategory对象", description = "资源分类表")
public class UmsResourceCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("分类名称")
    private String name;

    @ApiModelProperty("排序")
    private Integer sort;


}

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
 * 后台资源表
 * </p>
 *
 * @author banana
 * @since 2022-09-15
 */
@Getter
@Setter
@TableName("ums_resource")
@ApiModel(value = "UmsResource对象", description = "后台资源表")
public class UmsResource implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("资源名称")
    private String name;

    @ApiModelProperty("资源URL")
    private String url;

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("资源分类ID")
    private Long categoryId;


}

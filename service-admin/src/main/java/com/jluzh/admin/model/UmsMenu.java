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
 * 后台菜单表
 * </p>
 *
 * @author banana
 * @since 2022-09-15
 */
@Getter
@Setter
@TableName("ums_menu")
@ApiModel(value = "UmsMenu对象", description = "后台菜单表")
public class UmsMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @ApiModelProperty("父级ID")
    private Long parentId;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("菜单名称")
    private String title;

    @ApiModelProperty("菜单级数")
    private Integer level;

    @ApiModelProperty("菜单排序")
    private Integer sort;

    @ApiModelProperty("前端名称")
    private String name;

    @ApiModelProperty("前端图标")
    private String icon;

    @ApiModelProperty("前端隐藏")
    private Integer hidden;


}

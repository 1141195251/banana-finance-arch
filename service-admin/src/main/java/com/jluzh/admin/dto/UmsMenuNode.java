package com.jluzh.admin.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.jluzh.admin.model.UmsMenu;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * 后台菜单节点封装
 */
@Getter
@Setter
@ApiModel("菜单节点")
public class UmsMenuNode {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long key;

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
    @ApiModelProperty(value = "子级菜单")
    private List<UmsMenuNode> children;
}

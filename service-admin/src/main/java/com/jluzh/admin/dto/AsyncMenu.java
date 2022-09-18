package com.jluzh.admin.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@ApiModel("异步菜单")
public class AsyncMenu {
    @ApiModelProperty(name = "路由组件注册名称，唯一标识")
    private String router;
    @ApiModelProperty(name = "路由名称")
    private String name;
    // TODO
//    @ApiModelProperty(name = "权限")
//    private AuthProp authority;
    @ApiModelProperty(name = "图标")
    private String icon;
    @ApiModelProperty(name = "菜单不可见性 0->可见,1->不可见")
    private boolean invisible;
    @ApiModelProperty(name = "路由页面数据", notes = "路由的页面数据，会注入到路由元数据meta中")
    private PageProp page;
    private List<AsyncMenu> children;
}

package com.jluzh.constant;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 权限相关常量定义
 */
@ApiModel("权限相关常量定义")
public interface AuthConstant {
    @ApiModelProperty("JWT存储权限前缀")
    String AUTHORITY_PREFIX = "ROLE_";

    @ApiModelProperty("JWT存储权限属性")
    String AUTHORITY_CLAIM_NAME = "authorities";

    @ApiModelProperty("后台管理client_id")
    String ADMIN_CLIENT_ID = "client-app";

    @ApiModelProperty("前台商城client_id")
    String PORTAL_CLIENT_ID = "portal-app";

    @ApiModelProperty("后台管理接口路径匹配")
    String ADMIN_URL_PATTERN = "/service-api/**";

    @ApiModelProperty("Redis缓存权限规则key")
    String RESOURCE_ROLES_MAP_KEY = "AUTH:RESOURCE_ROLES_MAP";

    @ApiModelProperty("认证信息Http请求头")
    String JWT_TOKEN_HEADER = "Authorization";

    @ApiModelProperty("JWT令牌前缀")
    String JWT_TOKEN_PREFIX = "Bearer ";

    @ApiModelProperty("用户信息Http请求头")
    String USER_TOKEN_HEADER = "user";

}

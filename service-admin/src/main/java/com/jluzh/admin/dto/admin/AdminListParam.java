package com.jluzh.admin.dto.admin;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
public class AdminListParam {
    @NotNull
    private Long pageNum;
    @NotNull
    private Long pageSize;

    private String username;

    @ApiModelProperty("头像")
    private String icon;

    @Email
    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("昵称")
    private String nickName;

    @ApiModelProperty("备注信息")
    private String note;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("最后登录时间")
    private Date loginTime;

    @ApiModelProperty("帐号启用状态：0->禁用；1->启用")
    private Integer status;
}

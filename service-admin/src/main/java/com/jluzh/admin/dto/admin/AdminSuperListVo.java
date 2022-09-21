package com.jluzh.admin.dto.admin;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class AdminSuperListVo {

    private Long id;

    private String username;

    private String password;

    @ApiModelProperty("头像")
    private String icon;

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

    private List innerData;
}

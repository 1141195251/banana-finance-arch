package com.jluzh.admin.dto.admin;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class AdminRoleRelationVo {
    private Long id;
    private Long adminId;
    private String adminUsername;
    private String adminNickName;
    private String roleName;
}

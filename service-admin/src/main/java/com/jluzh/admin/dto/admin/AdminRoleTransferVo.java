package com.jluzh.admin.dto.admin;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@EqualsAndHashCode(callSuper = false)
public class AdminRoleTransferVo {
    private String key;
    private String title;
    private String description;
    private boolean chosen;
}

package com.jluzh.admin.dto.admin;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AllocaParam {
    private Long roleId;
    private List<Long> menuIds;
}

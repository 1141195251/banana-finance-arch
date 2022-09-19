package com.jluzh.admin.dto.admin;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class UpdateRoleParam {
    @NotNull
    private Long adminId;
    @NotEmpty
    private List<Long> roleIds;
}

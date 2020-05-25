package com.youaodu.template.admin.biz;

import com.youaodu.template.common.entity.pojo.dto.admin.AddRoleDto;
import com.youaodu.template.common.entity.pojo.vo.admin.ShowAllRoleVo;

import java.util.List;

public interface RoleBiz {
    String addRole(AddRoleDto addRoleDto);

    List<ShowAllRoleVo> showAll();
}

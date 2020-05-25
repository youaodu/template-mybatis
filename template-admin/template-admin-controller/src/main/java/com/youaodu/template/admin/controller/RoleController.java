package com.youaodu.template.admin.controller;

import com.youaodu.template.admin.biz.RoleBiz;
import com.youaodu.template.common.entity.pojo.dto.admin.AddRoleDto;
import com.youaodu.template.common.framework.http.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleBiz roleBiz;

    /**
     * 添加角色
     * @param addRoleDto
     * @return
     */
    @PostMapping("/addRole")
    public ResultMessage addRole(@Valid @RequestBody AddRoleDto addRoleDto) {
        return ResultMessage.ok(roleBiz.addRole(addRoleDto));
    }

    /**
     * 显示全部
     * @return
     */
    @GetMapping("/showAll")
    public ResultMessage showAll() {
        return ResultMessage.ok(roleBiz.showAll());
    }
}

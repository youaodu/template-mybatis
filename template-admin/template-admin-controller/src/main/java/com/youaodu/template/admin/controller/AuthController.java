package com.youaodu.template.admin.controller;

import com.youaodu.template.admin.biz.AuthBiz;
import com.youaodu.template.common.entity.pojo.dto.admin.CreditDto;
import com.youaodu.template.common.entity.pojo.dto.admin.SettingsButtonDto;
import com.youaodu.template.common.framework.http.ResultMessage;
import com.youaodu.template.common.framework.token.Token;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthBiz authBiz;

    /**
     * 拥有权限树
     * @param token
     * @return
     */
    @GetMapping("/tree")
    public ResultMessage tree(Token token) {
        return ResultMessage.ok(authBiz.tree(token));
    }

    /**
     * 可分配菜单集合
     * @param token
     * @return
     */
    @GetMapping("/resAssign")
    public ResultMessage resAssign(Token token) {
        return ResultMessage.ok(authBiz.resAssign(token));
    }

    /**
     * 授权
     * @param creditDto
     * @return
     */
    @PostMapping("/credit")
    public ResultMessage credit(@RequestBody CreditDto creditDto) {
        return ResultMessage.ok(authBiz.credit(creditDto));
    }
}

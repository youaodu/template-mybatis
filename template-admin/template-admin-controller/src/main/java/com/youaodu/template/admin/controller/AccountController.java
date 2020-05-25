package com.youaodu.template.admin.controller;

import com.youaodu.template.admin.biz.AccountBiz;
import com.youaodu.template.common.entity.pojo.dto.admin.AddAccountDto;
import com.youaodu.template.common.entity.pojo.dto.admin.LoginDto;
import com.youaodu.template.common.framework.http.ResultMessage;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/account")
public class AccountController {

    private AccountBiz accountBiz;

    /**
     * 登录接口
     * @param loginDto
     * @return
     */
    @PostMapping("/login")
    public ResultMessage login(@Valid @RequestBody LoginDto loginDto) {
        return ResultMessage.ok(accountBiz.login(loginDto));
    }

    /**
     * 添加用户
     * @param addAccountDto
     * @return
     */
    @PostMapping
    public ResultMessage addAccount(@Valid @RequestBody AddAccountDto addAccountDto) {
        return ResultMessage.ok(accountBiz.addAccount(addAccountDto));
    }

    
}

package com.youaodu.template.admin.controller;

import com.youaodu.template.admin.biz.AccountBiz;
import com.youaodu.template.common.entity.pojo.dto.admin.AddAccountDto;
import com.youaodu.template.common.entity.pojo.dto.admin.LoginDto;
import com.youaodu.template.common.framework.annotation.ApiLog;
import com.youaodu.template.common.framework.annotation.WhiteRequest;
import com.youaodu.template.common.framework.http.ResultMessage;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    @WhiteRequest
    @PostMapping("/login")
    @ApiLog(desc = "登陆接口")
    public ResultMessage login(@Valid @RequestBody LoginDto loginDto) {
        return ResultMessage.ok(accountBiz.login(loginDto));
    }

    /**
     * 添加用户
     * @param addAccountDto
     * @return
     */
    @PostMapping
    @ApiLog(desc = "添加用户接口")
    public ResultMessage addAccount(@Valid @RequestBody AddAccountDto addAccountDto) {
        return ResultMessage.ok(accountBiz.addAccount(addAccountDto));
    }

}

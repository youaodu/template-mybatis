package com.youaodu.template.admin.biz.impl;

import cn.hutool.crypto.digest.MD5;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.youaodu.template.admin.biz.AccountBiz;
import com.youaodu.template.common.entity.model.AdminAccount;
import com.youaodu.template.common.entity.pojo.dto.admin.LoginDto;
import com.youaodu.template.common.entity.pojo.vo.admin.LoginVo;
import com.youaodu.template.common.framework.exception.BusinessException;
import com.youaodu.template.common.framework.token.BuilderToken;
import com.youaodu.template.common.framework.token.Token;
import com.youaodu.template.common.service.AdminAccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountBizImpl implements AccountBiz {

    private AdminAccountService adminAccountService;

    /**
     * 登录接口
     * @param loginDto
     * @return
     */
    @Override
    public LoginVo login(LoginDto loginDto) {
        AdminAccount account = adminAccountService.getOne(new LambdaQueryWrapper<AdminAccount>()
                .eq(AdminAccount::getUserName, loginDto.getUserName())
                .eq(AdminAccount::getEncryPwd, MD5.create().digestHex(loginDto.getPwd()).toUpperCase())
        );

        if (account == null)
            throw new BusinessException("用户名或密码错误");

        if (account.getLoginLock() == 1)
            throw new BusinessException("账号被锁");

        // 结尾
        String tokenStr = BuilderToken.builderToken(new Token(account.getAccountId(), account.getUserName(), "", "admin"));
        return new LoginVo(tokenStr);
    }
}

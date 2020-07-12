package com.youaodu.template.admin.biz.impl;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.MD5;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.google.gson.internal.$Gson$Preconditions;
import com.sun.tools.classfile.ConstantPool;
import com.youaodu.template.admin.biz.AccountBiz;
import com.youaodu.template.common.entity.model.AdminAccount;
import com.youaodu.template.common.entity.pojo.dto.admin.AddAccountDto;
import com.youaodu.template.common.entity.pojo.dto.admin.LoginDto;
import com.youaodu.template.common.entity.pojo.vo.admin.LoginVo;
import com.youaodu.template.common.framework.exception.BusinessException;
import com.youaodu.template.common.framework.token.BuilderToken;
import com.youaodu.template.common.framework.token.Token;
import com.youaodu.template.common.framework.utils.IdBizCode;
import com.youaodu.template.common.framework.utils.IdGenUtils;
import com.youaodu.template.common.service.AdminAccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

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
            throw new BusinessException("账号已冻结");

        // 结尾
        String tokenStr = BuilderToken.builderToken(new Token(account.getAccountId(), account.getUserName(), "", "admin"));
        return new LoginVo(tokenStr);
    }

    /**
     * 添加账号
     * @param addAccountDto
     * @return
     */
    @Override
    public String addAccount(AddAccountDto addAccountDto) {
        int accountExists = adminAccountService.count(new LambdaQueryWrapper<AdminAccount>()
                .eq(AdminAccount::getUserName, addAccountDto.getAccountName())
        );
        if (accountExists > 0) {
            throw new BusinessException("添加账号名已存在");
        }

        AdminAccount addAccount = new AdminAccount();
        addAccount.setAccountId(IdGenUtils.genId(IdBizCode.ACCOUNT_ID));
        addAccount.setUserName(addAccountDto.getAccountName());
        addAccount.setPwd(addAccountDto.getPwd());
        adminAccountService.save(addAccount);
        return "SUCCESS";
    }

}

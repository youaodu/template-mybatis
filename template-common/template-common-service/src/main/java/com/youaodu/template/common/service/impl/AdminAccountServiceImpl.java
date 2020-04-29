package com.youaodu.template.common.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youaodu.template.common.dao.mapper.AdminAccountMapper;
import com.youaodu.template.common.entity.model.AdminAccount;
import com.youaodu.template.common.service.AdminAccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AdminAccountServiceImpl extends ServiceImpl<AdminAccountMapper, AdminAccount> implements AdminAccountService {
}

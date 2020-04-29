package com.youaodu.template.common.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youaodu.template.common.dao.mapper.AccountRoleMapper;
import com.youaodu.template.common.entity.model.AccountRole;
import com.youaodu.template.common.service.AccountRoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountRoleServiceImpl extends ServiceImpl<AccountRoleMapper, AccountRole> implements AccountRoleService {
}

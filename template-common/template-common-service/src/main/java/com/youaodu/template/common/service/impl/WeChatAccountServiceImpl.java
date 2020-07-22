package com.youaodu.template.common.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youaodu.template.common.dao.mapper.WeChatAccountMapper;
import com.youaodu.template.common.entity.model.WeChatAccount;
import com.youaodu.template.common.service.WeChatAccountService;
import org.springframework.stereotype.Service;

@Service
public class WeChatAccountServiceImpl extends ServiceImpl<WeChatAccountMapper, WeChatAccount> implements WeChatAccountService {

}

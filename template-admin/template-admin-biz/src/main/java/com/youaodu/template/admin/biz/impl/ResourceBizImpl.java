package com.youaodu.template.admin.biz.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.youaodu.template.admin.biz.ResourceBiz;
import com.youaodu.template.common.entity.model.AccountRole;
import com.youaodu.template.common.entity.model.Resources;
import com.youaodu.template.common.entity.model.Role;
import com.youaodu.template.common.entity.pojo.vo.admin.AllResVo;
import com.youaodu.template.common.framework.token.Token;
import com.youaodu.template.common.service.AccountRoleService;
import com.youaodu.template.common.service.ResourcesService;
import com.youaodu.template.common.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ResourceBizImpl implements ResourceBiz {

    private ResourcesService resourcesService;

    private AccountRoleService accountRoleService;

    private RoleService roleService;

    @Override
    public List<AllResVo> allRes(Token token) {
        // 当前用户的用户
        List<Long> roleIds = accountRoleService.list(new LambdaQueryWrapper<AccountRole>()
                .eq(AccountRole::getAccountId, token.getAccountId())
        ).stream().map(AccountRole::getRoleId).collect(Collectors.toList());
        // 所有角色等级
        List<Integer> level = roleService.list(new LambdaQueryWrapper<Role>()
                .in(Role::getId, roleIds)
        ).stream().map(Role::getLevel).collect(Collectors.toList());
        LambdaQueryWrapper<Resources> levelQueryWrapper = new LambdaQueryWrapper<>();
        // 遍历等级
        level.forEach(it -> {
            levelQueryWrapper.ge(Resources::getLevel, it);
        });
        List<Resources> tmpList = resourcesService.list(levelQueryWrapper);
        List<AllResVo> result = tmpList.stream().map(it -> {
            AllResVo resultItem = new AllResVo();

            // 编号
            resultItem.setId(it.getId());
            // 名字
            resultItem.setName(it.getName());

            return resultItem;
        }).collect(Collectors.toList());

        return result;

    }
}

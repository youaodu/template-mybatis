package com.youaodu.template.admin.biz.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sun.org.apache.xpath.internal.operations.String;
import com.youaodu.template.admin.biz.AuthBiz;
import com.youaodu.template.common.entity.model.AccountRole;
import com.youaodu.template.common.entity.model.Resources;
import com.youaodu.template.common.entity.model.Role;
import com.youaodu.template.common.entity.model.RoleResources;
import com.youaodu.template.common.entity.pojo.dto.admin.CreditDto;
import com.youaodu.template.common.entity.pojo.vo.admin.ResAssignVo;
import com.youaodu.template.common.entity.pojo.vo.admin.TreeVo;
import com.youaodu.template.common.framework.exception.BusinessException;
import com.youaodu.template.common.framework.token.Token;
import com.youaodu.template.common.framework.utils.ConvertUtils;
import com.youaodu.template.common.service.AccountRoleService;
import com.youaodu.template.common.service.ResourcesService;
import com.youaodu.template.common.service.RoleResourcesService;
import com.youaodu.template.common.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.annotation.processing.RoundEnvironment;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AuthBizImpl implements AuthBiz {

    private RoleService roleService;

    private AccountRoleService accountRoleService;

    private RoleResourcesService roleResourcesService;

    private ResourcesService resourcesService;

    /**
     * 权限树
     * @param token
     * @return
     */
    @Override
    public List<TreeVo> tree(Token token) {
        // 角色集合
        List<AccountRole> roles = accountRoleService.list(new LambdaQueryWrapper<AccountRole>()
                .eq(AccountRole::getAccountId, token.getAccountId())
        );

        // 所有授权
        List<RoleResources> roleResources = roleResourcesService.list(new LambdaQueryWrapper<RoleResources>()
                .in(RoleResources::getRoleId, roles.stream().map(AccountRole::getRoleId).collect(Collectors.toList()))
        );

        /**
         * 查找拥有的资源列表
         */
        List<JSONObject> tmpList = new ArrayList<>();
        for (RoleResources it : roleResources) {
            JSONObject tmp = new JSONObject();
            tmp.put("buttons", it.getButtons());
            Resources resources = resourcesService.getById(it.getResourcesId());
            if (resources != null) {
                tmp.putAll(BeanUtil.beanToMap(resources));
                tmpList.add(tmp);
            }
        }

        return genTree(tmpList, 0L);
    }

    /**
     * 可分配菜单集合
     * @param token
     * @return
     */
    @Override
    public List<ResAssignVo> resAssign(Token token) {

        // 当前用户所有的角色
        List<Long> roleIds = accountRoleService.list(new LambdaQueryWrapper<AccountRole>()
                .eq(AccountRole::getAccountId, token.getAccountId())
        ).stream().map(AccountRole::getRoleId).collect(Collectors.toList());

        List<Integer> levels = roleService.listByIds(roleIds).stream().map(Role::getLevel).collect(Collectors.toList());
        // 拼接条件语句
        LambdaQueryWrapper<Resources> resByLevelWrapper = new LambdaQueryWrapper<>();
        for (Integer level : levels) {
            resByLevelWrapper.le(Resources::getLevel, level);
        }
        // 执行
        List<Resources> list = resourcesService.list(resByLevelWrapper);
        // 最后结果集
        return list.stream().map(it -> {
            ResAssignVo resultItem = new ResAssignVo();
            BeanUtil.copyProperties(it, resultItem);
            return resultItem;
        }).collect(Collectors.toList());
    }

    /**
     * 授权
     * @param creditDto
     * @return
     */
    @Override
    public Integer credit(CreditDto creditDto) {
        // 基础判断
        if (creditDto.getButtons().length != creditDto.getResIds().length) {
            throw new BusinessException("");
        }

        roleResourcesService.remove(new LambdaQueryWrapper<RoleResources>()
                .eq(RoleResources::getRoleId, creditDto.getRoleId())
        );

        List<RoleResources> inserts = new ArrayList<>();
        for (int i = 0; i < creditDto.getResIds().length; i++) {
            RoleResources insertTmp = new RoleResources();
            insertTmp.setRoleId(creditDto.getRoleId());
            insertTmp.setResourcesId(creditDto.getResIds()[i]);
            insertTmp.setButtons(creditDto.getButtons()[i]);
            inserts.add(insertTmp);
        }
        roleResourcesService.saveBatch(inserts);
        return 0;
    }

    private List<TreeVo> genTree(List<JSONObject> resList, Long pid) {
        return resList.stream().map(it -> {
            TreeVo resultItem = new TreeVo();

            if (it.getLong("pid") == pid) {
                // 赋值
                resultItem.setButtons(it.getStr("buttons"));
                resultItem.setComponent(it.getStr("component"));
                resultItem.setHide(it.getBool("hide"));
                resultItem.setName(it.getStr("name"));
                resultItem.setPath(it.getStr("path"));
                resultItem.setChildren(genTree(resList, it.getLong("id")));
            }
            return resultItem;
        }).collect(Collectors.toList());
    }
}

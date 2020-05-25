package com.youaodu.template.admin.biz.impl;

import cn.hutool.core.collection.CollUtil;
import com.youaodu.template.admin.biz.RoleBiz;
import com.youaodu.template.common.entity.model.Role;
import com.youaodu.template.common.entity.pojo.dto.admin.AddRoleDto;
import com.youaodu.template.common.entity.pojo.vo.admin.ShowAllRoleVo;
import com.youaodu.template.common.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RoleBizImpl implements RoleBiz {

    private RoleService roleService;

    /**
     * 添加角色
     * @param addRoleDto
     * @return
     */
    @Override
    public String addRole(AddRoleDto addRoleDto) {
        Role saveBean = new Role();
        // 标记
        saveBean.setCode(addRoleDto.getCode());
        // 描述信息
        saveBean.setDescr(addRoleDto.getDescr());
        // 角色等级
        saveBean.setLevel(addRoleDto.getLevel());
        roleService.save(saveBean);
        return "SUCCESS";
    }

    /**
     * 显示全部角色
     * @return
     */
    @Override
    public List<ShowAllRoleVo> showAll() {
        List<Role> tmpList = roleService.list();
        if (CollUtil.isEmpty(tmpList)) {
            return null;
        } else {
            return tmpList.stream().map(it -> {
                ShowAllRoleVo resultItem = new ShowAllRoleVo();

                resultItem.setId(it.getId());
                resultItem.setName(it.getCode());

                return resultItem;
            }).collect(Collectors.toList());
        }
    }
}

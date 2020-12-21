package com.youaodu.template.common.quickdev.eum;

import cn.hutool.core.util.StrUtil;

public enum SystemParamsNames {
    CURRENT_ACCOUNT_ID("CURRENT_ACCOUNT_ID", "当前账户ID")
    ;

    SystemParamsNames(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    /**
     * 是否存在
     * @param name
     * @return
     */
    public static boolean contains(String name) {
        SystemParamsNames[] values = SystemParamsNames.values();
        for (SystemParamsNames item : values) {
            if (StrUtil.equals(item.getName(), name)) {
                return true;
            }
        }
        return false;
    }

    private String name;
    private String desc;

    public String getDesc() {
        return desc;
    }

    public String getName() {
        return name;
    }
}

package com.youaodu.template.common.framework.crud;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Index;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

import java.util.Date;

@Data
public class BaseEntity implements Model {

    @TableId(type = IdType.AUTO)
    @Column(name="id", type = MySqlTypeConstant.BIGINT, comment = "主键", length = 10, isKey = true, isAutoIncrement = true)
    private Long id;

    @TableLogic
    @Column(name = "deleted", type = MySqlTypeConstant.INT, length = 3, comment = "逻辑删除 ")
    private Integer deleted;

    @Column(name = "ctime", type = MySqlTypeConstant.TIMESTAMP, comment = "创建时间", isNull = false)
    private Date ctime;

    @Column(name = "utime", type = MySqlTypeConstant.TIMESTAMP, comment = "修改时间", isNull = false)
    private Date utime;
}

package com.youaodu.template.common.entity.pojo.dto.admin;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class SettingsButtonsDto {

    @NotNull(message = "按钮集不能为空")
    List<SettingsButtonsDtoItem> buttons;

}

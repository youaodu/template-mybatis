package com.youaodu.template.admin.controller;

import com.youaodu.template.admin.biz.ResourceBiz;
import com.youaodu.template.common.framework.http.ResultMessage;
import com.youaodu.template.common.framework.token.Token;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/resource")
public class ResourceController {

    private ResourceBiz resourceBiz;

    /**
     * 全部资源列表
     * @param token
     * @return
     */
    @GetMapping("/allRes")
    public ResultMessage allRes(Token token) {
        return ResultMessage.ok(resourceBiz.allRes(token));
    }

}

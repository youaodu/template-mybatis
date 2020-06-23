package com.youaodu.template.common.main.api;

import com.youaodu.template.common.entity.pojo.dto.main.RootDto;
import com.youaodu.template.common.framework.http.ResultMessage;
import com.youaodu.template.common.framework.token.Token;
import com.youaodu.template.common.main.biz.ApiBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class ApiController {

    @Autowired
    private ApiBiz apiBiz;

    /**
     * get请求
     * @param params
     * @return
     */
    @RequestMapping("/{path}")
    public ResultMessage root(Token token, @PathVariable String path, String appCode, Map<String, Object> params, HttpServletRequest request){
        RootDto rootDto = new RootDto();
        rootDto.setMethod(request.getMethod());
        rootDto.setParams(params);
        rootDto.setPath(path);
        rootDto.setTokenBean(token);
        return ResultMessage.ok(apiBiz.root(rootDto));
    }
}

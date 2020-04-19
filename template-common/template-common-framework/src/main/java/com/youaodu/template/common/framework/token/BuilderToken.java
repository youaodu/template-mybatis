package com.youaodu.template.common.framework.token;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import cn.hutool.json.JSONUtil;
import com.youaotu.template.common.framework.exception.BusinessException;
import com.youaotu.template.common.framework.exception.TokenException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.StringJoiner;

/**
 * * @create 2019-08-10 11:57
 */
public class BuilderToken {

    /**
     * 私钥 >>> 随机生成的
     * * @time 05:44
     */
    private static byte[] privateKey = new byte[]{37, -118, 37, 55, -118, -46, 73, 95, 60, -36, -118, -120, 31, 12, -44, -96};

    /**
     * token 过期时间  默认3天
     *
     * * @time 05:53
     */
    private static Long expire = 60 * 60 * 24 * 3L;

    // 日志
    private static final Logger logger = LoggerFactory.getLogger(BuilderToken.class);

    /**
     * 解析Token
     *
     * @param tokenStr
     * * @time 12:12
     */
    public static Token analysisToken(String tokenStr) {
        if (StrUtil.isBlank(tokenStr)) {
            return null;
        }
        AES aes = SecureUtil.aes(privateKey);
        String tmp = aes.decryptStr(tokenStr);

        String[] params = tmp.split("_");
        return paramsToToken(params);
    }

    /**
     * 生成Token
     *
     * @param token
     * * @time 05:37
     */
    public static String builderToken(Token token) {
        // 转换
        StringJoiner params = new StringJoiner("_");
        params.add(StrUtil.toString(token.getAccountId()));
        params.add(token.getAccountName());
        params.add(StrUtil.toString(expire));
        params.add(StrUtil.toString((System.currentTimeMillis() / 1000)));
        params.add(token.getChannelCode());
        params.add(StrUtil.toString(token.getAppCode()));


        AES aes = SecureUtil.aes(privateKey);
        return aes.encryptHex(params.toString());
    }

    /**
     * 校验token
     *
     * @param token
     * @return 正确 >>> true  错误 >>> false
     * * @time 06:17
     */
    public static boolean validateToken(String token) {
        if (StrUtil.isBlank(token)) {
            throw new TokenException("token不存在");
        }
        AES aes = SecureUtil.aes(privateKey);
        String pwd = aes.decryptStr(token);

        // 解密后token以_分割
        String[] params = pwd.split("_");
        if (ArrayUtil.isEmpty(params)) {
            return false;
        } else if (params.length == 1) {
            throw new BusinessException("token被篡改");
        }

        try {
            Token tokenBean = paramsToToken(params);
            if (BeanUtil.isEmpty(tokenBean)) {
                throw new BusinessException("对象是空");
            }

            // 校验时间
            Long sum = tokenBean.getStartTime() + tokenBean.getExpire();
            Long currentTime = System.currentTimeMillis() / 1000;

            if (currentTime >= sum) {
                return false;
            }
        } catch (Exception e) {
            logger.error("解析token出错 >>> {}", e);
            return false;
        }

        return true;
    }

    /**
     * 参数转Token
     *
     * * @time 06:21
     */
    private static Token paramsToToken(String[] params) {
        Token token = new Token();
        token.setAccountId("null".equals(params[0]) ? null : params[0]);
        token.setAccountName(params[1]);
        token.setExpire("null".equals(params[2]) ? null : Long.parseLong(params[2]));
        token.setStartTime("null".equals(params[3]) ? null : Long.parseLong(params[3]));
        token.setChannelCode("null".equals(params[4]) ? null : params[4]);
        token.setAppCode("null".equals(params[5]) ? null : params[5]);
        return token;
    }

    public static void main(String[] args) {
        Token str = analysisToken("d2ef7834de10c858362386e67dc8edbfd8ef80a38583412f6bf57ebda87d4d177653d1608f16947796ba206ed3a373f6b10a781583426ffe82ebe1958a8d2c6c");
        System.out.println(JSONUtil.toJsonStr(str));
    }
}

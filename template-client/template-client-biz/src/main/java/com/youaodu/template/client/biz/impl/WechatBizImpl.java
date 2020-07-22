package com.youaodu.template.client.biz.impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.sun.corba.se.impl.oa.toa.TOA;
import com.youaodu.template.client.biz.WechatBiz;
import com.youaodu.template.common.entity.model.WeChatAccount;
import com.youaodu.template.common.entity.pojo.dto.client.UserInfoDto;
import com.youaodu.template.common.entity.pojo.vo.client.UserInfoVo;
import com.youaodu.template.common.framework.exception.BusinessException;
import com.youaodu.template.common.framework.exception.ExceptionMessageEnum;
import com.youaodu.template.common.framework.token.BuilderToken;
import com.youaodu.template.common.framework.token.Token;
import com.youaodu.template.common.framework.utils.IdBizCode;
import com.youaodu.template.common.framework.utils.IdGenUtils;
import com.youaodu.template.common.framework.utils.RedisUtils;
import com.youaodu.template.common.service.WeChatAccountService;
import com.youaodu.template.wechat.bo.QueryOpenIdByCodeBoVo;
import com.youaodu.template.wechat.bo.QueryUserInfoByOpenIdBoVo;
import com.youaodu.template.wechat.utils.WeChatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.stereotype.Service;

@Service
public class WechatBizImpl implements WechatBiz {

    @Autowired
    private WeChatAccountService weChatAccountService;

    /**
     * 获取用户基本信息
     * @param userInfoDto
     * @return
     */
    @Override
    public UserInfoVo userInfo(UserInfoDto userInfoDto) {
        if (StrUtil.isNotBlank(userInfoDto.getCode()) && StrUtil.isNotBlank(userInfoDto.getOpenId())) {
            throw new BusinessException("获取用户信息参数错误！！！");
        }

        if (StrUtil.isNotBlank(userInfoDto.getCode())) {
            QueryOpenIdByCodeBoVo tmp = WeChatUtil.queryOpenIdByCode(userInfoDto.getCode());
            // 查找是否存在
            WeChatAccount account = weChatAccountService.getOne(new LambdaQueryWrapper<WeChatAccount>()
                    .eq(WeChatAccount::getOpenId, tmp.getOpenId())
            );

            if (account != null) {
                return openIdToUserInfoVo(tmp.getOpenId(), account);
            } else {
                // 从微信获取用户信息
                QueryUserInfoByOpenIdBoVo tmpResult = WeChatUtil.queryUserInfoByOpenId(tmp.getOpenId(), tmp.getAccessToken());
                WeChatAccount saveBean = new WeChatAccount();
                saveBean.setHeadImg(tmpResult.getHeadimgurl());
                saveBean.setNickName(tmpResult.getNickname());
                saveBean.setOpenId(tmpResult.getOpenid());
                saveBean.setAccountId(IdGenUtils.genId(IdBizCode.ACCOUNT_ID));
                weChatAccountService.save(saveBean);

                return openIdToUserInfoVo(saveBean.getOpenId(), saveBean);
            }

        } else if (StrUtil.isNotBlank(userInfoDto.getOpenId())) {
            // 查找是否存在
            WeChatAccount account = weChatAccountService.getOne(new LambdaQueryWrapper<WeChatAccount>()
                    .eq(WeChatAccount::getOpenId, userInfoDto.getOpenId())
            );

            if (account == null) {
                throw new BusinessException("用户不存在");
            }

            // 结果
            return openIdToUserInfoVo(userInfoDto.getOpenId(), account);

        } else {
            throw new BusinessException(ExceptionMessageEnum.PARAM_NULL);
        }
    }


    /**
     *
     * @param openId
     * @param account
     * @return
     */
    private UserInfoVo openIdToUserInfoVo(String openId, WeChatAccount account) {
        if (account == null) {
            // 查找用户信息
            account = weChatAccountService.getOne(new LambdaQueryWrapper<WeChatAccount>()
                    .eq(WeChatAccount::getOpenId, openId)
            );
        }

        // 生成Token
        Token tokenBean = new Token(account.getAccountId(), account.getOpenId(), "wechat", "wechat");
        String tokenStr = BuilderToken.builderToken(tokenBean);

        // 封装最后返回对象
        UserInfoVo result = new UserInfoVo();
        result.setHeadImg(account.getHeadImg());
        result.setNickName(account.getNickName());
        result.setTokenStr(tokenStr);
        return result;
    }
}

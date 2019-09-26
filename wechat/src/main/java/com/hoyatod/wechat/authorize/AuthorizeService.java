package com.hoyatod.wechat.authorize;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.hoyatod.dto.WechatUserInfoDTO;
import com.hoyatod.util.commom.GsonUtil;
import com.hoyatod.util.commom.OkhttpUtil;
import com.hoyatod.util.commom.Token;
import com.hoyatod.util.commom.WeiXinSDK;


/**
 * @author xul
 * @Date 2018年3月16日 下午14:52
 */
@Service
public class AuthorizeService {
	
	public Token getTokenByCode(String code) throws IOException {
		String doGetHttpRequest = OkhttpUtil.doGetHttpRequest(WeiXinSDK.CODE.replace("APPID", WeiXinSDK.APPID).replace("SECRET", WeiXinSDK.APPSECRET).replace("CODE", code));
		Token gsonToBean = GsonUtil.GsonToBean(doGetHttpRequest, Token.class);
		if(null!=gsonToBean.getErrcode()||null != gsonToBean.getErrmsg()) {
			return null;
		}
		return gsonToBean;
	}
	
	public WechatUserInfoDTO getUserInfo(Token token) throws IOException {
		if(token == null) {
			return null;
		}
		String doGetHttpRequest = OkhttpUtil.doGetHttpRequest(WeiXinSDK.USERINFO.replace("ACCESS_TOKEN", token.getAccess_token()).replace("OPENID", token.getOpenid()));
		WechatUserInfoDTO gsonToBean = GsonUtil.GsonToBean(doGetHttpRequest, WechatUserInfoDTO.class);
		System.out.println("doGetHttpRequest:"+gsonToBean);
		return gsonToBean;
	}
}

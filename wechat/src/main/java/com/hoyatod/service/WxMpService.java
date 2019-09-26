package com.hoyatod.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import me.chanjar.weixin.common.bean.WxJsapiSignature;
import me.chanjar.weixin.common.bean.WxMenu;
import me.chanjar.weixin.common.bean.result.WxMediaUploadResult;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.util.http.RequestExecutor;
import me.chanjar.weixin.mp.api.WxMpConfigStorage;
import me.chanjar.weixin.mp.api.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.WxMpCustomMessage;
import me.chanjar.weixin.mp.bean.WxMpGroup;
import me.chanjar.weixin.mp.bean.WxMpMassGroupMessage;
import me.chanjar.weixin.mp.bean.WxMpMassNews;
import me.chanjar.weixin.mp.bean.WxMpMassOpenIdsMessage;
import me.chanjar.weixin.mp.bean.WxMpMassVideo;
import me.chanjar.weixin.mp.bean.WxMpMaterial;
import me.chanjar.weixin.mp.bean.WxMpMaterialArticleUpdate;
import me.chanjar.weixin.mp.bean.WxMpMaterialNews;
import me.chanjar.weixin.mp.bean.WxMpSemanticQuery;
import me.chanjar.weixin.mp.bean.WxMpTemplateMessage;
import me.chanjar.weixin.mp.bean.result.WxMpMassSendResult;
import me.chanjar.weixin.mp.bean.result.WxMpMassUploadResult;
import me.chanjar.weixin.mp.bean.result.WxMpMaterialCountResult;
import me.chanjar.weixin.mp.bean.result.WxMpMaterialFileBatchGetResult;
import me.chanjar.weixin.mp.bean.result.WxMpMaterialNewsBatchGetResult;
import me.chanjar.weixin.mp.bean.result.WxMpMaterialUploadResult;
import me.chanjar.weixin.mp.bean.result.WxMpMaterialVideoInfoResult;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpPayCallback;
import me.chanjar.weixin.mp.bean.result.WxMpPayResult;
import me.chanjar.weixin.mp.bean.result.WxMpPrepayIdResult;
import me.chanjar.weixin.mp.bean.result.WxMpQrCodeTicket;
import me.chanjar.weixin.mp.bean.result.WxMpSemanticQueryResult;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import me.chanjar.weixin.mp.bean.result.WxMpUserCumulate;
import me.chanjar.weixin.mp.bean.result.WxMpUserList;
import me.chanjar.weixin.mp.bean.result.WxMpUserSummary;
import me.chanjar.weixin.mp.bean.result.WxRedpackResult;

/**
 * 微信开发常用接口
 * 
 * @author xul
 */
@Service
public class WxMpService implements me.chanjar.weixin.mp.api.WxMpService{
	
	private WxMpServiceImpl wx; 
	
	public WxMpService() {
		 wx = new WxMpServiceImpl();
	}
	 
	@Override
	public boolean checkJSSDKCallbackDataSignature(Map<String, String> kvm, String signature) {
		boolean checkJSSDKCallbackDataSignature = wx.checkJSSDKCallbackDataSignature(kvm, signature);
		return checkJSSDKCallbackDataSignature;
	}

	@Override
	public boolean checkSignature(String arg0, String arg1, String arg2) {
		return wx.checkSignature(arg0, arg1, arg2);
	}

	@Override
	public WxJsapiSignature createJsapiSignature(String arg0) throws WxErrorException {
		return wx.createJsapiSignature(arg0);
	}

	@Override
	public void customMessageSend(WxMpCustomMessage arg0) throws WxErrorException {
		wx.customMessageSend(arg0);
		
	}

	@Override
	public <T, E> T execute(RequestExecutor<T, E> arg0, String arg1, E arg2) throws WxErrorException {
		return wx.execute(arg0, arg1, arg2);
	}

	@Override
	public String get(String url, String queryParam) throws WxErrorException {
		return wx.get(url, queryParam);
	}

	@Override
	public String getAccessToken() throws WxErrorException {
		return wx.getAccessToken();
	}

	@Override
	public String getAccessToken(boolean arg0) throws WxErrorException {
		return wx.getAccessToken(arg0);
	}

	@Override
	public String[] getCallbackIP() throws WxErrorException {
		return wx.getCallbackIP();
	}

	@Override
	public WxMpPayCallback getJSSDKCallbackData(String arg0) {
		return wx.getJSSDKCallbackData(arg0);
	}

	@Override
	public Map<String, String> getJSSDKPayInfo(Map<String, String> parameters) {
		return wx.getJSSDKPayInfo(parameters);
	}

	@Override
	public Map<String, String> getJSSDKPayInfo(String openId, String outTradeNo, double amt, String body, String tradeType,String ip, String callbackUrl) {
		return wx.getJSSDKPayInfo(openId, outTradeNo, amt, body, tradeType, ip, callbackUrl);
	}

	@Override
	public WxMpPayResult getJSSDKPayResult(String arg0, String arg1) {
		return wx.getJSSDKPayResult(arg0, arg1);
	}

	@Override
	public String getJsapiTicket() throws WxErrorException {
		return wx.getJsapiTicket();
	}

	@Override
	public String getJsapiTicket(boolean arg0) throws WxErrorException {
		return wx.getJsapiTicket(arg0);
	}

	@Override
	public WxMpPrepayIdResult getPrepayId(Map<String, String> arg0) {
		return wx.getPrepayId(arg0);
	}

	/* (non-Javadoc)
	 * @see me.chanjar.weixin.mp.api.WxMpService#getPrepayId(java.lang.String, java.lang.String, double, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public WxMpPrepayIdResult getPrepayId(String openId, String outTradeNo, double amt, String body, String tradeType, String ip,
			String callbackUrl) {
		return wx.getPrepayId(openId, outTradeNo, amt, body, tradeType, ip, callbackUrl);
	}

	@Override
	public List<WxMpUserCumulate> getUserCumulate(Date beginDate, Date endDate) throws WxErrorException {
		return wx.getUserCumulate(beginDate, endDate);
	}

	@Override
	public List<WxMpUserSummary> getUserSummary(Date beginDate, Date endDate) throws WxErrorException {
		return wx.getUserSummary(beginDate, endDate);
	}

	@Override
	public WxMpGroup groupCreate(String name) throws WxErrorException {
		return wx.groupCreate(name);
	}

	@Override
	public List<WxMpGroup> groupGet() throws WxErrorException {
		return wx.groupGet();
	}

	@Override
	public void groupUpdate(WxMpGroup group) throws WxErrorException {
		wx.groupUpdate(group);
	}

	@Override
	public WxMpMassSendResult massGroupMessageSend(WxMpMassGroupMessage message) throws WxErrorException {
		return wx.massGroupMessageSend(message);
	}

	@Override
	public WxMpMassUploadResult massNewsUpload(WxMpMassNews message) throws WxErrorException {
		return wx.massNewsUpload(message);
	}

	@Override
	public WxMpMassSendResult massOpenIdsMessageSend(WxMpMassOpenIdsMessage message) throws WxErrorException {
		return wx.massOpenIdsMessageSend(message);
	}

	@Override
	public WxMpMassUploadResult massVideoUpload(WxMpMassVideo video) throws WxErrorException {
		return wx.massVideoUpload(video);
	}

	@Override
	public WxMpMaterialCountResult materialCount() throws WxErrorException {
		return wx.materialCount();
	}

	@Override
	public boolean materialDelete(String media_id) throws WxErrorException {
		return wx.materialDelete(media_id);
	}

	@Override
	public WxMpMaterialFileBatchGetResult materialFileBatchGet(String type, int offset, int count)
			throws WxErrorException {
		return wx.materialFileBatchGet(type, offset, count);
	}

	@Override
	public WxMpMaterialUploadResult materialFileUpload(String mediaType, WxMpMaterial material) throws WxErrorException {
		return wx.materialFileUpload(mediaType, material);
	}

	@Override
	public InputStream materialImageOrVoiceDownload(String media_id) throws WxErrorException {
		return wx.materialImageOrVoiceDownload(media_id);
	}

	@Override
	public WxMpMaterialNewsBatchGetResult materialNewsBatchGet(int offset, int count) throws WxErrorException {
		return wx.materialNewsBatchGet(offset, count);
	}

	@Override
	public WxMpMaterialNews materialNewsInfo(String media_id) throws WxErrorException {
		return wx.materialNewsInfo(media_id);
	}

	@Override
	public boolean materialNewsUpdate(WxMpMaterialArticleUpdate wxMpMaterialArticleUpdate) throws WxErrorException {
		return wx.materialNewsUpdate(wxMpMaterialArticleUpdate);
	}

	@Override
	public WxMpMaterialUploadResult materialNewsUpload(WxMpMaterialNews news) throws WxErrorException {
		return wx.materialNewsUpload(news);
	}

	@Override
	public WxMpMaterialVideoInfoResult materialVideoInfo(String arg0) throws WxErrorException {
		return null;
	}

	@Override
	public File mediaDownload(String media_id) throws WxErrorException {
		return wx.mediaDownload(media_id);
	}

	@Override
	public WxMediaUploadResult mediaUpload(String arg0, File arg1) throws WxErrorException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WxMediaUploadResult mediaUpload(String arg0, String arg1, InputStream arg2)
			throws WxErrorException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void menuCreate(WxMenu arg0) throws WxErrorException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuDelete() throws WxErrorException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuDelete(String arg0) throws WxErrorException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public WxMenu menuGet() throws WxErrorException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WxMenu menuTryMatch(String arg0) throws WxErrorException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String oauth2buildAuthorizationUrl(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String oauth2buildAuthorizationUrl(String arg0, String arg1, String arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WxMpOAuth2AccessToken oauth2getAccessToken(String arg0) throws WxErrorException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WxMpUser oauth2getUserInfo(WxMpOAuth2AccessToken arg0, String arg1) throws WxErrorException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WxMpOAuth2AccessToken oauth2refreshAccessToken(String arg0) throws WxErrorException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean oauth2validateAccessToken(WxMpOAuth2AccessToken arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String post(String arg0, String arg1) throws WxErrorException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WxMpQrCodeTicket qrCodeCreateLastTicket(int arg0) throws WxErrorException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WxMpQrCodeTicket qrCodeCreateLastTicket(String arg0) throws WxErrorException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WxMpQrCodeTicket qrCodeCreateTmpTicket(int arg0, Integer arg1) throws WxErrorException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public File qrCodePicture(WxMpQrCodeTicket arg0) throws WxErrorException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WxMpSemanticQueryResult semanticQuery(WxMpSemanticQuery arg0) throws WxErrorException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WxRedpackResult sendRedpack(Map<String, String> arg0) throws WxErrorException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMaxRetryTimes(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRetrySleepMillis(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setWxMpConfigStorage(WxMpConfigStorage arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String shortUrl(String arg0) throws WxErrorException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String templateSend(WxMpTemplateMessage arg0) throws WxErrorException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long userGetGroup(String arg0) throws WxErrorException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public WxMpUser userInfo(String arg0, String arg1) throws WxErrorException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WxMpUserList userList(String arg0) throws WxErrorException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void userUpdateGroup(String arg0, long arg1) throws WxErrorException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void userUpdateRemark(String arg0, String arg1) throws WxErrorException {
		// TODO Auto-generated method stub
		
	}
	
}

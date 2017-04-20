package com.yzz.entity; 

/** 
* 
* @description: wx_cms_public_account表的实体类WxCmsPublicAccount 
* 
* @author 杨志钊 
* @date 2017-04-17 18:20:30 
*/ 

public class WxCmsPublicAccount {

	private String wxCmsPublicAccountId;//公众号ID

	private String url;//服务器地址（URL）

	private String token;//Token可由开发者可以任意填写，用作生成签名（该Token会和接口URL中包含的Token进行比对，从而验证安全性）

	private String encodingAesKey;//EncodingAESKey由开发者手动填写或随机生成，将用作消息体加解密密钥

	private String grantType;//获取access_token填写client_credential

	private String appId;//第三方用户唯一凭证

	private String appSecret;//第三方用户唯一凭证密钥

	private String accessToken;//access_token是公众号的全局唯一票据，公众号调用各接口时都需使用access_token。开发者需要进行妥善保存。access_token的存储至少要保留512个字符空间。access_token的有效期目前为2个小时，需定时刷新，重复获取将导致上次获取的access_token失效。

	private String accessTokenLastModifyTime;//access_token最新更新时间

	public String getWxCmsPublicAccountId() { 
		return wxCmsPublicAccountId; 
	} 

	public void setWxCmsPublicAccountId(String wxCmsPublicAccountId) { 
 		this.wxCmsPublicAccountId = wxCmsPublicAccountId == null ? null : wxCmsPublicAccountId.trim(); 
	} 

	public String getUrl() { 
		return url; 
	} 

	public void setUrl(String url) { 
 		this.url = url == null ? null : url.trim(); 
	} 

	public String getToken() { 
		return token; 
	} 

	public void setToken(String token) { 
 		this.token = token == null ? null : token.trim(); 
	} 

	public String getEncodingAesKey() { 
		return encodingAesKey; 
	} 

	public void setEncodingAesKey(String encodingAesKey) { 
 		this.encodingAesKey = encodingAesKey == null ? null : encodingAesKey.trim(); 
	} 

	public String getGrantType() { 
		return grantType; 
	} 

	public void setGrantType(String grantType) { 
 		this.grantType = grantType == null ? null : grantType.trim(); 
	} 

	public String getAppId() { 
		return appId; 
	} 

	public void setAppId(String appId) { 
 		this.appId = appId == null ? null : appId.trim(); 
	} 

	public String getAppSecret() { 
		return appSecret; 
	} 

	public void setAppSecret(String appSecret) { 
 		this.appSecret = appSecret == null ? null : appSecret.trim(); 
	} 

	public String getAccessToken() { 
		return accessToken; 
	} 

	public void setAccessToken(String accessToken) { 
 		this.accessToken = accessToken == null ? null : accessToken.trim(); 
	} 

	public String getAccessTokenLastModifyTime() { 
		return accessTokenLastModifyTime; 
	} 

	public void setAccessTokenLastModifyTime(String accessTokenLastModifyTime) { 
 		this.accessTokenLastModifyTime = accessTokenLastModifyTime == null ? null : accessTokenLastModifyTime.trim(); 
	} 

 
 } 

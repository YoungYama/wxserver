package com.yzz.wechat.pojo;

/**
 * OAuth token
 */
public class OAuth2AccessToken extends AccessToken {

	// oauth2.0
	private String refreshToken;// 刷新token
	private String openid;
	private String scope;

	public String getrefreshToken() {
		return refreshToken;
	}

	public void setrefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

}

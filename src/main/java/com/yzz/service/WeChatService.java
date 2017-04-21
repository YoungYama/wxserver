package com.yzz.service;

import com.yzz.dto.ResultData;
import com.yzz.entity.WxCmsPublicAccount;

public interface WeChatService {

	/**
	 * 获取公众号的全局唯一票据access_token
	 * @param entity
	 * @return
	 */
	String getAccessToken(WxCmsPublicAccount entity);
	
	/**
	 * 
	 * @param accessToken
	 * @return
	 */
	String getMenu(String accessToken);
	
	/**
	 * 
	 * @param accessToken
	 * @return
	 */
	boolean createMenu(String accessToken, String menuJsonString);
	
	/**
	 * 删除
	 * @param accessToken
	 * @return
	 */
	boolean deleteMenu(String accessToken);

}

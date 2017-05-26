package com.yzz.service;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSONObject;
import com.yzz.dto.ResultData;
import com.yzz.entity.WxCmsMenu;
import com.yzz.entity.WxCmsPublicAccount;

public interface WeChatService {
	
	/**
	 * 处理公众号粉丝发出的请求
	 * @param token
	 * @param request
	 * @return
	 */
	String handleMessage(String token, HttpServletRequest request);

	/**
	 * 获取公众号的全局唯一票据access_token
	 * @param entity
	 * @return
	 */
	String getAccessToken(WxCmsPublicAccount entity);
	
	/**
	 * 获取菜单
	 * @param accessToken
	 * @return
	 */
	String getMenu(String accessToken);
	
	/**
	 * 创建菜单
	 * @param entity
	 * @param wxCmsPublicAccountId
	 * @return
	 */
	ResultData<JSONObject> createMenu(WxCmsMenu entity, String wxCmsPublicAccountId);
	
	/**
	 * 删除
	 * @param accessToken
	 * @return
	 */
	boolean deleteMenu(String accessToken);

}

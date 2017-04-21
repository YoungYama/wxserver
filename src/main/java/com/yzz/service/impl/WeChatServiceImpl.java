package com.yzz.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.yzz.dao.WxCmsPublicAccountDao;
import com.yzz.entity.WxCmsPublicAccount;
import com.yzz.service.WeChatService;
import com.yzz.util.HttpUtil;
import com.yzz.util.TimeUtil;
import com.yzz.util.UserOperatedState;
import com.yzz.util.WeChatErrorMsg;

@Service
public class WeChatServiceImpl implements WeChatService {

	private Logger logger = Logger.getLogger(this.getClass());

	private String GET_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

	private String GET_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";

	private String CREATE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

	private String DELETE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";

	@Resource
	WxCmsPublicAccountDao wxCmsPublicAccountDao;

	@Override
	public String getAccessToken(WxCmsPublicAccount entity) {
		String accessToken = null;

		if (isTimeOutGetAccessToken(entity)) {// 过时
			GET_ACCESS_TOKEN_URL = GET_ACCESS_TOKEN_URL.replace("APPID", entity.getAppId()).replace("APPSECRET",
					entity.getAppSecret());

			try {
				JSONObject result = HttpUtil.doGetStr(GET_ACCESS_TOKEN_URL);
				if (result.containsKey("errcode")) {
					int errorCode = result.getInteger("errcode");

					logger.error(UserOperatedState.INNER_ERROR + ":" + WeChatErrorMsg.errorMsg(errorCode));
				} else {
					if (result.containsKey("access_token")) {
						accessToken = result.getString("access_token");
					} else {
						logger.error(UserOperatedState.INNER_ERROR + ":" + result);
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
				logger.error(UserOperatedState.INNER_ERROR + ":" + e.getMessage());
			}

		} else {
			accessToken = entity.getAccessToken();
		}

		return accessToken;
	}

	@Override
	public String getMenu(String accessToken) {
		String menu = null;

		GET_MENU_URL = GET_MENU_URL.replace("ACCESS_TOKEN", accessToken);
		try {
			JSONObject result = HttpUtil.doGetStr(GET_MENU_URL);
			if (result.containsKey("errcode")) {
				int errorCode = result.getInteger("errcode");

				logger.error(UserOperatedState.INNER_ERROR + ":" + WeChatErrorMsg.errorMsg(errorCode));
			} else {
				if (result.containsKey("menu")) {
					menu = result.getString("menu");
				} else {
					logger.error(UserOperatedState.INNER_ERROR + ":" + result);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(UserOperatedState.INNER_ERROR + ":" + e.getMessage());
		}

		return menu;
	}

	@Override
	public boolean createMenu(String accessToken, String menuJsonString) {
		CREATE_MENU_URL = CREATE_MENU_URL.replace("ACCESS_TOKEN", accessToken);
		try {
			JSONObject result = HttpUtil.doPostStr(CREATE_MENU_URL, menuJsonString);
			if (result.containsKey("errcode")) {
				int errorCode = result.getInteger("errcode");
				if (errorCode == 0) {
					return true;
				} else {
					logger.error(UserOperatedState.INNER_ERROR + ":" + WeChatErrorMsg.errorMsg(errorCode));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(UserOperatedState.INNER_ERROR + ":" + e.getMessage());
		}

		return false;
	}

	@Override
	public boolean deleteMenu(String accessToken) {
		DELETE_MENU_URL = DELETE_MENU_URL.replace("ACCESS_TOKEN", accessToken);
		try {
			JSONObject result = HttpUtil.doGetStr(DELETE_MENU_URL);
			if (result.containsKey("errcode")) {
				int errorCode = result.getInteger("errcode");
				if (errorCode == 0) {
					return true;
				} else {
					logger.error(UserOperatedState.INNER_ERROR + ":" + WeChatErrorMsg.errorMsg(errorCode));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(UserOperatedState.INNER_ERROR + ":" + e.getMessage());
		}

		return false;
	}

	private boolean isTimeOutGetAccessToken(WxCmsPublicAccount entity) {
		boolean result = false;
		long accessTokenLastModifyTime = Long.parseLong(entity.getAccessTokenLastModifyTime());
		long now = TimeUtil.getTimeInSeconds();
		if ((now - accessTokenLastModifyTime) >= (7200 - 10)) {// 预留10秒
			result = true;// 过时
		}

		return result;
	}

}

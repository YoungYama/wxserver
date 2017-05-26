package com.yzz.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yzz.dao.WxCmsMenuDao;
import com.yzz.dao.WxCmsPublicAccountDao;
import com.yzz.dto.Page;
import com.yzz.dto.ResultData;
import com.yzz.entity.WxCmsMenu;
import com.yzz.entity.WxCmsPublicAccount;
import com.yzz.service.WeChatService;
import com.yzz.util.HandleMessageUtil;
import com.yzz.util.HttpUtil;
import com.yzz.util.TimeUtil;
import com.yzz.util.UserOperatedState;
import com.yzz.util.WeChatErrorMsg;
import com.yzz.wechat.pojo.menu.Button;
import com.yzz.wechat.pojo.menu.EventButton;
import com.yzz.wechat.pojo.menu.Menu;
import com.yzz.wechat.pojo.menu.ViewButton;

@Service
public class WeChatServiceImpl implements WeChatService {

	private Logger logger = Logger.getLogger(this.getClass());

	private String GET_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

	private String GET_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";

	private String CREATE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

	private String DELETE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";

	@Resource
	WxCmsPublicAccountDao wxCmsPublicAccountDao;

	@Resource
	WxCmsMenuDao wxCmsMenuDao;

	@Override
	public String handleMessage(String token, HttpServletRequest request) {
		String message = null;

		try {
			message = HandleMessageUtil.initMessage(token, request);
		} catch (Exception e) {

			logger.error(UserOperatedState.INNER_ERROR + ":" + e.getMessage());
			e.printStackTrace();
		}

		return message;
	}

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
						// 更新数据库里的accessToken及其最后修改时间
						entity.setAccessToken(accessToken);
						entity.setAccessTokenLastModifyTime(TimeUtil.getCurrentTimeLong());
						wxCmsPublicAccountDao.updateByPrimaryKey(entity);
					} else {
						logger.error(UserOperatedState.INNER_ERROR + ":" + result);
					}
				}

			} catch (Exception e) {

				logger.error(UserOperatedState.INNER_ERROR + ":" + e.getMessage());
				e.printStackTrace();
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

			logger.error(UserOperatedState.INNER_ERROR + ":" + e.getMessage());
			e.printStackTrace();
		}

		return menu;
	}

	@Override
	public ResultData<JSONObject> createMenu(WxCmsMenu wxCmsMenu, String wxCmsPublicAccountId) {
		ResultData<JSONObject> resultData = new ResultData<JSONObject>();
		JSONObject jsonObject = null;
		Page page = new Page();
		page.setOrderField("but_sort");
		page.setSort("ASC");
		List<WxCmsMenu> wxCmsMenus = wxCmsMenuDao.selectByEntityAndPage(wxCmsMenu, page);
		if (wxCmsMenus.size() <= 0) {
			resultData.setCode(400);
			resultData.setMsg(UserOperatedState.CREATE_MENU_ERROR);

			return resultData;
		}
		Menu menu = initMenu(wxCmsMenus);
		jsonObject = (JSONObject) JSON.toJSON(menu);
		WxCmsPublicAccount wxCmsPublicAccount = wxCmsPublicAccountDao.selectByPrimaryKey(wxCmsPublicAccountId);
		String accessToken = getAccessToken(wxCmsPublicAccount);
		String menuJsonString = jsonObject.toJSONString();

		CREATE_MENU_URL = CREATE_MENU_URL.replace("ACCESS_TOKEN", accessToken);
		try {
			JSONObject result = HttpUtil.doPostStr(CREATE_MENU_URL, menuJsonString);
			if (result.containsKey("errcode")) {
				int errorCode = result.getInteger("errcode");
				if (errorCode == 0) {
					resultData.setData(jsonObject);
					resultData.setMsg(UserOperatedState.CREATE_MENU_SUCCESS);
					
					return resultData;
				} else {
					logger.error(UserOperatedState.INNER_ERROR + ":" + WeChatErrorMsg.errorMsg(errorCode));
					resultData.setCode(400);
					resultData.setMsg(UserOperatedState.INNER_ERROR + ":" + WeChatErrorMsg.errorMsg(errorCode));
				}
			}
		} catch (Exception e) {

			logger.error(UserOperatedState.INNER_ERROR + ":" + e.getMessage());
			e.printStackTrace();
			resultData.setCode(400);
			resultData.setMsg(UserOperatedState.INNER_ERROR + ":" + e.getMessage());
		}

		return resultData;
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

			logger.error(UserOperatedState.INNER_ERROR + ":" + e.getMessage());
			e.printStackTrace();
		}

		return false;
	}

	private boolean isTimeOutGetAccessToken(WxCmsPublicAccount entity) {
		boolean result = false;
		Long accessTokenLastModifyTime = entity.getAccessTokenLastModifyTime();
		if (accessTokenLastModifyTime == null) {
			result = true;// 过时
		} else {
			long now = TimeUtil.getTimeInMillis();
			if (((now - accessTokenLastModifyTime) / 1000) >= (7200 - 10)) {// 预留10秒
				result = true;// 过时
			}
		}

		return result;
	}

	/**
	 * 组装菜单
	 * 
	 * @param wxCmsMenus
	 * @return
	 */
	public Menu initMenu(List<WxCmsMenu> wxCmsMenus) {
		Menu menu = new Menu();
		Button button = null;
		List<Button> buttons = new ArrayList<Button>();
		List<Button> temp = null;
		Map<String, List<Button>> map = new HashMap<String, List<Button>>();
		ViewButton viewButton = new ViewButton();
		EventButton eventButton = new EventButton();
		for (WxCmsMenu wxCmsMenu : wxCmsMenus) {
			viewButton = new ViewButton();
			eventButton = new EventButton();
			String butType = wxCmsMenu.getButType();
			if (butType.equals("view")) {// 跳转URL类型按钮
				viewButton.setName(wxCmsMenu.getButName());
				viewButton.setType(butType);
				viewButton.setUrl(wxCmsMenu.getButUrl());

				button = viewButton;
			} else {// 非跳转URL类型按钮
				eventButton.setName(wxCmsMenu.getButName());
				eventButton.setType(butType);
				eventButton.setKey(wxCmsMenu.getButKey());

				button = eventButton;
			}

			String parentId = wxCmsMenu.getParentId();
			if (parentId.equals("0")) {// 只有一级菜单，不包含二级菜单
				buttons.add(button);// 直接把一级菜单装入
			} else {// 有二级菜单，先把二级菜单放在map里
				if (map.containsKey(parentId)) {// 已经存在
					temp = map.get(parentId);
					temp.add(button);
					map.put(parentId, temp);
				} else {
					temp = new ArrayList<Button>();
					temp.add(button);
					map.put(parentId, temp);
				}
			}
		}
		Set<String> keys = map.keySet();
		Button[] buttonsTemp = null;
		for (String key : keys) {// 把二级菜单装入
			button = new Button();
			temp = map.get(key);
			buttonsTemp = new Button[temp.size() - 1];
			for (int i = 0, length = temp.size(); i < length; i++) {
				if (i == 0) {
					button.setName(temp.get(i).getName());
				} else {
					buttonsTemp[i - 1] = temp.get(i);
				}
			}
			// 包括二级菜单的菜单
			button.setSub_button(buttonsTemp);
			buttons.add(button);
		}

		menu.setButton(buttons.toArray(new Button[buttons.size()]));

		return menu;
	}

}

package com.yzz.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.yzz.dao.WxCmsMenuDao;
import com.yzz.dao.WxCmsPublicAccountDao;
import com.yzz.dto.Page;
import com.yzz.entity.WxCmsMenu;
import com.yzz.entity.WxCmsPublicAccount;
import com.yzz.service.WeChatService;
import com.yzz.wechat.pojo.menu.Button;
import com.yzz.wechat.pojo.menu.EventButton;
import com.yzz.wechat.pojo.menu.Menu;
import com.yzz.wechat.pojo.menu.ViewButton;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:springmvc-servlet.xml", "classpath:applicationContext.xml" })
public class WeChatServiceTest {
	
	private static Logger logger = Logger.getLogger(WeChatServiceTest.class);
	
	@Resource
	WeChatService weChatService;
	
	@Resource
	WxCmsMenuDao wxCmsMenuDao;
	
	@Resource
	WxCmsPublicAccountDao wxCmsPublicAccountDao;
	
	@Test
	public void test() throws Exception {
		WxCmsPublicAccount entity = new WxCmsPublicAccount();
		entity.setToken("yang");
		List<WxCmsPublicAccount> accounts = wxCmsPublicAccountDao.selectByEntityAndPage(entity, null);
		entity = accounts.get(0);
		String accessToken = weChatService.getAccessToken(entity);
		WxCmsMenu menuEntity = new WxCmsMenu();
		menuEntity.setWxCmsMenuGroupId(1);
		menuEntity.setWxCmsPublicAccountId("6784a1e7-425a-47e9-8b70-4363416bb00f-1483702770212");
		Page page = new Page();
		page.setOrderField("but_sort");
		page.setSort("ASC");
		page.setCurrentPage(1);
		page.setStart(0);
		page.setPageSize(25);
		List<WxCmsMenu> wxCmsMenus = wxCmsMenuDao.selectByEntityAndPage(menuEntity, page);
		Menu menu = initMenu(wxCmsMenus);
		logger.info(JSON.toJSONString(menu));
//		logger.info(weChatService.getMenu(accessToken));
//		Menu menu = initMenu();
		String menuJsonString = JSON.toJSONString(menu);
//		logger.info(weChatService.createMenu(accessToken, menuJsonString));
	}
	
	public Menu initMenu(List<WxCmsMenu> wxCmsMenus){
		Menu menu = new Menu();
		Button button = null;
		List<Button> buttons = new ArrayList<Button>();
		List<Button> temp = null;
		Map<String,List<Button>> map = new HashMap<String, List<Button>>();
		ViewButton viewButton = new ViewButton();
		EventButton eventButton = new EventButton();
		for (WxCmsMenu wxCmsMenu : wxCmsMenus) {
			viewButton = new ViewButton();
			eventButton = new EventButton();
			String butType = wxCmsMenu.getButType();
			if (butType.equals("view")) {//跳转URL类型按钮
				viewButton.setName(wxCmsMenu.getButName());
				viewButton.setType(butType);
				viewButton.setUrl(wxCmsMenu.getButUrl());
				
				button = viewButton;
			} else {//非跳转URL类型按钮
				eventButton.setName(wxCmsMenu.getButName());
				eventButton.setType(butType);
				eventButton.setKey(wxCmsMenu.getButKey());
				
				button = eventButton;
			}
			
			String parentId = wxCmsMenu.getParentId();
			if (parentId.equals("0")) {//只有一级菜单，不包含二级菜单
				buttons.add(button);//直接把一级菜单装入
			} else {//有二级菜单，先把二级菜单放在map里
				if (map.containsKey(parentId)) {//已经存在
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
		for (String key : keys) {//把二级菜单装入
			button = new Button();
			temp = map.get(key);
			buttonsTemp = new Button[temp.size() - 1];
			for (int i = 0, length = temp.size(); i < length; i++) {
				if (i == 0) {
					button.setName(temp.get(i).getName());
				}else{
					buttonsTemp[i-1] = temp.get(i);
				}
			}
			//包括二级菜单的菜单
			button.setSub_button(buttonsTemp);
			buttons.add(button);
		}
		
		menu.setButton(buttons.toArray(new Button[buttons.size()]));
		
		return menu;
	}
	
	/**
	 * 组装菜单
	 * @return
	 */
	public Menu initMenu(){
		Menu menu = new Menu();
		EventButton button11 = new EventButton();
		button11.setName("click菜单");
		button11.setType("click");
		button11.setKey("11");
		
		ViewButton button21 = new ViewButton();
		button21.setName("view菜单");
		button21.setType("view");
		button21.setUrl("http://www.imooc.com");
		
		EventButton button31 = new EventButton();
		button31.setName("扫码事件");
		button31.setType("scancode_push");
		button31.setKey("31");
		
		EventButton button32 = new EventButton();
		button32.setName("地理位置");
		button32.setType("location_select");
		button32.setKey("32");
		
		Button button = new Button();
		button.setName("菜单");
		button.setSub_button(new Button[]{button31,button32});
		
		menu.setButton(new Button[]{button11,button21,button});
		return menu;
	}

}

package com.yzz.ctrl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yzz.service.WeChatService;
import com.yzz.util.HandleMessageUtil;
import com.yzz.util.WeChatSignUtil;

@Controller
@RequestMapping("/wxapi")
public class WeChatApiCtrl {
	
	private static final Logger logger = Logger.getLogger(WeChatApiCtrl.class);
	
	@Resource
	private WeChatService weChatService;

	/**
	 * 对公众号粉丝发出的不同类型的信息、事件请求进行处理，并给出相应的响应message【xml格式】
	 * 
	 * @param token
	 * @param request
	 * @param response
	 * @return 相应的响应message【xml格式】
	 */
	@RequestMapping(value = "/handler/{token}", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String handleMsgRequest(@PathVariable("token") String token, HttpServletRequest request,
			HttpServletResponse response) {
		String responsiveMsg = null;

		try {

			// 对公众号粉丝发出的不同类型的信息、事件请求进行处理，并返回相应的响应message【xml格式】
			responsiveMsg = HandleMessageUtil.handleMessage(token, request, weChatService);// 响应信息
		} catch (Exception e) {
			logger.error("【POST请求】" + "TOKEN【" + token + "】请求处理出错：" + e.getMessage());
		}

		return responsiveMsg;
	}

	/**
	 * 验证微信开发者服务器地址的有效性
	 * @param token
	 * @param request
	 * @return 验证结果
	 */
	@RequestMapping(value = "/handler/{token}", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String publicAccountSignature(@PathVariable("token") String token, HttpServletRequest request) {
		String result = null;
		try {
			// 验证微信开发者服务器地址的有效性
			
			result = WeChatSignUtil.validSign(token, request);
		} catch (Exception e) {
			logger.error("【GET请求】" + "TOKEN【" + token + "】验证微信开发者服务器地址的有效性时出错：" + e.getMessage());
		}
		
		return result;
	}

}
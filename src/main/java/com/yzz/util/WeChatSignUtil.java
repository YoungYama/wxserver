package com.yzz.util;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

public class WeChatSignUtil {

	private static final Logger logger = Logger.getLogger(WeChatSignUtil.class);

	/**
	 * 【验证服务器地址的有效性】开发者通过检验signature对请求进行校验（下面有校验方式）。若确认此次GET请求来自微信服务器，请原样返回echostr参数内容，则接入生效，成为开发者成功，否则接入失败。
	 * 加密/校验流程如下： 1. 将token、timestamp、nonce三个参数进行字典序排序 2.
	 * 将三个参数字符串拼接成一个字符串进行sha1加密 3. 开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
	 * 
	 * @param TOKEN
	 *            Token可由开发者可以任意填写，用作生成签名（该Token会和接口URL中包含的Token进行比对，从而验证安全性）
	 * @param request
	 * @return
	 */
	public static String validSign(String TOKEN, HttpServletRequest request) {

		String signature = request.getParameter("signature");// 微信加密签名
		String echostr = request.getParameter("echostr");// 随机字符串
		String timestamp = request.getParameter("timestamp");// 时间戳
		String nonce = request.getParameter("nonce");// 随机数

		// 字典排序【按照字母顺序，或者数字小大顺序，由小到大的形成序列】
		String[] str = { TOKEN, timestamp, nonce };
		Arrays.sort(str); 
		String bigStr = str[0] + str[1] + str[2];
		//sha1加密
		String digest = EncryptionUtil.encodeBySha1(bigStr);

		// 确认请求来至微信
		if (digest.equals(signature)) {
			logger.debug("【GET请求】" + "TOKEN【" + TOKEN + "】调用***validSign()方法***微信开发者模式成功启动");

			return echostr;
		} else {
			logger.error("【GET请求】" + "TOKEN【" + TOKEN + "】调用***validSign()方法***微信开发者模式启动失败");

			return "error";
		}

	}
	
}

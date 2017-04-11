package com.yzz.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.yzz.service.WeChatService;
import com.yzz.wechat.pojo.Image;
import com.yzz.wechat.pojo.ImageMessage;
import com.yzz.wechat.pojo.MusicMessage;
import com.yzz.wechat.pojo.News;
import com.yzz.wechat.pojo.NewsMessage;
import com.yzz.wechat.pojo.TextMessage;
import com.thoughtworks.xstream.XStream;

public class HandleMessageUtil {

	private static final Logger logger = Logger.getLogger(HandleMessageUtil.class);

	// 事件类型
	public static final String MESSAGE_TEXT = "text";
	public static final String MESSAGE_IMAGE = "image";
	public static final String MESSAGE_VOICE = "voice";
	public static final String MESSAGE_VIDEO = "video";
	public static final String MESSAGE_MUSIC = "music";
	public static final String MESSAGE_LINK = "link";
	public static final String MESSAGE_NEWS = "news";
	public static final String MESSAGE_LOCATION = "location";
	public static final String MESSAGE_EVENT = "event";
	public static final String MESSAGE_SUBSCRIBE = "subscribe";
	public static final String MESSAGE_UNSUBSCRIBE = "unsubscribe";
	public static final String MESSAGE_CLICK = "CLICK";
	public static final String MESSAGE_VIEW = "VIEW";
	public static final String MESSAGE_SCANCODE = "scancode_push";

	/**
	 * 对公众号粉丝发出的不同信息、事件类型进行处理，并给出相应响应
	 * 
	 * @param token
	 *            公众号开发者填写的token
	 * @param request
	 *            微信服务器发出的请求，即公众号粉丝发出的信息，xml格式
	 * @throws Exception
	 */
	public static String handleMessage(String token, HttpServletRequest request, WeChatService weChatService)
			throws Exception {
		/*PublicAccount publicAccount = weChatService.getSinglePublicAccountByToken(token);
		// 公众号的appid
		String publicAccountid = publicAccount.getAppid();
		if (publicAccountid.equals("")) {
			logger.error("TOKEN【" + token + "】调用***handleMessage()方法***出错：publicAccountid为空");
			return "error";
		}*/
		
		// 获取微信服务器传来的xml消息并转为map
		Map<String, String> map = xmlToMap(request);
		String toUserName = map.get("ToUserName");// 开发者微信号
		String fromUserName = map.get("FromUserName");// 发送方帐号（一个OpenID）
		String msgType = map.get("MsgType");
		String content = map.get("Content");

		String message = null;// 响应信息

		// 判断事件类型并做出相应响应
	switch (msgType) {
		case MESSAGE_TEXT:
			// message=handleTextMessageKeyword(fromUserName, toUserName,
			// content, publicAccountid, weChatCMSService,publicAccount);
//			message = "你发送的文本信息："+content;
//			message = weChatService.getTextMsgAutoReplyOfSubscribe(publicAccountid).getReplyContent();
			
			message = initResponsedTextMessage(fromUserName, toUserName, content);

			break;
		case MESSAGE_IMAGE:
			message = "你发送的图片信息";
			message = initResponsedTextMessage(fromUserName, toUserName, message);

			break;
		case MESSAGE_EVENT:
			String eventType = map.get("Event");

			if (MESSAGE_SUBSCRIBE.equals(eventType)) {
//				message = weChatService.getTextMsgAutoReplyOfSubscribe(publicAccountid).getReplyContent();
			} else if (MESSAGE_UNSUBSCRIBE.equals(eventType)) {
				System.out.println(fromUserName + "取消关注微信测试号啦");
			} else if (MESSAGE_CLICK.equals(eventType)) {
				String eventKey = map.get("EventKey");

				if (eventKey.equals("34")) {
					message = "触发click事件，对应键值：" + eventKey;
				}
			}

			message = initResponsedTextMessage(fromUserName, toUserName, message);

			break;
		default:
			message = "暂不对该信息类型进行处理";
			message = initResponsedTextMessage(fromUserName, toUserName, message);

			break;
		}

		return message;
	}

	/**
	 * 处理公众号粉丝发送的文本信息，即关键字回复
	 * 
	 * @param fromUserName
	 * @param toUserName
	 * @param content
	 * @param publicAccountid
	 * @param weChatCMSService
	 * @return
	 * @throws Exception
	 */
	// public static String handleTextMessageKeyword(String fromUserName,String
	// toUserName,String content,String publicAccountid,WeChatCMSService
	// weChatCMSService,PublicAccount publicAccount) throws Exception {
	// String message=null;//响应信息
	//
	// BaseMsg baseMsg=new BaseMsg();
	// baseMsg.setKeyword(content);
	// baseMsg.setPublicAccountid(publicAccountid);
	// String messageType =
	// weChatCMSService.getSingleReplyBaseMsgByKeywordAndPublicAccountid(baseMsg);
	//
	// if (messageType != null) {
	// switch (messageType) {
	// case MESSAGE_TEXT:
	// TextMsg textMsg = new TextMsg();
	// textMsg.setKeyword(content);
	// textMsg.setPublicAccountid(publicAccountid);
	// //通过关键字和公众号id查询要回复的文本信息
	// String
	// replyContent=weChatCMSService.getSingleReplyTextMsgByKeywordAndPublicAccountid(textMsg).getReplyContent();
	// message=initResponsedTextMessage(fromUserName, toUserName, replyContent);
	//
	// break;
	//
	// case MESSAGE_NEWS:
	// NewsMsg newsMsg = new NewsMsg();
	// newsMsg.setKeyword(content);
	// newsMsg.setPublicAccountid(publicAccountid);
	// //通过关键字和公众号id查询要回复的图文信息
	// List<NewsMsg>newsMsgs =
	// weChatCMSService.getSingleReplyNewsMsgByKeywordAndPublicAccountid(newsMsg);
	//
	// List<News> newsList=new ArrayList<News>();
	// News news;
	// for (NewsMsg newsMsgObj : newsMsgs) {
	// news=new News();
	// news.setTitle(newsMsgObj.getTitle());
	// news.setDescription(newsMsgObj.getDigest());
	// news.setPicUrl(newsMsgObj.getThumbMediaId());
	// news.setUrl(newsMsgObj.getContentSourceUrl());
	// newsList.add(news);
	// }
	//
	// message=initResponsedNewsMessage(newsList, fromUserName, toUserName);
	//
	// break;
	//
	// default:
	// message="暂时不对该信息进行处理";
	// message=initResponsedTextMessage(fromUserName, toUserName, message);
	//
	// break;
	// }
	// }else {
	// if (content.equals("模板消息")) {
	// System.out.println(getWeChatMsgTemplate(weChatCMSService, publicAccount,
	// fromUserName));
	// message="关键字："+content;
	// message=initResponsedTextMessage(fromUserName, toUserName, message);
	// }else {
	// message="没有关键字："+content;//若没有匹配的关键字，默认回复
	// message=initResponsedTextMessage(fromUserName, toUserName, message);
	// }
	//
	// }
	//
	// return message;
	// }

	/**
	 * 将xml转为map集合
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws DocumentException
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, String> xmlToMap(HttpServletRequest request) throws IOException, DocumentException {
		Map<String, String> map = new HashMap<String, String>();
		SAXReader reader = new SAXReader();

		InputStream inputStream = request.getInputStream();
		Document document = reader.read(inputStream);

		// 得到xml的根元素(person)
		Element root = document.getRootElement();

		List<Element> list = root.elements();
		// 遍历所有子节点
		for (Element e : list) {
			// 子节点名称和值
			map.put(e.getName(), e.getText());
		}

		inputStream.close();

		return map;

	}

	/**
	 * TextMessage类型转为xml
	 * 
	 * @param textMessage
	 * @return
	 */
	public static String textMessageToXml(TextMessage textMessage) {
		XStream xStream = new XStream();
		xStream.alias("xml", textMessage.getClass());

		return xStream.toXML(textMessage);
	}

	/**
	 * 图文消息类型转为xml
	 * 
	 * @param textMessage
	 * @return
	 */
	public static String newsMessageToXml(NewsMessage newsMessage) {
		XStream xStream = new XStream();
		xStream.alias("xml", newsMessage.getClass());
		xStream.alias("item", new News().getClass());

		return xStream.toXML(newsMessage);
	}

	/**
	 * 图片消息转为xml
	 * 
	 * @param imageMessage
	 * @return
	 */
	public static String imageMessageToXml(ImageMessage imageMessage) {
		XStream xStream = new XStream();
		xStream.alias("xml", imageMessage.getClass());
		return xStream.toXML(imageMessage);
	}

	/**
	 * 音乐消息转为xml
	 * 
	 * @param musicMessage
	 * @return
	 */
	public static String musicMessageToXml(MusicMessage musicMessage) {
		XStream xStream = new XStream();
		xStream.alias("xml", musicMessage.getClass());
		return xStream.toXML(musicMessage);
	}

	/**
	 * 对要回复的文本消息进行组装，xml格式
	 * 
	 * @param fromUserName
	 * @param toUserName
	 * @param content
	 * @return
	 */
	public static String initResponsedTextMessage(String fromUserName, String toUserName, String content) {
		TextMessage textMessage = new TextMessage();
		textMessage.setToUserName(fromUserName);
		textMessage.setFromUserName(toUserName);
		textMessage.setCreateTime(new Date().getTime());
		textMessage.setMsgType(MESSAGE_TEXT);
		textMessage.setContent(content);
		return textMessageToXml(textMessage);
	}

	/**
	 * 对要回复的图片消息进行组装，xml格式
	 * 
	 * @param toUserName
	 * @param fromUserName
	 * @return
	 */
	public static String initResponsedImageMessage(String toUserName, String fromUserName) {
		String message = null;
		Image image = new Image();
		image.setMediaId("NBAdOYjq_alzAarsmEYXCCtgmg7QDFbjLH4g0QYPYDT8OWoPiHq2B08CLv268O1s");
		ImageMessage imageMessage = new ImageMessage();
		imageMessage.setFromUserName(toUserName);
		imageMessage.setToUserName(fromUserName);
		imageMessage.setMsgType(MESSAGE_IMAGE);
		imageMessage.setCreateTime(new Date().getTime());
		imageMessage.setImage(image);
		message = imageMessageToXml(imageMessage);
		return message;
	}

	/**
	 * 对要回复的图文消息进行组装，xml格式
	 * 
	 * @param fromUserName
	 * @param toUserName
	 * @return
	 */
	public static String initResponsedNewsMessage(List<News> newsList, String fromUserName, String toUserName) {
		String message = null;
		NewsMessage newsMessage = new NewsMessage();

		newsMessage.setToUserName(fromUserName);
		newsMessage.setFromUserName(toUserName);
		newsMessage.setCreateTime(new Date().getTime());
		newsMessage.setMsgType(MESSAGE_NEWS);
		newsMessage.setArticleCount(newsList.size());
		newsMessage.setArticles(newsList);

		message = newsMessageToXml(newsMessage);
		return message;
	}

	/**
	 * 组装模板消息
	 * 
	 * @param weChatCMSService
	 * @param publicAccount
	 * @param fromUserName
	 * @return
	 * @throws Exception
	 */
	// public static JSONObject getWeChatMsgTemplate(WeChatCMSService
	// weChatCMSService,PublicAccount publicAccount,String fromUserName) throws
	// Exception{
	// try {
	// String
	// SEND_WECHAT_MSG_TEMPLATE="https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
	// WeChatMsgTemplate weChatMsgTemplate=new WeChatMsgTemplate();
	// weChatMsgTemplate.setTouser(fromUserName);
	// weChatMsgTemplate.setTemplate_id("q3bSybrNwVPjTRlG13vg4Faz9QcE84Di06l0IDG7cf4");
	// weChatMsgTemplate.setTopcolor("#FF0000");
	// weChatMsgTemplate.setUrl("http://yzz.tunnel.qydev.com/");
	//
	// Map<String,WeChatMsgTemplateData> map = new
	// HashMap<String,WeChatMsgTemplateData>();
	// WeChatMsgTemplateData first=new WeChatMsgTemplateData();
	// first.setValue("0000账号交易提醒");
	// first.setColor("#000000");
	// map.put("first", first);
	//
	// WeChatMsgTemplateData keyword1=new WeChatMsgTemplateData();
	// keyword1.setValue("美金");
	// keyword1.setColor("#FF0000");
	// map.put("keyword1", keyword1);
	//
	// WeChatMsgTemplateData keyword2=new WeChatMsgTemplateData();
	// keyword2.setValue("2016-7-17 12:52:52");
	// keyword2.setColor("#000000");
	// map.put("keyword2", keyword2);
	//
	// WeChatMsgTemplateData keyword3=new WeChatMsgTemplateData();
	// keyword3.setValue("支出");
	// keyword3.setColor("#000000");
	// map.put("keyword3", keyword3);
	//
	// WeChatMsgTemplateData keyword4=new WeChatMsgTemplateData();
	// keyword4.setValue("100亿");
	// keyword4.setColor("#FF0000");
	// map.put("keyword4", keyword4);
	//
	// WeChatMsgTemplateData remark=new WeChatMsgTemplateData();
	// remark.setValue("摘要、说明");
	// remark.setColor("#000000");
	// map.put("remark", remark);
	//
	// weChatMsgTemplate.setData(map);
	//
	// String accessToken;
	// if (WeChatApiUtil.isAccessTokenValid(publicAccount)) {
	// accessToken=publicAccount.getAccessToken();
	// }else {
	// accessToken=WeChatApiUtil.getAccessToken(publicAccount);
	// publicAccount.setAccessToken(accessToken);
	// publicAccount.setAccessTokenCreateTime(CalendarUtil.getTimeInSeconds()+"");
	//
	// weChatCMSService.updateSinglePublicAccountById(publicAccount);
	// }
	// SEND_WECHAT_MSG_TEMPLATE=SEND_WECHAT_MSG_TEMPLATE.replace("ACCESS_TOKEN",
	// accessToken);
	// JSONObject jsonObject=(JSONObject) JSONObject.toJSON(weChatMsgTemplate);
	//
	// JSONObject result=HttpUtil.doPostStr(SEND_WECHAT_MSG_TEMPLATE,
	// jsonObject.toJSONString());
	//
	// logger.info("TOKEN【"+publicAccount.getToken()+"】调用***getWeChatMsgTemplate()方法成功");
	//
	// return result;
	// } catch (Exception e) {
	// logger.info("TOKEN【"+publicAccount.getToken()+"】调用***getWeChatMsgTemplate()方法***出错："+e.getMessage());
	//
	// return null;
	// }
	//
	// }

}

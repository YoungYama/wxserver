package com.yzz.util;

public class WeChatErrorMsg {
	public static void main(String[] args) {
		System.out.println(WeChatErrorMsg.errorMsg(-1));
	}

	public static String errorMsg(int errorCode) {
		String errorMsg = null;
		switch (errorCode) {
		case -1:
			errorMsg = "系统繁忙，此时请开发者稍候再试";
			break;
		case 0:
			errorMsg = "请求成功";
			break;
		case 40001:
			errorMsg = "获取access_token时AppSecret错误，或者access_token无效。请开发者认真比对AppSecret的正确性，或查看是否正在为恰当的公众号调用接口";
			break;
		case 40002:
			errorMsg = "不合法的凭证类型";
			break;
		case 40003:
			errorMsg = "不合法的OpenID，请开发者确认OpenID（该用户）是否已关注公众号，或是否是其他公众号的OpenID";
			break;
		case 40004:
			errorMsg = "不合法的媒体文件类型";
			break;
		case 40005:
			errorMsg = "不合法的文件类型";
			break;
		case 40006:
			errorMsg = "不合法的文件大小";
			break;
		case 40007:
			errorMsg = "不合法的媒体文件id";
			break;
		case 40008:
			errorMsg = "不合法的消息类型";
			break;
		case 40009:
			errorMsg = "不合法的图片文件大小";
			break;
		case 40010:
			errorMsg = "不合法的语音文件大小";
			break;
		case 40011:
			errorMsg = "不合法的视频文件大小";
			break;
		case 40012:
			errorMsg = "不合法的缩略图文件大小";
			break;
		case 40013:
			errorMsg = "不合法的AppID，请开发者检查AppID的正确性，避免异常字符，注意大小写";
			break;
		case 40014:
			errorMsg = "不合法的access_token，请开发者认真比对access_token的有效性（如是否过期），或查看是否正在为恰当的公众号调用接口";
			break;
		case 40015:
			errorMsg = "不合法的菜单类型";
			break;
		case 40016:
			errorMsg = "不合法的按钮个数";
			break;
		case 40017:
			errorMsg = "不合法的按钮个数";
			break;
		case 40018:
			errorMsg = "不合法的按钮名字长度";
			break;
		case 40019:
			errorMsg = "不合法的按钮KEY长度";
			break;
		case 40020:
			errorMsg = "不合法的按钮URL长度";
			break;
		case 40021:
			errorMsg = "不合法的菜单版本号";
			break;
		case 40022:
			errorMsg = "不合法的子菜单级数";
			break;
		case 40023:
			errorMsg = "不合法的子菜单按钮个数";
			break;
		case 40024:
			errorMsg = "不合法的子菜单按钮类型";
			break;
		case 40025:
			errorMsg = "不合法的子菜单按钮名字长度";
			break;
		case 40026:
			errorMsg = "不合法的子菜单按钮KEY长度";
			break;
		case 40027:
			errorMsg = "不合法的子菜单按钮URL长度";
			break;
		case 40028:
			errorMsg = "不合法的自定义菜单使用用户";
			break;
		case 40029:
			errorMsg = "不合法的oauth_code";
			break;
		case 40030:
			errorMsg = "不合法的refresh_token";
			break;
		case 40031:
			errorMsg = "不合法的openid列表";
			break;
		case 40032:
			errorMsg = "不合法的openid列表长度";
			break;
		case 40033:
			errorMsg = "不合法的请求字符，不能包含\\uxxxx格式的字符";
			break;
		case 40035:
			errorMsg = "不合法的参数";
			break;
		case 40038:
			errorMsg = "不合法的请求格式";
			break;
		case 40039:
			errorMsg = "不合法的URL长度";
			break;
		case 40050:
			errorMsg = "不合法的分组id";
			break;
		case 40051:
			errorMsg = "分组名字不合法";
			break;
		case 40117:
			errorMsg = "分组名字不合法";
			break;
		case 40118:
			errorMsg = "media_id大小不合法";
			break;
		case 40119:
			errorMsg = "button类型错误";
			break;
		case 40120:
			errorMsg = "button类型错误";
			break;
		case 40121:
			errorMsg = "不合法的media_id类型";
			break;
		case 40132:
			errorMsg = "微信号不合法";
			break;
		case 40137:
			errorMsg = "不支持的图片格式";
			break;
		case 41001:
			errorMsg = "缺少access_token参数";
			break;
		case 41002:
			errorMsg = "缺少appid参数";
			break;
		case 41003:
			errorMsg = "缺少refresh_token参数";
			break;
		case 41004:
			errorMsg = "缺少secret参数";
			break;
		case 41005:
			errorMsg = "缺少多媒体文件数据";
			break;
		case 41006:
			errorMsg = "缺少media_id参数";
			break;
		case 41007:
			errorMsg = "缺少子菜单数据";
			break;
		case 41008:
			errorMsg = "缺少oauth code";
			break;
		case 41009:
			errorMsg = "缺少openid";
			break;
		case 42001:
			errorMsg = "access_token超时，请检查access_token的有效期，请参考基础支持-获取access_token中，对access_token的详细机制说明";
			break;
		case 42002:
			errorMsg = "refresh_token超时";
			break;
		case 42003:
			errorMsg = "oauth_code超时";
			break;
		case 42007:
			errorMsg = "用户修改微信密码，accesstoken和refreshtoken失效，需要重新授权";
			break;
		case 43001:
			errorMsg = "需要GET请求";
			break;
		case 43002:
			errorMsg = "需要POST请求";
			break;
		case 43003:
			errorMsg = "需要HTTPS请求";
			break;
		case 43004:
			errorMsg = "需要接收者关注";
			break;
		case 43005:
			errorMsg = "需要好友关系";
			break;
		case 44001:
			errorMsg = "多媒体文件为空";
			break;
		case 44002:
			errorMsg = "POST的数据包为空";
			break;
		case 44003:
			errorMsg = "图文消息内容为空";
			break;
		case 44004:
			errorMsg = "文本消息内容为空";
			break;
		case 45001:
			errorMsg = "多媒体文件大小超过限制";
			break;
		case 45002:
			errorMsg = "消息内容超过限制";
			break;
		case 45003:
			errorMsg = "标题字段超过限制";
			break;
		case 45004:
			errorMsg = "描述字段超过限制";
			break;
		case 45005:
			errorMsg = "链接字段超过限制";
			break;
		case 45006:
			errorMsg = "图片链接字段超过限制";
			break;
		case 45007:
			errorMsg = "语音播放时间超过限制";
			break;
		case 45008:
			errorMsg = "图文消息超过限制";
			break;
		case 45009:
			errorMsg = "接口调用超过限制";
			break;
		case 45010:
			errorMsg = "创建菜单个数超过限制";
			break;
		case 45015:
			errorMsg = "回复时间超过限制";
			break;
		case 45016:
			errorMsg = "系统分组，不允许修改";
			break;
		case 45017:
			errorMsg = "分组名字过长";
			break;
		case 45018:
			errorMsg = "分组数量超过上限";
			break;
		case 45047:
			errorMsg = "客服接口下行条数超过上限";
			break;
		case 46001:
			errorMsg = "不存在媒体数据";
			break;
		case 46002:
			errorMsg = "不存在的菜单版本";
			break;
		case 46003:
			errorMsg = "不存在的菜单数据";
			break;
		case 46004:
			errorMsg = "不存在的用户";
			break;
		case 47001:
			errorMsg = "解析JSON/XML内容错误";
			break;
		case 48001:
			errorMsg = "api功能未授权，请确认公众号已获得该接口，可以在公众平台官网-开发者中心页中查看接口权限";
			break;
		case 48004:
			errorMsg = "api接口被封禁，请登录mp.weixin.qq.com查看详情";
			break;
		case 50001:
			errorMsg = "用户未授权该api";
			break;
		case 50002:
			errorMsg = "用户受限，可能是违规后接口被封禁";
			break;
		case 61451:
			errorMsg = "参数错误(invalid parameter)";
			break;
		case 61452:
			errorMsg = "无效客服账号(invalid kf_account)";
			break;
		case 61453:
			errorMsg = "客服帐号已存在(kf_account exsited)";
			break;
		case 61454:
			errorMsg = "客服帐号名长度超过限制(仅允许10个英文字符，不包括@及@后的公众号的微信号)(invalid kf_acount length)";
			break;
		case 61455:
			errorMsg = "客服帐号名包含非法字符(仅允许英文+数字)(illegal character in kf_account)";
			break;
		case 61456:
			errorMsg = "客服帐号个数超过限制(10个客服账号)(kf_account count exceeded)";
			break;
		case 61457:
			errorMsg = "无效头像文件类型(invalid file type)";
			break;
		case 61450:
			errorMsg = "系统错误(system error)";
			break;
		case 61500:
			errorMsg = "日期格式错误";
			break;
		case 65301:
			errorMsg = "不存在此menuid对应的个性化菜单";
			break;
		case 65302:
			errorMsg = "没有相应的用户";
			break;
		case 65303:
			errorMsg = "没有默认菜单，不能创建个性化菜单";
			break;
		case 65304:
			errorMsg = "MatchRule信息为空";
			break;
		case 65305:
			errorMsg = "个性化菜单数量受限";
			break;
		case 65306:
			errorMsg = "不支持个性化菜单的帐号";
			break;
		case 65307:
			errorMsg = "个性化菜单信息为空";
			break;
		case 65308:
			errorMsg = "包含没有响应类型的button";
			break;
		case 65309:
			errorMsg = "个性化菜单开关处于关闭状态";
			break;
		case 65310:
			errorMsg = "填写了省份或城市信息，国家信息不能为空";
			break;
		case 65311:
			errorMsg = "填写了城市信息，省份信息不能为空";
			break;
		case 65312:
			errorMsg = "不合法的国家信息";
			break;
		case 65313:
			errorMsg = "不合法的省份信息";
			break;
		case 65314:
			errorMsg = "不合法的城市信息";
			break;
		case 65316:
			errorMsg = "该公众号的菜单设置了过多的域名外跳（最多跳转到3个域名的链接）";
			break;
		case 65317:
			errorMsg = "不合法的URL";
			break;
		case 9001001:
			errorMsg = "POST数据参数不合法";
			break;
		case 9001002:
			errorMsg = "远端服务不可用";
			break;
		case 9001003:
			errorMsg = "Ticket不合法";
			break;
		case 9001004:
			errorMsg = "获取摇周边用户信息失败";
			break;
		case 9001005:
			errorMsg = "获取商户信息失败";
			break;
		case 9001006:
			errorMsg = "获取OpenID失败";
			break;
		case 9001007:
			errorMsg = "上传文件缺失";
			break;
		case 9001008:
			errorMsg = "上传素材的文件类型不合法";
			break;
		case 9001009:
			errorMsg = "上传素材的文件尺寸不合法";
			break;
		case 9001010:
			errorMsg = "上传失败";
			break;
		case 9001020:
			errorMsg = "帐号不合法";
			break;
		case 9001021:
			errorMsg = "已有设备激活率低于50%，不能新增设备";
			break;
		case 9001022:
			errorMsg = "设备申请数不合法，必须为大于0的数字";
			break;
		case 9001023:
			errorMsg = "已存在审核中的设备ID申请";
			break;
		case 9001024:
			errorMsg = "一次查询设备ID数量不能超过50";
			break;
		case 9001025:
			errorMsg = "设备ID不合法";
			break;
		case 9001026:
			errorMsg = "页面ID不合法";
			break;
		case 9001027:
			errorMsg = "页面参数不合法";
			break;
		case 9001028:
			errorMsg = "一次删除页面ID数量不能超过10";
			break;
		case 9001029:
			errorMsg = "页面已应用在设备中，请先解除应用关系再删除";
			break;
		case 9001030:
			errorMsg = "一次查询页面ID数量不能超过50";
			break;
		case 9001031:
			errorMsg = "时间区间不合法";
			break;
		case 9001032:
			errorMsg = "保存设备与页面的绑定关系参数错误";
			break;
		case 9001033:
			errorMsg = "门店ID不合法";
			break;
		case 9001034:
			errorMsg = "设备备注信息过长";
			break;
		case 9001035:
			errorMsg = "设备申请参数不合法";
			break;
		case 9001036:
			errorMsg = "查询起始值begin不合法";
			break;
		}
		return errorMsg;
	}
}
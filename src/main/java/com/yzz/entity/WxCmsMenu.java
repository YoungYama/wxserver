package com.yzz.entity; 

/** 
* 
* @description: wx_cms_menu表的实体类WxCmsMenu 
* 
* @author 杨志钊 
* @date 2017-04-21 10:07:02 
*/ 

public class WxCmsMenu {

	private String wxCmsMenuId;//菜单ID

	private String wxCmsPublicAccountId;//所属公众号ID

	private String mediaId;//media_id类型和view_limited类型必须，调用新增永久素材接口返回的合法media_id

	private String type;//菜单的响应动作类型【click：点击推事件，view：跳转URL，scancode_push：扫码推事件，scancode_waitmsg：扫码推事件且弹出“消息接收中”提示框，pic_sysphoto：弹出系统拍照发图，pic_photo_or_album：弹出拍照或者相册发图，pic_weixin：弹出微信相册发图器，location_select：弹出地理位置选择器，media_id：下发消息（除文本消息），view_limited：跳转图文消息URL】

	private String name;//菜单标题，不超过16个字节，子菜单不超过40个字节

	private String key;//click等点击类型必须，菜单KEY值，用于消息接口推送，不超过128字节

	private String url;//view类型必须，网页链接，用户点击菜单可打开链接，不超过1024字节

	private Integer sort;//菜单排序

	private String parentId;//菜单级别，一级菜单值为0，二级菜单值为其父级菜单的ID

	private Integer wxCmsMenuGroupId;//组别

	public String getWxCmsMenuId() { 
		return wxCmsMenuId; 
	} 

	public void setWxCmsMenuId(String wxCmsMenuId) { 
 		this.wxCmsMenuId = wxCmsMenuId == null ? null : wxCmsMenuId.trim(); 
	} 

	public String getWxCmsPublicAccountId() { 
		return wxCmsPublicAccountId; 
	} 

	public void setWxCmsPublicAccountId(String wxCmsPublicAccountId) { 
 		this.wxCmsPublicAccountId = wxCmsPublicAccountId == null ? null : wxCmsPublicAccountId.trim(); 
	} 

	public String getMediaId() { 
		return mediaId; 
	} 

	public void setMediaId(String mediaId) { 
 		this.mediaId = mediaId == null ? null : mediaId.trim(); 
	} 

	public String getType() { 
		return type; 
	} 

	public void setType(String type) { 
 		this.type = type == null ? null : type.trim(); 
	} 

	public String getName() { 
		return name; 
	} 

	public void setName(String name) { 
 		this.name = name == null ? null : name.trim(); 
	} 

	public String getKey() { 
		return key; 
	} 

	public void setKey(String key) { 
 		this.key = key == null ? null : key.trim(); 
	} 

	public String getUrl() { 
		return url; 
	} 

	public void setUrl(String url) { 
 		this.url = url == null ? null : url.trim(); 
	} 

	public Integer getSort() { 
		return sort; 
	} 

	public void setSort(Integer sort) { 
 		this.sort = sort; 
	} 

	public String getParentId() { 
		return parentId; 
	} 

	public void setParentId(String parentId) { 
 		this.parentId = parentId == null ? null : parentId.trim(); 
	} 

	public Integer getWxCmsMenuGroupId() { 
		return wxCmsMenuGroupId; 
	} 

	public void setWxCmsMenuGroupId(Integer wxCmsMenuGroupId) { 
 		this.wxCmsMenuGroupId = wxCmsMenuGroupId; 
	} 

 
 } 

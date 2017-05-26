package com.yzz.entity; 

/** 
* 
* @description: wx_cms_menu_group表的实体类WxCmsMenuGroup 
* 
* @author 杨志钊 
* @date 2017-05-03 15:54:51 
*/ 

public class WxCmsMenuGroup {

	private Integer wxCmsMenuGroupId;//菜单组ID

	private String butName;//菜单组名称

	private String wxCmsPublicAccountId;//所属公众号ID

	private Integer isEnable;//是否启用，1：启用，0：禁用

	public Integer getWxCmsMenuGroupId() { 
		return wxCmsMenuGroupId; 
	} 

	public void setWxCmsMenuGroupId(Integer wxCmsMenuGroupId) { 
 		this.wxCmsMenuGroupId = wxCmsMenuGroupId; 
	} 

	public String getButName() { 
		return butName; 
	} 

	public void setButName(String butName) { 
 		this.butName = butName == null ? null : butName.trim(); 
	} 

	public String getWxCmsPublicAccountId() { 
		return wxCmsPublicAccountId; 
	} 

	public void setWxCmsPublicAccountId(String wxCmsPublicAccountId) { 
 		this.wxCmsPublicAccountId = wxCmsPublicAccountId == null ? null : wxCmsPublicAccountId.trim(); 
	} 

	public Integer getIsEnable() { 
		return isEnable; 
	} 

	public void setIsEnable(Integer isEnable) { 
 		this.isEnable = isEnable; 
	} 

 
 } 

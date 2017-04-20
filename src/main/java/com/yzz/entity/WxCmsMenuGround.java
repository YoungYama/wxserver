package com.yzz.entity; 

/** 
* 
* @description: wx_cms_menu_ground表的实体类WxCmsMenuGround 
* 
* @author 杨志钊 
* @date 2017-04-17 18:20:30 
*/ 

public class WxCmsMenuGround {

	private Integer wxCmsMenuGroundId;//菜单组ID

	private String name;//菜单组名称

	private String wxCmsPublicAccountId;//所属公众号ID

	private Integer isEnable;//是否启用，1：启用，0：禁用

	public Integer getWxCmsMenuGroundId() { 
		return wxCmsMenuGroundId; 
	} 

	public void setWxCmsMenuGroundId(Integer wxCmsMenuGroundId) { 
 		this.wxCmsMenuGroundId = wxCmsMenuGroundId; 
	} 

	public String getName() { 
		return name; 
	} 

	public void setName(String name) { 
 		this.name = name == null ? null : name.trim(); 
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

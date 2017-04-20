package com.yzz.entity; 

/** 
* 
* @description: sys_model表的实体类SysModel 
* 
* @author 杨志钊 
* @date 2017-04-17 18:20:30 
*/ 

public class SysModel {

	private Integer sysModelId;//系统模块ID

	private String name;//系统模块名称

	public Integer getSysModelId() { 
		return sysModelId; 
	} 

	public void setSysModelId(Integer sysModelId) { 
 		this.sysModelId = sysModelId; 
	} 

	public String getName() { 
		return name; 
	} 

	public void setName(String name) { 
 		this.name = name == null ? null : name.trim(); 
	} 

 
 } 

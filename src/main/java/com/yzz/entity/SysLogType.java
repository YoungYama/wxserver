package com.yzz.entity; 

/** 
* 
* @description: sys_log_type表的实体类SysLogType 
* 
* @author 杨志钊 
* @date 2017-04-17 18:20:30 
*/ 

public class SysLogType {

	private Integer sysLogTypeId;//日志类型ID

	private String name;//日志类型名称

	public Integer getSysLogTypeId() { 
		return sysLogTypeId; 
	} 

	public void setSysLogTypeId(Integer sysLogTypeId) { 
 		this.sysLogTypeId = sysLogTypeId; 
	} 

	public String getName() { 
		return name; 
	} 

	public void setName(String name) { 
 		this.name = name == null ? null : name.trim(); 
	} 

 
 } 

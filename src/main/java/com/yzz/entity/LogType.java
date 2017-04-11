package com.yzz.entity; 

import javax.persistence.Entity; 
import javax.persistence.Id; 
import javax.persistence.Table; 

/** 
* 
* @description: log_type表LogType实体类 
* 
* @author 杨志钊 
* @date 2017-04-07 18:43:38 
*/

@Entity 
@Table(name = "log_type") 
public class LogType { 

	@Id 
 	private Integer logTypeId;//日志类型ID

	private String name;//日志类型名

	public Integer getLogTypeId() { 
		return logTypeId; 
	} 

	public void setLogTypeId(Integer logTypeId) { 
 		this.logTypeId = logTypeId; 
	} 
	public String getName() { 
		return name; 
	} 

	public void setName(String name) { 
 		this.name = name == null ? null : name.trim(); 
	} 

 
 } 

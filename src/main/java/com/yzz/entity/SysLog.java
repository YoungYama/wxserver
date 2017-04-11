package com.yzz.entity; 

import javax.persistence.Entity; 
import javax.persistence.Id; 
import javax.persistence.Table; 

/** 
* 
* @description: sys_log表SysLog实体类 
* 
* @author 杨志钊 
* @date 2017-04-07 18:43:38 
*/

@Entity 
@Table(name = "sys_log") 
public class SysLog { 

	@Id 
 	private String sysLogId;//日志ID

	private Integer logTypeId;//日志类型ID

	private String sysUserId;//c操作记录对应的用户ID

	private String wxPublicAccountId;//所属公账号ID

	private String modelTypeName;//操作所属模块

	private String operationContent;//用户具体操作内容

	private String operationClassName;//调用类名

	private String operationMethodName;//调用方法名

	private String operationTime;//操作时间

	public String getSysLogId() { 
		return sysLogId; 
	} 

	public void setSysLogId(String sysLogId) { 
 		this.sysLogId = sysLogId == null ? null : sysLogId.trim(); 
	} 

	public Integer getLogTypeId() { 
		return logTypeId; 
	} 

	public void setLogTypeId(Integer logTypeId) { 
 		this.logTypeId = logTypeId; 
	} 
	public String getSysUserId() { 
		return sysUserId; 
	} 

	public void setSysUserId(String sysUserId) { 
 		this.sysUserId = sysUserId == null ? null : sysUserId.trim(); 
	} 

	public String getWxPublicAccountId() { 
		return wxPublicAccountId; 
	} 

	public void setWxPublicAccountId(String wxPublicAccountId) { 
 		this.wxPublicAccountId = wxPublicAccountId == null ? null : wxPublicAccountId.trim(); 
	} 

	public String getModelTypeName() { 
		return modelTypeName; 
	} 

	public void setModelTypeName(String modelTypeName) { 
 		this.modelTypeName = modelTypeName == null ? null : modelTypeName.trim(); 
	} 

	public String getOperationContent() { 
		return operationContent; 
	} 

	public void setOperationContent(String operationContent) { 
 		this.operationContent = operationContent == null ? null : operationContent.trim(); 
	} 

	public String getOperationClassName() { 
		return operationClassName; 
	} 

	public void setOperationClassName(String operationClassName) { 
 		this.operationClassName = operationClassName == null ? null : operationClassName.trim(); 
	} 

	public String getOperationMethodName() { 
		return operationMethodName; 
	} 

	public void setOperationMethodName(String operationMethodName) { 
 		this.operationMethodName = operationMethodName == null ? null : operationMethodName.trim(); 
	} 

	public String getOperationTime() { 
		return operationTime; 
	} 

	public void setOperationTime(String operationTime) { 
 		this.operationTime = operationTime == null ? null : operationTime.trim(); 
	} 

 
 } 

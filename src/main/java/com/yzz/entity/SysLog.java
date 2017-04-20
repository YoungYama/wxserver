package com.yzz.entity; 

/** 
* 
* @description: sys_log表的实体类SysLog 
* 
* @author 杨志钊 
* @date 2017-04-17 18:20:30 
*/ 

public class SysLog {

	private String sysLogId;//日志ID

	private Integer sysLogTypeId;//日志类型ID

	private String sysUserId;//c操作记录对应的用户ID

	private String wxCmsPublicAccountId;//所属公众号ID

	private Integer sysModelId;//操作所属系统模块ID

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

	public Integer getSysLogTypeId() { 
		return sysLogTypeId; 
	} 

	public void setSysLogTypeId(Integer sysLogTypeId) { 
 		this.sysLogTypeId = sysLogTypeId; 
	} 

	public String getSysUserId() { 
		return sysUserId; 
	} 

	public void setSysUserId(String sysUserId) { 
 		this.sysUserId = sysUserId == null ? null : sysUserId.trim(); 
	} 

	public String getWxCmsPublicAccountId() { 
		return wxCmsPublicAccountId; 
	} 

	public void setWxCmsPublicAccountId(String wxCmsPublicAccountId) { 
 		this.wxCmsPublicAccountId = wxCmsPublicAccountId == null ? null : wxCmsPublicAccountId.trim(); 
	} 

	public Integer getSysModelId() { 
		return sysModelId; 
	} 

	public void setSysModelId(Integer sysModelId) { 
 		this.sysModelId = sysModelId; 
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

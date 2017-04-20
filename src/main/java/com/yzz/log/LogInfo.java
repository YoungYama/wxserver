package com.yzz.log;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解类 LogInfo.java(获取Controller的日志描述)
 * 
 * @author 杨志钊
 * @date 2017-4-7 下午12:02:51
 * 
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogInfo {

	/** 要执行的操作的模块类型名称比如：1（系统用户管理）**/
	public String modelType();

	/** 要执行的操作的日志类型ID比如：5（电脑网站登录） **/
	public String logType();
	
	/** 要执行的具体操作比如：XX添加了用户XX **/
	public String operationContent();

}
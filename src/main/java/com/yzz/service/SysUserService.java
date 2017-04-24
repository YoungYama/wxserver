package com.yzz.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yzz.dto.Page;
import com.yzz.dto.ResultData;
import com.yzz.entity.SysUser;

/**
 * 
 * @description: 实体类SysUser的service接口
 * 
 * @author 杨志钊
 * @date 2017-04-17 16:54:06
 */
public interface SysUserService {

	/** 注册 */
	ResultData<Void> register(SysUser entity);

	/** 登录 */
	ResultData<SysUser> login(SysUser entity, HttpServletRequest request, HttpServletResponse response,
			HttpSession session);

	/** 单个实体全部字段添加 */
	ResultData<Void> insertOne(SysUser entity);

	/** 根据实体ID单个实体删除 */
	ResultData<Void> deleteOne(String sysUserId);

	/** 根据实体ID数组批量删除实体 */
	ResultData<Void> deleteBatch(String[] sysUserIds);

	/** 单个实体全部字段更新 */
	ResultData<Void> updateOne(SysUser entity);

	/** 单个实体选择性字段更新 */
	ResultData<Void> updateOneSelective(SysUser entity);

	/** 根据实体ID查询单个实体 */
	ResultData<SysUser> selectOne(String sysUserId);

	/** 根据选择性实体字段分页查询实体数组 */
	ResultData<List<SysUser>> selectList(SysUser entity, Page page);

	/** 查询全部实体 */
	ResultData<List<SysUser>> selectAll();

}

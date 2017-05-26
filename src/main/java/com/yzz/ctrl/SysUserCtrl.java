package com.yzz.ctrl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yzz.dto.Page;
import com.yzz.dto.ResultData;
import com.yzz.entity.SysUser;
import com.yzz.log.LogInfo;
import com.yzz.service.SysUserService;
import com.yzz.util.ConstantUtil;
import com.yzz.util.UserOperatedState;

/**
 * 
 * @description: 实体类SysUser的控制器SysUserCtrl
 * 
 * @author 杨志钊
 * @date 2017-04-17 16:54:06
 */
@Controller
@RequestMapping("/sysUser")
public class SysUserCtrl {

	@Resource
	SysUserService sysUserService;

	/** 系统用户注册 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> register(SysUser entity) {
		ResultData<Void> resultData = sysUserService.register(entity);

		return resultData;
	}

	/** 系统用户登录 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	@ResponseBody
	@LogInfo(modelType = "1", logType = "5", operationContent = "用户在电脑端网站上登录了")
	public ResultData<SysUser> login(SysUser entity, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		ResultData<SysUser> resultData = sysUserService.login(entity, request, response, session);

		return resultData;
	}

	/** 系统用户注销 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	@ResponseBody
	public ResultData<Void> logout(HttpSession session) {
		ResultData<Void> resultData = new ResultData<>();
		try {
			if (session != null) {
				session.removeAttribute(ConstantUtil.LOGINING_SYS_USER);
				session.invalidate();
			}
			resultData.setMsg(UserOperatedState.LOGOUT_SUCCESS);
		} catch (Exception e) {
			resultData.setCode(400);
			resultData.setMsg(UserOperatedState.INNER_ERROR);
		}

		return resultData;
	}

	/** 单个实体全部字段添加 */
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> insertOne(SysUser entity) {
		ResultData<Void> resultData = sysUserService.insertOne(entity);

		return resultData;
	}

	/** 根据实体ID单个实体删除 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> deleteOne(String sysUserId) {
		ResultData<Void> resultData = sysUserService.deleteOne(sysUserId);

		return resultData;
	}

	/** 根据实体ID数组批量删除实体 */
	@RequestMapping(value = "/deleteBatch", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> deleteBatch(String[] sysUserIds) {
		ResultData<Void> resultData = sysUserService.deleteBatch(sysUserIds);

		return resultData;
	}

	/** 单个实体全部字段更新 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> updateOne(SysUser entity) {
		ResultData<Void> resultData = sysUserService.updateOne(entity);

		return resultData;
	}

	/** 单个实体选择性字段更新 */
	@RequestMapping(value = "/updateSelective", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> updateOneSelective(SysUser entity) {
		ResultData<Void> resultData = sysUserService.updateOneSelective(entity);

		return resultData;
	}

	/** 根据实体ID查询单个实体 */
	@RequestMapping(value = "/select", method = RequestMethod.GET)
	@ResponseBody
	public ResultData<SysUser> selectOne(String sysUserId) {
		ResultData<SysUser> resultData = sysUserService.selectOne(sysUserId);

		return resultData;
	}

	/** 根据选择性实体字段分页查询实体数组 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public ResultData<List<SysUser>> selectList(SysUser entity, Page page) {
		ResultData<List<SysUser>> resultData = sysUserService.selectList(entity, page);

		return resultData;
	}

	/** 查询全部实体 */
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@ResponseBody
	public ResultData<List<SysUser>> selectAll() {
		ResultData<List<SysUser>> resultData = sysUserService.selectAll();

		return resultData;
	}

}

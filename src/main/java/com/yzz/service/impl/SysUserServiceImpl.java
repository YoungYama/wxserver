package com.yzz.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.yzz.dao.SysUserDao;
import com.yzz.dto.Page;
import com.yzz.dto.ResultData;
import com.yzz.entity.SysUser;
import com.yzz.service.SysUserService;
import com.yzz.util.UserOperatedState;
import com.yzz.util.ConstantUtil;
import com.yzz.util.IdGenerator;

/**
 * 
 * @description: SysUserService接口的实现类SysUserServiceImpl
 * 
 * @author 杨志钊
 * @date 2017-04-25 09:27:40
 */
@Service
public class SysUserServiceImpl implements SysUserService {
	
	@Resource
	SysUserDao sysUserDao;

	/** 注册 */
	@Override
	public ResultData<Void> register(SysUser entity) {
		ResultData<Void> resultData = new ResultData<>();
		try {
			entity.setSysUserId(IdGenerator.generatesId());
			int rows = sysUserDao.insert(entity);
			if (rows < 0) {
				resultData.setCode(400);
				resultData.setMsg(UserOperatedState.REGISTER_FAILURE);
			} else {
				resultData.setMsg(UserOperatedState.REGISTER_SUCCESS);
			}
		} catch (RuntimeException e) {
			resultData.setCode(400);
			resultData.setMsg(UserOperatedState.INNER_ERROR);
		}
		return resultData;
	}

	/** 登录 */
	@Override
	public ResultData<SysUser> login(SysUser entity, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		ResultData<SysUser> resultData = new ResultData<>();
		String password = entity.getPassword();
		entity.setPassword(null);
		List<SysUser> sysUsers = sysUserDao.selectByEntityAndPage(entity, null);

		if (sysUsers.size() > 0) {
			SysUser sysUser = sysUsers.get(0);
			if (password.equals(sysUser.getPassword())) {
				resultData.setData(sysUser);
				resultData.setMsg(UserOperatedState.LOGIN_SUCCESS);
				session.setAttribute(ConstantUtil.LOGINING_SYS_USER, sysUser);
			} else {
				Cookie[] cookies = request.getCookies();
				String sysUserName = sysUser.getSysUserName();
				boolean isExist = false;
				for (Cookie cookie : cookies) {
					if (sysUserName.equals(cookie.getName())) {
						isExist = true;
						String errorCount = String.valueOf(Integer.parseInt(cookie.getValue()) + 1);
						Cookie coo = new Cookie(sysUserName, errorCount);
						coo.setPath("/");
						coo.setMaxAge(60 * 60);// 一个小时
						response.addCookie(coo);
						break;
					}
				}
				if (!isExist) {
					Cookie coo = new Cookie(sysUserName, String.valueOf(1));
					coo.setPath("/");
					coo.setMaxAge(60 * 60);// 一个小时
					response.addCookie(coo);
				}
				resultData.setCode(400);
				resultData.setMsg(UserOperatedState.LOGIN_PASSWORD_ERROR);
			}
		} else {
			resultData.setCode(400);
			resultData.setMsg(UserOperatedState.LOGIN_USER_NAME_ERROR);
		}
		return resultData;
	}

	/** 单个实体全部字段添加 */
	@Override
	public ResultData<Void> insertOne(SysUser entity) {
		ResultData<Void> resultData = new ResultData<>();

		entity.setSysUserId(IdGenerator.generatesId());
		int rows = sysUserDao.insert(entity);
		if (rows < 0) {
			resultData.setCode(400);
			resultData.setMsg(UserOperatedState.INSERT_FAILURE);
		} else {
			resultData.setMsg(UserOperatedState.INSERT_SUCCESS);
		}

		return resultData;
	}

	/** 根据实体ID单个实体删除 */
	@Override
	public ResultData<Void> deleteOne(String sysUserId) {
		ResultData<Void> resultData = new ResultData<>();

		int rows = sysUserDao.deleteByPrimaryKey(sysUserId);
		if (rows < 0) {
			resultData.setCode(400);
			resultData.setMsg(UserOperatedState.DELETE_FAILURE);
		} else {
			resultData.setMsg(UserOperatedState.DELETE_SUCCESS);
		}

		return resultData;
	}

	/** 根据实体ID数组批量删除实体 */
	@Override
	public ResultData<Void> deleteBatch(String[] sysUserIds) {
		ResultData<Void> resultData = new ResultData<>();

		int rows = sysUserDao.deleteBatch(Arrays.asList(sysUserIds));
		if (rows < 0) {
			resultData.setCode(400);
			resultData.setMsg(UserOperatedState.DELETE_FAILURE);
		} else {
			resultData.setMsg(UserOperatedState.DELETE_SUCCESS);
		}

		return resultData;
	}

	/** 单个实体全部字段更新 */
	@Override
	public ResultData<Void> updateOne(SysUser entity) {
		ResultData<Void> resultData = new ResultData<>();

		int rows = sysUserDao.updateByPrimaryKey(entity);
		if (rows < 0) {
			resultData.setCode(400);
			resultData.setMsg(UserOperatedState.UPDATE_FAILURE);
		} else {
			resultData.setMsg(UserOperatedState.UPDATE_SUCCESS);
		}

		return resultData;
	}

	/** 单个实体选择性字段更新 */
	@Override
	public ResultData<Void> updateOneSelective(SysUser entity) {
		ResultData<Void> resultData = new ResultData<>();

		int rows = sysUserDao.updateByPrimaryKeySelective(entity);
		if (rows < 0) {
			resultData.setCode(400);
			resultData.setMsg(UserOperatedState.UPDATE_FAILURE);
		} else {
			resultData.setMsg(UserOperatedState.UPDATE_SUCCESS);
		}

		return resultData;
	}

	/** 根据实体ID查询单个实体 */
	@Override
	public ResultData<SysUser> selectOne(String sysUserId) {
		ResultData<SysUser> resultData = new ResultData<>();

		SysUser sysUser = sysUserDao.selectByPrimaryKey(sysUserId);
		if (sysUser == null) {
			resultData.setMsg(UserOperatedState.NO_DATA);
		} else {
			resultData.setMsg(UserOperatedState.SELECT_SUCCESS);
			resultData.setData(sysUser);
		}

		return resultData;
	}

	/** 根据选择性实体字段分页查询实体数组 */
	@Override
	public ResultData<List<SysUser>> selectList(SysUser entity, Page page) {
		ResultData<List<SysUser>> resultData = new ResultData<>();

		List<SysUser> sysUsers = new ArrayList<>();
		int count = sysUserDao.countByEntity(entity);
		if (count > 0) {// 总记录大于则有数据，可以进一步分页查询
			page.setTotalRecord(count);
			sysUsers = sysUserDao.selectByEntityAndPage(entity, page);

			if (sysUsers.size() > 0) {
				resultData.setMsg(UserOperatedState.SELECT_SUCCESS);
			} else {
				resultData.setMsg(UserOperatedState.NO_DATA);
			}

			resultData.setData(sysUsers, page);
		} else {
			resultData.setMsg(UserOperatedState.NO_DATA);
		}

		return resultData;
	}

	/** 查询全部实体 */
	@Override
	public ResultData<List<SysUser>> selectAll() {
		ResultData<List<SysUser>> resultData = new ResultData<>();

		List<SysUser> sysUsers = sysUserDao.selectByEntityAndPage(null, null);

		if (sysUsers.size() > 0) {
			resultData.setMsg(UserOperatedState.SELECT_SUCCESS);
			resultData.setData(sysUsers);
		} else {
			resultData.setMsg(UserOperatedState.NO_DATA);
		}

		return resultData;
	}

}

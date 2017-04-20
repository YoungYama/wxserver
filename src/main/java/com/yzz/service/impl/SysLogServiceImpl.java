package com.yzz.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yzz.dao.SysLogDao;
import com.yzz.dto.Page;
import com.yzz.dto.ResultData;
import com.yzz.entity.SysLog;
import com.yzz.service.SysLogService;
import com.yzz.util.UserOperatedState;
import com.yzz.util.IdGenerator;

/** 
* 
* @description: SysLogService接口的实现类SysLogServiceImpl 
* 
* @author 杨志钊 
* @date 2017-04-17 17:37:14 
*/ 
@Service
public class SysLogServiceImpl implements SysLogService {

	@Resource
	SysLogDao sysLogDao;

	/**单个实体全部字段添加*/
	@Override
	public ResultData<Void> insertOne(SysLog entity) {
		ResultData<Void> resultData = new ResultData<>();
		try {
			entity.setSysLogId(IdGenerator.generatesId());
			int rows = sysLogDao.insert(entity);
			if (rows < 0) {
				resultData.setCode(400);
				resultData.setMsg(UserOperatedState.INSERT_FAILURE);
			} else {
				resultData.setMsg(UserOperatedState.INSERT_SUCCESS);
			}
		} catch (RuntimeException e) {
			resultData.setCode(400);
			resultData.setMsg(UserOperatedState.INNER_ERROR);
		}
		return resultData;
	}

	/**根据实体ID单个实体删除*/
	@Override
	public ResultData<Void> deleteOne(String sysLogId) {
		ResultData<Void> resultData = new ResultData<>();
		try {
			int rows = sysLogDao.deleteByPrimaryKey(sysLogId);
			if (rows < 0) {
				resultData.setCode(400);
				resultData.setMsg(UserOperatedState.DELETE_FAILURE);
			} else {
				resultData.setMsg(UserOperatedState.DELETE_SUCCESS);
			}
		} catch (RuntimeException e) {
			resultData.setCode(400);
			resultData.setMsg(UserOperatedState.INNER_ERROR);
		}
		return resultData;
	}

	/**根据实体ID数组批量删除实体*/
	@Override
	public ResultData<Void> deleteBatch(String[] sysLogIds) {
		ResultData<Void> resultData = new ResultData<>();
		try {
			int rows = sysLogDao.deleteBatch(Arrays.asList(sysLogIds));
			if (rows < 0) {
				resultData.setCode(400);
				resultData.setMsg(UserOperatedState.DELETE_FAILURE);
			} else {
				resultData.setMsg(UserOperatedState.DELETE_SUCCESS);
			}
		} catch (RuntimeException e) {
			resultData.setCode(400);
			resultData.setMsg(UserOperatedState.INNER_ERROR);
		}
		return resultData;
	}

	/**单个实体全部字段更新*/
	@Override
	public ResultData<Void> updateOne(SysLog entity) {
		ResultData<Void> resultData = new ResultData<>();
		try {
			int rows = sysLogDao.updateByPrimaryKey(entity);
			if (rows < 0) {
				resultData.setCode(400);
				resultData.setMsg(UserOperatedState.UPDATE_FAILURE);
			} else {
				resultData.setMsg(UserOperatedState.UPDATE_SUCCESS);
			}
		} catch (RuntimeException e) {
			resultData.setCode(400);
			resultData.setMsg(UserOperatedState.INNER_ERROR);
		}
		return resultData;
	}

	/**单个实体选择性字段更新*/
	@Override
	public ResultData<Void> updateOneSelective(SysLog entity) {
		ResultData<Void> resultData = new ResultData<>();
		try {
			int rows = sysLogDao.updateByPrimaryKeySelective(entity);
			if (rows < 0) {
				resultData.setCode(400);
				resultData.setMsg(UserOperatedState.UPDATE_FAILURE);
			} else {
				resultData.setMsg(UserOperatedState.UPDATE_SUCCESS);
			}
		} catch (RuntimeException e) {
			resultData.setCode(400);
			resultData.setMsg(UserOperatedState.INNER_ERROR);
		}
		return resultData;
	}

	/**根据实体ID查询单个实体*/
	@Override
	public ResultData<SysLog> selectOne(String sysLogId) {
		ResultData<SysLog> resultData = new ResultData<>();
		try {
			SysLog sysLog = sysLogDao.selectByPrimaryKey(sysLogId);
			if (sysLog == null) {
				resultData.setMsg(UserOperatedState.NO_DATA);
			} else {
				resultData.setMsg(UserOperatedState.SELECT_SUCCESS);
				resultData.setData(sysLog);
			}
		} catch (RuntimeException e) {
			resultData.setCode(400);
			resultData.setMsg(UserOperatedState.INNER_ERROR);
		}

		return resultData;
	}

	/**根据选择性实体字段分页查询实体数组*/
	@Override
	public ResultData<List<SysLog>> selectList(SysLog entity, Page page) {
		ResultData<List<SysLog>> resultData = new ResultData<>();
		try {
			List<SysLog> sysLogs = new ArrayList<>();
			int count = sysLogDao.countByEntity(entity);
			if (count > 0) {// 总记录大于则有数据，可以进一步分页查询
				page.setTotalRecord(count);
				sysLogs = sysLogDao.selectByEntityAndPage(entity, page);

				if (sysLogs.size() > 0) {
					resultData.setMsg(UserOperatedState.SELECT_SUCCESS);
				} else {
					resultData.setMsg(UserOperatedState.NO_DATA);
				}
				
				resultData.setData(sysLogs, page);
			} else {
				resultData.setMsg(UserOperatedState.NO_DATA);
			}

		} catch (RuntimeException e) {
			resultData.setCode(400);
			resultData.setMsg(UserOperatedState.INNER_ERROR);
		}

		return resultData;
	}

	/**查询全部实体*/
	@Override
	public ResultData<List<SysLog>> selectAll() {
		ResultData<List<SysLog>> resultData = new ResultData<>();
		try {
			List<SysLog> sysLogs = sysLogDao.selectByEntityAndPage(null, null);

			if (sysLogs.size() > 0) {
				resultData.setMsg(UserOperatedState.SELECT_SUCCESS);
				resultData.setData(sysLogs);
			} else {
				resultData.setMsg(UserOperatedState.NO_DATA);
			}

		} catch (RuntimeException e) {
			resultData.setCode(400);
			resultData.setMsg(UserOperatedState.INNER_ERROR);
		}

		return resultData;
	}

}

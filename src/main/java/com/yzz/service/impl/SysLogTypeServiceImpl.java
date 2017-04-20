package com.yzz.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yzz.dao.SysLogTypeDao;
import com.yzz.dto.Page;
import com.yzz.dto.ResultData;
import com.yzz.entity.SysLogType;
import com.yzz.service.SysLogTypeService;
import com.yzz.util.UserOperatedState;

/** 
* 
* @description: SysLogTypeService接口的实现类SysLogTypeServiceImpl 
* 
* @author 杨志钊 
* @date 2017-04-17 17:37:14 
*/ 
@Service
public class SysLogTypeServiceImpl implements SysLogTypeService {

	@Resource
	SysLogTypeDao sysLogTypeDao;

	/**单个实体全部字段添加*/
	@Override
	public ResultData<Void> insertOne(SysLogType entity) {
		ResultData<Void> resultData = new ResultData<>();
		try {
			int rows = sysLogTypeDao.insert(entity);
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
	public ResultData<Void> deleteOne(Integer sysLogTypeId) {
		ResultData<Void> resultData = new ResultData<>();
		try {
			int rows = sysLogTypeDao.deleteByPrimaryKey(sysLogTypeId);
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
	public ResultData<Void> deleteBatch(Integer[] sysLogTypeIds) {
		ResultData<Void> resultData = new ResultData<>();
		try {
			int rows = sysLogTypeDao.deleteBatch(Arrays.asList(sysLogTypeIds));
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
	public ResultData<Void> updateOne(SysLogType entity) {
		ResultData<Void> resultData = new ResultData<>();
		try {
			int rows = sysLogTypeDao.updateByPrimaryKey(entity);
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
	public ResultData<Void> updateOneSelective(SysLogType entity) {
		ResultData<Void> resultData = new ResultData<>();
		try {
			int rows = sysLogTypeDao.updateByPrimaryKeySelective(entity);
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
	public ResultData<SysLogType> selectOne(Integer sysLogTypeId) {
		ResultData<SysLogType> resultData = new ResultData<>();
		try {
			SysLogType sysLogType = sysLogTypeDao.selectByPrimaryKey(sysLogTypeId);
			if (sysLogType == null) {
				resultData.setMsg(UserOperatedState.NO_DATA);
			} else {
				resultData.setMsg(UserOperatedState.SELECT_SUCCESS);
				resultData.setData(sysLogType);
			}
		} catch (RuntimeException e) {
			resultData.setCode(400);
			resultData.setMsg(UserOperatedState.INNER_ERROR);
		}

		return resultData;
	}

	/**根据选择性实体字段分页查询实体数组*/
	@Override
	public ResultData<List<SysLogType>> selectList(SysLogType entity, Page page) {
		ResultData<List<SysLogType>> resultData = new ResultData<>();
		try {
			List<SysLogType> sysLogTypes = new ArrayList<>();
			int count = sysLogTypeDao.countByEntity(entity);
			if (count > 0) {// 总记录大于则有数据，可以进一步分页查询
				page.setTotalRecord(count);
				sysLogTypes = sysLogTypeDao.selectByEntityAndPage(entity, page);

				if (sysLogTypes.size() > 0) {
					resultData.setMsg(UserOperatedState.SELECT_SUCCESS);
				} else {
					resultData.setMsg(UserOperatedState.NO_DATA);
				}
				
				resultData.setData(sysLogTypes, page);
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
	public ResultData<List<SysLogType>> selectAll() {
		ResultData<List<SysLogType>> resultData = new ResultData<>();
		try {
			List<SysLogType> sysLogTypes = sysLogTypeDao.selectByEntityAndPage(null, null);

			if (sysLogTypes.size() > 0) {
				resultData.setMsg(UserOperatedState.SELECT_SUCCESS);
				resultData.setData(sysLogTypes);
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

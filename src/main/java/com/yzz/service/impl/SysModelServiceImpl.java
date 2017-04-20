package com.yzz.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yzz.dao.SysModelDao;
import com.yzz.dto.Page;
import com.yzz.dto.ResultData;
import com.yzz.entity.SysModel;
import com.yzz.service.SysModelService;
import com.yzz.util.UserOperatedState;

/** 
* 
* @description: SysModelService接口的实现类SysModelServiceImpl 
* 
* @author 杨志钊 
* @date 2017-04-17 18:17:44 
*/ 
@Service
public class SysModelServiceImpl implements SysModelService {

	@Resource
	SysModelDao sysModelDao;

	/**单个实体全部字段添加*/
	@Override
	public ResultData<Void> insertOne(SysModel entity) {
		ResultData<Void> resultData = new ResultData<>();
		try {
			int rows = sysModelDao.insert(entity);
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
	public ResultData<Void> deleteOne(Integer sysModelId) {
		ResultData<Void> resultData = new ResultData<>();
		try {
			int rows = sysModelDao.deleteByPrimaryKey(sysModelId);
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
	public ResultData<Void> deleteBatch(Integer[] sysModelIds) {
		ResultData<Void> resultData = new ResultData<>();
		try {
			int rows = sysModelDao.deleteBatch(Arrays.asList(sysModelIds));
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
	public ResultData<Void> updateOne(SysModel entity) {
		ResultData<Void> resultData = new ResultData<>();
		try {
			int rows = sysModelDao.updateByPrimaryKey(entity);
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
	public ResultData<Void> updateOneSelective(SysModel entity) {
		ResultData<Void> resultData = new ResultData<>();
		try {
			int rows = sysModelDao.updateByPrimaryKeySelective(entity);
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
	public ResultData<SysModel> selectOne(Integer sysModelId) {
		ResultData<SysModel> resultData = new ResultData<>();
		try {
			SysModel sysModel = sysModelDao.selectByPrimaryKey(sysModelId);
			if (sysModel == null) {
				resultData.setMsg(UserOperatedState.NO_DATA);
			} else {
				resultData.setMsg(UserOperatedState.SELECT_SUCCESS);
				resultData.setData(sysModel);
			}
		} catch (RuntimeException e) {
			resultData.setCode(400);
			resultData.setMsg(UserOperatedState.INNER_ERROR);
		}

		return resultData;
	}

	/**根据选择性实体字段分页查询实体数组*/
	@Override
	public ResultData<List<SysModel>> selectList(SysModel entity, Page page) {
		ResultData<List<SysModel>> resultData = new ResultData<>();
		try {
			List<SysModel> sysModels = new ArrayList<>();
			int count = sysModelDao.countByEntity(entity);
			if (count > 0) {// 总记录大于则有数据，可以进一步分页查询
				page.setTotalRecord(count);
				sysModels = sysModelDao.selectByEntityAndPage(entity, page);

				if (sysModels.size() > 0) {
					resultData.setMsg(UserOperatedState.SELECT_SUCCESS);
				} else {
					resultData.setMsg(UserOperatedState.NO_DATA);
				}
				
				resultData.setData(sysModels, page);
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
	public ResultData<List<SysModel>> selectAll() {
		ResultData<List<SysModel>> resultData = new ResultData<>();
		try {
			List<SysModel> sysModels = sysModelDao.selectByEntityAndPage(null, null);

			if (sysModels.size() > 0) {
				resultData.setMsg(UserOperatedState.SELECT_SUCCESS);
				resultData.setData(sysModels);
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

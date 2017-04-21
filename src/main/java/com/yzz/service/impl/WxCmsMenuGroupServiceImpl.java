package com.yzz.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yzz.dao.WxCmsMenuGroupDao;
import com.yzz.dto.Page;
import com.yzz.dto.ResultData;
import com.yzz.entity.WxCmsMenuGroup;
import com.yzz.service.WxCmsMenuGroupService;
import com.yzz.util.UserOperatedState;

/** 
* 
* @description: WxCmsMenuGroupService接口的实现类WxCmsMenuGroupServiceImpl 
* 
* @author 杨志钊 
* @date 2017-04-21 10:07:02 
*/ 
@Service
public class WxCmsMenuGroupServiceImpl implements WxCmsMenuGroupService {

	@Resource
	WxCmsMenuGroupDao wxCmsMenuGroupDao;

	/**单个实体全部字段添加*/
	@Override
	public ResultData<Void> insertOne(WxCmsMenuGroup entity) {
		ResultData<Void> resultData = new ResultData<>();
		try {
			int rows = wxCmsMenuGroupDao.insert(entity);
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
	public ResultData<Void> deleteOne(Integer wxCmsMenuGroupId) {
		ResultData<Void> resultData = new ResultData<>();
		try {
			int rows = wxCmsMenuGroupDao.deleteByPrimaryKey(wxCmsMenuGroupId);
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
	public ResultData<Void> deleteBatch(Integer[] wxCmsMenuGroupIds) {
		ResultData<Void> resultData = new ResultData<>();
		try {
			int rows = wxCmsMenuGroupDao.deleteBatch(Arrays.asList(wxCmsMenuGroupIds));
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
	public ResultData<Void> updateOne(WxCmsMenuGroup entity) {
		ResultData<Void> resultData = new ResultData<>();
		try {
			int rows = wxCmsMenuGroupDao.updateByPrimaryKey(entity);
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
	public ResultData<Void> updateOneSelective(WxCmsMenuGroup entity) {
		ResultData<Void> resultData = new ResultData<>();
		try {
			int rows = wxCmsMenuGroupDao.updateByPrimaryKeySelective(entity);
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
	public ResultData<WxCmsMenuGroup> selectOne(Integer wxCmsMenuGroupId) {
		ResultData<WxCmsMenuGroup> resultData = new ResultData<>();
		try {
			WxCmsMenuGroup wxCmsMenuGroup = wxCmsMenuGroupDao.selectByPrimaryKey(wxCmsMenuGroupId);
			if (wxCmsMenuGroup == null) {
				resultData.setMsg(UserOperatedState.NO_DATA);
			} else {
				resultData.setMsg(UserOperatedState.SELECT_SUCCESS);
				resultData.setData(wxCmsMenuGroup);
			}
		} catch (RuntimeException e) {
			resultData.setCode(400);
			resultData.setMsg(UserOperatedState.INNER_ERROR);
		}

		return resultData;
	}

	/**根据选择性实体字段分页查询实体数组*/
	@Override
	public ResultData<List<WxCmsMenuGroup>> selectList(WxCmsMenuGroup entity, Page page) {
		ResultData<List<WxCmsMenuGroup>> resultData = new ResultData<>();
		try {
			List<WxCmsMenuGroup> wxCmsMenuGroups = new ArrayList<>();
			int count = wxCmsMenuGroupDao.countByEntity(entity);
			if (count > 0) {// 总记录大于则有数据，可以进一步分页查询
				page.setTotalRecord(count);
				wxCmsMenuGroups = wxCmsMenuGroupDao.selectByEntityAndPage(entity, page);

				if (wxCmsMenuGroups.size() > 0) {
					resultData.setMsg(UserOperatedState.SELECT_SUCCESS);
				} else {
					resultData.setMsg(UserOperatedState.NO_DATA);
				}
				
				resultData.setData(wxCmsMenuGroups, page);
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
	public ResultData<List<WxCmsMenuGroup>> selectAll() {
		ResultData<List<WxCmsMenuGroup>> resultData = new ResultData<>();
		try {
			List<WxCmsMenuGroup> wxCmsMenuGroups = wxCmsMenuGroupDao.selectByEntityAndPage(null, null);

			if (wxCmsMenuGroups.size() > 0) {
				resultData.setMsg(UserOperatedState.SELECT_SUCCESS);
				resultData.setData(wxCmsMenuGroups);
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

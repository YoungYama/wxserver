package com.yzz.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yzz.dao.WxCmsMenuGroundDao;
import com.yzz.dto.Page;
import com.yzz.dto.ResultData;
import com.yzz.entity.WxCmsMenuGround;
import com.yzz.service.WxCmsMenuGroundService;
import com.yzz.util.UserOperatedState;

/** 
* 
* @description: WxCmsMenuGroundService接口的实现类WxCmsMenuGroundServiceImpl 
* 
* @author 杨志钊 
* @date 2017-04-17 17:37:14 
*/ 
@Service
public class WxCmsMenuGroundServiceImpl implements WxCmsMenuGroundService {

	@Resource
	WxCmsMenuGroundDao wxCmsMenuGroundDao;

	/**单个实体全部字段添加*/
	@Override
	public ResultData<Void> insertOne(WxCmsMenuGround entity) {
		ResultData<Void> resultData = new ResultData<>();
		try {
			int rows = wxCmsMenuGroundDao.insert(entity);
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
	public ResultData<Void> deleteOne(Integer wxCmsMenuGroundId) {
		ResultData<Void> resultData = new ResultData<>();
		try {
			int rows = wxCmsMenuGroundDao.deleteByPrimaryKey(wxCmsMenuGroundId);
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
	public ResultData<Void> deleteBatch(Integer[] wxCmsMenuGroundIds) {
		ResultData<Void> resultData = new ResultData<>();
		try {
			int rows = wxCmsMenuGroundDao.deleteBatch(Arrays.asList(wxCmsMenuGroundIds));
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
	public ResultData<Void> updateOne(WxCmsMenuGround entity) {
		ResultData<Void> resultData = new ResultData<>();
		try {
			int rows = wxCmsMenuGroundDao.updateByPrimaryKey(entity);
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
	public ResultData<Void> updateOneSelective(WxCmsMenuGround entity) {
		ResultData<Void> resultData = new ResultData<>();
		try {
			int rows = wxCmsMenuGroundDao.updateByPrimaryKeySelective(entity);
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
	public ResultData<WxCmsMenuGround> selectOne(Integer wxCmsMenuGroundId) {
		ResultData<WxCmsMenuGround> resultData = new ResultData<>();
		try {
			WxCmsMenuGround wxCmsMenuGround = wxCmsMenuGroundDao.selectByPrimaryKey(wxCmsMenuGroundId);
			if (wxCmsMenuGround == null) {
				resultData.setMsg(UserOperatedState.NO_DATA);
			} else {
				resultData.setMsg(UserOperatedState.SELECT_SUCCESS);
				resultData.setData(wxCmsMenuGround);
			}
		} catch (RuntimeException e) {
			resultData.setCode(400);
			resultData.setMsg(UserOperatedState.INNER_ERROR);
		}

		return resultData;
	}

	/**根据选择性实体字段分页查询实体数组*/
	@Override
	public ResultData<List<WxCmsMenuGround>> selectList(WxCmsMenuGround entity, Page page) {
		ResultData<List<WxCmsMenuGround>> resultData = new ResultData<>();
		try {
			List<WxCmsMenuGround> wxCmsMenuGrounds = new ArrayList<>();
			int count = wxCmsMenuGroundDao.countByEntity(entity);
			if (count > 0) {// 总记录大于则有数据，可以进一步分页查询
				page.setTotalRecord(count);
				wxCmsMenuGrounds = wxCmsMenuGroundDao.selectByEntityAndPage(entity, page);

				if (wxCmsMenuGrounds.size() > 0) {
					resultData.setMsg(UserOperatedState.SELECT_SUCCESS);
				} else {
					resultData.setMsg(UserOperatedState.NO_DATA);
				}
				
				resultData.setData(wxCmsMenuGrounds, page);
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
	public ResultData<List<WxCmsMenuGround>> selectAll() {
		ResultData<List<WxCmsMenuGround>> resultData = new ResultData<>();
		try {
			List<WxCmsMenuGround> wxCmsMenuGrounds = wxCmsMenuGroundDao.selectByEntityAndPage(null, null);

			if (wxCmsMenuGrounds.size() > 0) {
				resultData.setMsg(UserOperatedState.SELECT_SUCCESS);
				resultData.setData(wxCmsMenuGrounds);
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

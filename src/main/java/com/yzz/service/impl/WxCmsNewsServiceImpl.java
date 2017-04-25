package com.yzz.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yzz.dao.WxCmsNewsDao;
import com.yzz.dto.Page;
import com.yzz.dto.ResultData;
import com.yzz.entity.WxCmsNews;
import com.yzz.service.WxCmsNewsService;
import com.yzz.util.UserOperatedState;
import com.yzz.util.IdGenerator;

/** 
* 
* @description: WxCmsNewsService接口的实现类WxCmsNewsServiceImpl 
* 
* @author 杨志钊 
* @date 2017-04-25 09:27:40 
*/ 
@Service
public class WxCmsNewsServiceImpl implements WxCmsNewsService {

	@Resource
	WxCmsNewsDao wxCmsNewsDao;

	/**单个实体全部字段添加*/
	@Override
	public ResultData<Void> insertOne(WxCmsNews entity) {
		ResultData<Void> resultData = new ResultData<>();

		entity.setWxCmsNewsId(IdGenerator.generatesId());
		int rows = wxCmsNewsDao.insert(entity);
		if (rows < 0) {
			resultData.setCode(400);
			resultData.setMsg(UserOperatedState.INSERT_FAILURE);
		} else {
			resultData.setMsg(UserOperatedState.INSERT_SUCCESS);
		}

		return resultData;
	}

	/**根据实体ID单个实体删除*/
	@Override
	public ResultData<Void> deleteOne(String wxCmsNewsId) {
		ResultData<Void> resultData = new ResultData<>();

		int rows = wxCmsNewsDao.deleteByPrimaryKey(wxCmsNewsId);
		if (rows < 0) {
			resultData.setCode(400);
			resultData.setMsg(UserOperatedState.DELETE_FAILURE);
		} else {
			resultData.setMsg(UserOperatedState.DELETE_SUCCESS);
		}

		return resultData;
	}

	/**根据实体ID数组批量删除实体*/
	@Override
	public ResultData<Void> deleteBatch(String[] wxCmsNewsIds) {
		ResultData<Void> resultData = new ResultData<>();

		int rows = wxCmsNewsDao.deleteBatch(Arrays.asList(wxCmsNewsIds));
		if (rows < 0) {
			resultData.setCode(400);
			resultData.setMsg(UserOperatedState.DELETE_FAILURE);
		} else {
			resultData.setMsg(UserOperatedState.DELETE_SUCCESS);
		}

		return resultData;
	}

	/**单个实体全部字段更新*/
	@Override
	public ResultData<Void> updateOne(WxCmsNews entity) {
		ResultData<Void> resultData = new ResultData<>();

		int rows = wxCmsNewsDao.updateByPrimaryKey(entity);
		if (rows < 0) {
			resultData.setCode(400);
			resultData.setMsg(UserOperatedState.UPDATE_FAILURE);
		} else {
			resultData.setMsg(UserOperatedState.UPDATE_SUCCESS);
		}

		return resultData;
	}

	/**单个实体选择性字段更新*/
	@Override
	public ResultData<Void> updateOneSelective(WxCmsNews entity) {
		ResultData<Void> resultData = new ResultData<>();

		int rows = wxCmsNewsDao.updateByPrimaryKeySelective(entity);
		if (rows < 0) {
			resultData.setCode(400);
			resultData.setMsg(UserOperatedState.UPDATE_FAILURE);
		} else {
			resultData.setMsg(UserOperatedState.UPDATE_SUCCESS);
		}

		return resultData;
	}

	/**根据实体ID查询单个实体*/
	@Override
	public ResultData<WxCmsNews> selectOne(String wxCmsNewsId) {
		ResultData<WxCmsNews> resultData = new ResultData<>();

		WxCmsNews wxCmsNews = wxCmsNewsDao.selectByPrimaryKey(wxCmsNewsId);
		if (wxCmsNews == null) {
			resultData.setMsg(UserOperatedState.NO_DATA);
		} else {
			resultData.setMsg(UserOperatedState.SELECT_SUCCESS);
			resultData.setData(wxCmsNews);
		}

		return resultData;
	}

	/**根据选择性实体字段分页查询实体数组*/
	@Override
	public ResultData<List<WxCmsNews>> selectList(WxCmsNews entity, Page page) {
		ResultData<List<WxCmsNews>> resultData = new ResultData<>();

		List<WxCmsNews> wxCmsNewss = new ArrayList<>();
		int count = wxCmsNewsDao.countByEntity(entity);
		if (count > 0) {// 总记录大于则有数据，可以进一步分页查询
			page.setTotalRecord(count);
			wxCmsNewss = wxCmsNewsDao.selectByEntityAndPage(entity, page);

			if (wxCmsNewss.size() > 0) {
				resultData.setMsg(UserOperatedState.SELECT_SUCCESS);
			} else {
				resultData.setMsg(UserOperatedState.NO_DATA);
			}
			
			resultData.setData(wxCmsNewss, page);
		} else {
			resultData.setMsg(UserOperatedState.NO_DATA);
		}

		return resultData;
	}

	/**查询全部实体*/
	@Override
	public ResultData<List<WxCmsNews>> selectAll() {
		ResultData<List<WxCmsNews>> resultData = new ResultData<>();

		List<WxCmsNews> wxCmsNewss = wxCmsNewsDao.selectByEntityAndPage(null, null);

		if (wxCmsNewss.size() > 0) {
			resultData.setMsg(UserOperatedState.SELECT_SUCCESS);
			resultData.setData(wxCmsNewss);
		} else {
			resultData.setMsg(UserOperatedState.NO_DATA);
		}

		return resultData;
	}

}

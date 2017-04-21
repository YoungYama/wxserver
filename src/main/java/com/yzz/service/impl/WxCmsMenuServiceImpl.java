package com.yzz.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yzz.dao.WxCmsMenuDao;
import com.yzz.dto.Page;
import com.yzz.dto.ResultData;
import com.yzz.entity.WxCmsMenu;
import com.yzz.service.WxCmsMenuService;
import com.yzz.util.UserOperatedState;
import com.yzz.util.IdGenerator;

/** 
* 
* @description: WxCmsMenuService接口的实现类WxCmsMenuServiceImpl 
* 
* @author 杨志钊 
* @date 2017-04-21 10:07:02 
*/ 
@Service
public class WxCmsMenuServiceImpl implements WxCmsMenuService {

	@Resource
	WxCmsMenuDao wxCmsMenuDao;

	/**单个实体全部字段添加*/
	@Override
	public ResultData<Void> insertOne(WxCmsMenu entity) {
		ResultData<Void> resultData = new ResultData<>();
		try {
			entity.setWxCmsMenuId(IdGenerator.generatesId());
			int rows = wxCmsMenuDao.insert(entity);
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
	public ResultData<Void> deleteOne(String wxCmsMenuId) {
		ResultData<Void> resultData = new ResultData<>();
		try {
			int rows = wxCmsMenuDao.deleteByPrimaryKey(wxCmsMenuId);
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
	public ResultData<Void> deleteBatch(String[] wxCmsMenuIds) {
		ResultData<Void> resultData = new ResultData<>();
		try {
			int rows = wxCmsMenuDao.deleteBatch(Arrays.asList(wxCmsMenuIds));
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
	public ResultData<Void> updateOne(WxCmsMenu entity) {
		ResultData<Void> resultData = new ResultData<>();
		try {
			int rows = wxCmsMenuDao.updateByPrimaryKey(entity);
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
	public ResultData<Void> updateOneSelective(WxCmsMenu entity) {
		ResultData<Void> resultData = new ResultData<>();
		try {
			int rows = wxCmsMenuDao.updateByPrimaryKeySelective(entity);
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
	public ResultData<WxCmsMenu> selectOne(String wxCmsMenuId) {
		ResultData<WxCmsMenu> resultData = new ResultData<>();
		try {
			WxCmsMenu wxCmsMenu = wxCmsMenuDao.selectByPrimaryKey(wxCmsMenuId);
			if (wxCmsMenu == null) {
				resultData.setMsg(UserOperatedState.NO_DATA);
			} else {
				resultData.setMsg(UserOperatedState.SELECT_SUCCESS);
				resultData.setData(wxCmsMenu);
			}
		} catch (RuntimeException e) {
			resultData.setCode(400);
			resultData.setMsg(UserOperatedState.INNER_ERROR);
		}

		return resultData;
	}

	/**根据选择性实体字段分页查询实体数组*/
	@Override
	public ResultData<List<WxCmsMenu>> selectList(WxCmsMenu entity, Page page) {
		ResultData<List<WxCmsMenu>> resultData = new ResultData<>();
		try {
			List<WxCmsMenu> wxCmsMenus = new ArrayList<>();
			int count = wxCmsMenuDao.countByEntity(entity);
			if (count > 0) {// 总记录大于则有数据，可以进一步分页查询
				page.setTotalRecord(count);
				wxCmsMenus = wxCmsMenuDao.selectByEntityAndPage(entity, page);

				if (wxCmsMenus.size() > 0) {
					resultData.setMsg(UserOperatedState.SELECT_SUCCESS);
				} else {
					resultData.setMsg(UserOperatedState.NO_DATA);
				}
				
				resultData.setData(wxCmsMenus, page);
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
	public ResultData<List<WxCmsMenu>> selectAll() {
		ResultData<List<WxCmsMenu>> resultData = new ResultData<>();
		try {
			List<WxCmsMenu> wxCmsMenus = wxCmsMenuDao.selectByEntityAndPage(null, null);

			if (wxCmsMenus.size() > 0) {
				resultData.setMsg(UserOperatedState.SELECT_SUCCESS);
				resultData.setData(wxCmsMenus);
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

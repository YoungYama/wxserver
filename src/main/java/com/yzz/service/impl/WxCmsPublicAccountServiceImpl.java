package com.yzz.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yzz.dao.WxCmsPublicAccountDao;
import com.yzz.dto.Page;
import com.yzz.dto.ResultData;
import com.yzz.entity.WxCmsPublicAccount;
import com.yzz.service.WxCmsPublicAccountService;
import com.yzz.util.UserOperatedState;
import com.yzz.util.IdGenerator;

/** 
* 
* @description: WxCmsPublicAccountService接口的实现类WxCmsPublicAccountServiceImpl 
* 
* @author 杨志钊 
* @date 2017-04-17 17:37:14 
*/ 
@Service
public class WxCmsPublicAccountServiceImpl implements WxCmsPublicAccountService {

	@Resource
	WxCmsPublicAccountDao wxCmsPublicAccountDao;

	/**单个实体全部字段添加*/
	@Override
	public ResultData<Void> insertOne(WxCmsPublicAccount entity) {
		ResultData<Void> resultData = new ResultData<>();
		try {
			entity.setWxCmsPublicAccountId(IdGenerator.generatesId());
			int rows = wxCmsPublicAccountDao.insert(entity);
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
	public ResultData<Void> deleteOne(String wxCmsPublicAccountId) {
		ResultData<Void> resultData = new ResultData<>();
		try {
			int rows = wxCmsPublicAccountDao.deleteByPrimaryKey(wxCmsPublicAccountId);
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
	public ResultData<Void> deleteBatch(String[] wxCmsPublicAccountIds) {
		ResultData<Void> resultData = new ResultData<>();
		try {
			int rows = wxCmsPublicAccountDao.deleteBatch(Arrays.asList(wxCmsPublicAccountIds));
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
	public ResultData<Void> updateOne(WxCmsPublicAccount entity) {
		ResultData<Void> resultData = new ResultData<>();
		try {
			int rows = wxCmsPublicAccountDao.updateByPrimaryKey(entity);
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
	public ResultData<Void> updateOneSelective(WxCmsPublicAccount entity) {
		ResultData<Void> resultData = new ResultData<>();
		try {
			int rows = wxCmsPublicAccountDao.updateByPrimaryKeySelective(entity);
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
	public ResultData<WxCmsPublicAccount> selectOne(String wxCmsPublicAccountId) {
		ResultData<WxCmsPublicAccount> resultData = new ResultData<>();
		try {
			WxCmsPublicAccount wxCmsPublicAccount = wxCmsPublicAccountDao.selectByPrimaryKey(wxCmsPublicAccountId);
			if (wxCmsPublicAccount == null) {
				resultData.setMsg(UserOperatedState.NO_DATA);
			} else {
				resultData.setMsg(UserOperatedState.SELECT_SUCCESS);
				resultData.setData(wxCmsPublicAccount);
			}
		} catch (RuntimeException e) {
			resultData.setCode(400);
			resultData.setMsg(UserOperatedState.INNER_ERROR);
		}

		return resultData;
	}

	/**根据选择性实体字段分页查询实体数组*/
	@Override
	public ResultData<List<WxCmsPublicAccount>> selectList(WxCmsPublicAccount entity, Page page) {
		ResultData<List<WxCmsPublicAccount>> resultData = new ResultData<>();
		try {
			List<WxCmsPublicAccount> wxCmsPublicAccounts = new ArrayList<>();
			int count = wxCmsPublicAccountDao.countByEntity(entity);
			if (count > 0) {// 总记录大于则有数据，可以进一步分页查询
				page.setTotalRecord(count);
				wxCmsPublicAccounts = wxCmsPublicAccountDao.selectByEntityAndPage(entity, page);

				if (wxCmsPublicAccounts.size() > 0) {
					resultData.setMsg(UserOperatedState.SELECT_SUCCESS);
				} else {
					resultData.setMsg(UserOperatedState.NO_DATA);
				}
				
				resultData.setData(wxCmsPublicAccounts, page);
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
	public ResultData<List<WxCmsPublicAccount>> selectAll() {
		ResultData<List<WxCmsPublicAccount>> resultData = new ResultData<>();
		try {
			List<WxCmsPublicAccount> wxCmsPublicAccounts = wxCmsPublicAccountDao.selectByEntityAndPage(null, null);

			if (wxCmsPublicAccounts.size() > 0) {
				resultData.setMsg(UserOperatedState.SELECT_SUCCESS);
				resultData.setData(wxCmsPublicAccounts);
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

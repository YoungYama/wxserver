package com.yzz.service;

import java.util.List;

import com.yzz.dto.Page;
import com.yzz.dto.ResultData;
import com.yzz.entity.WxCmsNews;

/** 
* 
* @description: 实体类WxCmsNews的service接口 
* 
* @author 杨志钊 
* @date 2017-04-17 16:54:06 
*/ 
public interface WxCmsNewsService {

	/**单个实体全部字段添加*/
	ResultData<Void> insertOne(WxCmsNews entity);

	/**根据实体ID单个实体删除*/
	ResultData<Void> deleteOne(String wxCmsNewsId);

	/**根据实体ID数组批量删除实体*/
	ResultData<Void> deleteBatch(String[] wxCmsNewsIds);

	/**单个实体全部字段更新*/
	ResultData<Void> updateOne(WxCmsNews entity);

	/**单个实体选择性字段更新*/
	ResultData<Void> updateOneSelective(WxCmsNews entity);

	/**根据实体ID查询单个实体*/
	ResultData<WxCmsNews> selectOne(String wxCmsNewsId);

	/**根据选择性实体字段分页查询实体数组*/
	ResultData<List<WxCmsNews>> selectList(WxCmsNews entity, Page page);

	/**查询全部实体*/
	ResultData<List<WxCmsNews>> selectAll();

}

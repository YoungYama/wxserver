package com.yzz.service;

import java.util.List;

import com.yzz.dto.Page;
import com.yzz.dto.ResultData;
import com.yzz.entity.WxCmsMenuGround;

/** 
* 
* @description: 实体类WxCmsMenuGround的service接口 
* 
* @author 杨志钊 
* @date 2017-04-17 16:54:06 
*/ 
public interface WxCmsMenuGroundService {

	/**单个实体全部字段添加*/
	ResultData<Void> insertOne(WxCmsMenuGround entity);

	/**根据实体ID单个实体删除*/
	ResultData<Void> deleteOne(Integer wxCmsMenuGroundId);

	/**根据实体ID数组批量删除实体*/
	ResultData<Void> deleteBatch(Integer[] wxCmsMenuGroundIds);

	/**单个实体全部字段更新*/
	ResultData<Void> updateOne(WxCmsMenuGround entity);

	/**单个实体选择性字段更新*/
	ResultData<Void> updateOneSelective(WxCmsMenuGround entity);

	/**根据实体ID查询单个实体*/
	ResultData<WxCmsMenuGround> selectOne(Integer wxCmsMenuGroundId);

	/**根据选择性实体字段分页查询实体数组*/
	ResultData<List<WxCmsMenuGround>> selectList(WxCmsMenuGround entity, Page page);

	/**查询全部实体*/
	ResultData<List<WxCmsMenuGround>> selectAll();

}

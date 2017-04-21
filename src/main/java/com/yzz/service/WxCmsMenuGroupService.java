package com.yzz.service;

import java.util.List;

import com.yzz.dto.Page;
import com.yzz.dto.ResultData;
import com.yzz.entity.WxCmsMenuGroup;

/** 
* 
* @description: 实体类WxCmsMenuGroup的service接口 
* 
* @author 杨志钊 
* @date 2017-04-21 10:07:02 
*/ 
public interface WxCmsMenuGroupService {

	/**单个实体全部字段添加*/
	ResultData<Void> insertOne(WxCmsMenuGroup entity);

	/**根据实体ID单个实体删除*/
	ResultData<Void> deleteOne(Integer wxCmsMenuGroupId);

	/**根据实体ID数组批量删除实体*/
	ResultData<Void> deleteBatch(Integer[] wxCmsMenuGroupIds);

	/**单个实体全部字段更新*/
	ResultData<Void> updateOne(WxCmsMenuGroup entity);

	/**单个实体选择性字段更新*/
	ResultData<Void> updateOneSelective(WxCmsMenuGroup entity);

	/**根据实体ID查询单个实体*/
	ResultData<WxCmsMenuGroup> selectOne(Integer wxCmsMenuGroupId);

	/**根据选择性实体字段分页查询实体数组*/
	ResultData<List<WxCmsMenuGroup>> selectList(WxCmsMenuGroup entity, Page page);

	/**查询全部实体*/
	ResultData<List<WxCmsMenuGroup>> selectAll();

}

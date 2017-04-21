package com.yzz.service;

import java.util.List;

import com.yzz.dto.Page;
import com.yzz.dto.ResultData;
import com.yzz.entity.WxCmsMenu;

/** 
* 
* @description: 实体类WxCmsMenu的service接口 
* 
* @author 杨志钊 
* @date 2017-04-21 10:07:02 
*/ 
public interface WxCmsMenuService {

	/**单个实体全部字段添加*/
	ResultData<Void> insertOne(WxCmsMenu entity);

	/**根据实体ID单个实体删除*/
	ResultData<Void> deleteOne(String wxCmsMenuId);

	/**根据实体ID数组批量删除实体*/
	ResultData<Void> deleteBatch(String[] wxCmsMenuIds);

	/**单个实体全部字段更新*/
	ResultData<Void> updateOne(WxCmsMenu entity);

	/**单个实体选择性字段更新*/
	ResultData<Void> updateOneSelective(WxCmsMenu entity);

	/**根据实体ID查询单个实体*/
	ResultData<WxCmsMenu> selectOne(String wxCmsMenuId);

	/**根据选择性实体字段分页查询实体数组*/
	ResultData<List<WxCmsMenu>> selectList(WxCmsMenu entity, Page page);

	/**查询全部实体*/
	ResultData<List<WxCmsMenu>> selectAll();

}

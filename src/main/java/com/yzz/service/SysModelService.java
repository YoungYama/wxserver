package com.yzz.service;

import java.util.List;

import com.yzz.dto.Page;
import com.yzz.dto.ResultData;
import com.yzz.entity.SysModel;

/** 
* 
* @description: 实体类SysModel的service接口 
* 
* @author 杨志钊 
* @date 2017-04-17 18:17:44 
*/ 
public interface SysModelService {

	/**单个实体全部字段添加*/
	ResultData<Void> insertOne(SysModel entity);

	/**根据实体ID单个实体删除*/
	ResultData<Void> deleteOne(Integer sysModelId);

	/**根据实体ID数组批量删除实体*/
	ResultData<Void> deleteBatch(Integer[] sysModelIds);

	/**单个实体全部字段更新*/
	ResultData<Void> updateOne(SysModel entity);

	/**单个实体选择性字段更新*/
	ResultData<Void> updateOneSelective(SysModel entity);

	/**根据实体ID查询单个实体*/
	ResultData<SysModel> selectOne(Integer sysModelId);

	/**根据选择性实体字段分页查询实体数组*/
	ResultData<List<SysModel>> selectList(SysModel entity, Page page);

	/**查询全部实体*/
	ResultData<List<SysModel>> selectAll();

}

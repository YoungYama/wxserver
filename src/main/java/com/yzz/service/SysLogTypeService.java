package com.yzz.service;

import java.util.List;

import com.yzz.dto.Page;
import com.yzz.dto.ResultData;
import com.yzz.entity.SysLogType;

/** 
* 
* @description: 实体类SysLogType的service接口 
* 
* @author 杨志钊 
* @date 2017-04-17 16:54:06 
*/ 
public interface SysLogTypeService {

	/**单个实体全部字段添加*/
	ResultData<Void> insertOne(SysLogType entity);

	/**根据实体ID单个实体删除*/
	ResultData<Void> deleteOne(Integer sysLogTypeId);

	/**根据实体ID数组批量删除实体*/
	ResultData<Void> deleteBatch(Integer[] sysLogTypeIds);

	/**单个实体全部字段更新*/
	ResultData<Void> updateOne(SysLogType entity);

	/**单个实体选择性字段更新*/
	ResultData<Void> updateOneSelective(SysLogType entity);

	/**根据实体ID查询单个实体*/
	ResultData<SysLogType> selectOne(Integer sysLogTypeId);

	/**根据选择性实体字段分页查询实体数组*/
	ResultData<List<SysLogType>> selectList(SysLogType entity, Page page);

	/**查询全部实体*/
	ResultData<List<SysLogType>> selectAll();

}

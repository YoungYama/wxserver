package com.yzz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.yzz.dto.Page;
import com.yzz.entity.SysModel;

/** 
* 
* @description: 实体类SysModel的DAO接口 
* 
* @author 杨志钊 
* @date 2017-04-17 18:17:44 
*/ 
@Repository
public interface SysModelDao {

	/**单个实体全部字段添加*/
	int insert(SysModel entity);

	/**根据实体ID单个实体删除*/
	int deleteByPrimaryKey(Integer sysModelId);

	/**根据实体ID数组批量删除实体*/
	int deleteBatch(List<Integer> sysModelIds);

	/**单个实体全部字段更新*/
	int updateByPrimaryKey(SysModel entity);

	/**单个实体选择性字段更新*/
	int updateByPrimaryKeySelective(SysModel entity);

	/**根据实体ID查询单个实体*/
	SysModel selectByPrimaryKey(Integer sysModelId);

	/**根据选择性实体字段分页查询实体数组*/
	List<SysModel> selectByEntityAndPage(@Param("entity") SysModel entity, @Param("page") Page page);

	/**根据选择性实体字段查询实体数量*/
	int countByEntity(@Param("entity") SysModel entity);

}

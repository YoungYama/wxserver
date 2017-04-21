package com.yzz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.yzz.dto.Page;
import com.yzz.entity.WxCmsMenuGroup;

/** 
* 
* @description: 实体类WxCmsMenuGroup的DAO接口 
* 
* @author 杨志钊 
* @date 2017-04-21 10:07:02 
*/ 
@Repository
public interface WxCmsMenuGroupDao {

	/**单个实体全部字段添加*/
	int insert(WxCmsMenuGroup entity);

	/**根据实体ID单个实体删除*/
	int deleteByPrimaryKey(Integer wxCmsMenuGroupId);

	/**根据实体ID数组批量删除实体*/
	int deleteBatch(List<Integer> wxCmsMenuGroupIds);

	/**单个实体全部字段更新*/
	int updateByPrimaryKey(WxCmsMenuGroup entity);

	/**单个实体选择性字段更新*/
	int updateByPrimaryKeySelective(WxCmsMenuGroup entity);

	/**根据实体ID查询单个实体*/
	WxCmsMenuGroup selectByPrimaryKey(Integer wxCmsMenuGroupId);

	/**根据选择性实体字段分页查询实体数组*/
	List<WxCmsMenuGroup> selectByEntityAndPage(@Param("entity") WxCmsMenuGroup entity, @Param("page") Page page);

	/**根据选择性实体字段查询实体数量*/
	int countByEntity(@Param("entity") WxCmsMenuGroup entity);

}

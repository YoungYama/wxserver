package com.yzz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.yzz.dto.Page;
import com.yzz.entity.WxCmsNews;

/** 
* 
* @description: 实体类WxCmsNews的DAO接口 
* 
* @author 杨志钊 
* @date 2017-04-17 16:54:06 
*/ 
@Repository
public interface WxCmsNewsDao {

	/**单个实体全部字段添加*/
	int insert(WxCmsNews entity);

	/**根据实体ID单个实体删除*/
	int deleteByPrimaryKey(String wxCmsNewsId);

	/**根据实体ID数组批量删除实体*/
	int deleteBatch(List<String> wxCmsNewsIds);

	/**单个实体全部字段更新*/
	int updateByPrimaryKey(WxCmsNews entity);

	/**单个实体选择性字段更新*/
	int updateByPrimaryKeySelective(WxCmsNews entity);

	/**根据实体ID查询单个实体*/
	WxCmsNews selectByPrimaryKey(String wxCmsNewsId);

	/**根据选择性实体字段分页查询实体数组*/
	List<WxCmsNews> selectByEntityAndPage(@Param("entity") WxCmsNews entity, @Param("page") Page page);

	/**根据选择性实体字段查询实体数量*/
	int countByEntity(@Param("entity") WxCmsNews entity);

}

package com.yzz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.yzz.dto.Page;
import com.yzz.entity.WxCmsMenu;

/** 
* 
* @description: 实体类WxCmsMenu的DAO接口 
* 
* @author 杨志钊 
* @date 2017-04-17 16:54:06 
*/ 
@Repository
public interface WxCmsMenuDao {

	/**单个实体全部字段添加*/
	int insert(WxCmsMenu entity);

	/**根据实体ID单个实体删除*/
	int deleteByPrimaryKey(String wxCmsMenuId);

	/**根据实体ID数组批量删除实体*/
	int deleteBatch(List<String> wxCmsMenuIds);

	/**单个实体全部字段更新*/
	int updateByPrimaryKey(WxCmsMenu entity);

	/**单个实体选择性字段更新*/
	int updateByPrimaryKeySelective(WxCmsMenu entity);

	/**根据实体ID查询单个实体*/
	WxCmsMenu selectByPrimaryKey(String wxCmsMenuId);

	/**根据选择性实体字段分页查询实体数组*/
	List<WxCmsMenu> selectByEntityAndPage(@Param("entity") WxCmsMenu entity, @Param("page") Page page);

	/**根据选择性实体字段查询实体数量*/
	int countByEntity(@Param("entity") WxCmsMenu entity);

}

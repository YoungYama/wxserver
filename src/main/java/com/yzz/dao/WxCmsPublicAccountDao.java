package com.yzz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.yzz.dto.Page;
import com.yzz.entity.WxCmsPublicAccount;

/** 
* 
* @description: 实体类WxCmsPublicAccount的DAO接口 
* 
* @author 杨志钊 
* @date 2017-04-17 16:54:06 
*/ 
@Repository
public interface WxCmsPublicAccountDao {

	/**单个实体全部字段添加*/
	int insert(WxCmsPublicAccount entity);

	/**根据实体ID单个实体删除*/
	int deleteByPrimaryKey(String wxCmsPublicAccountId);

	/**根据实体ID数组批量删除实体*/
	int deleteBatch(List<String> wxCmsPublicAccountIds);

	/**单个实体全部字段更新*/
	int updateByPrimaryKey(WxCmsPublicAccount entity);

	/**单个实体选择性字段更新*/
	int updateByPrimaryKeySelective(WxCmsPublicAccount entity);

	/**根据实体ID查询单个实体*/
	WxCmsPublicAccount selectByPrimaryKey(String wxCmsPublicAccountId);

	/**根据选择性实体字段分页查询实体数组*/
	List<WxCmsPublicAccount> selectByEntityAndPage(@Param("entity") WxCmsPublicAccount entity, @Param("page") Page page);

	/**根据选择性实体字段查询实体数量*/
	int countByEntity(@Param("entity") WxCmsPublicAccount entity);

}

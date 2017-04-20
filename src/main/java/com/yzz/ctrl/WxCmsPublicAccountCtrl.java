package com.yzz.ctrl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yzz.dto.Page;
import com.yzz.dto.ResultData;
import com.yzz.entity.WxCmsPublicAccount;
import com.yzz.service.WxCmsPublicAccountService;

/** 
* 
* @description: 实体类WxCmsPublicAccount的控制器WxCmsPublicAccountCtrl 
* 
* @author 杨志钊 
* @date 2017-04-17 16:54:06 
*/ 
@Controller
@RequestMapping("/wxCmsPublicAccount")
public class WxCmsPublicAccountCtrl {

	@Resource
	WxCmsPublicAccountService wxCmsPublicAccountService;

	/**单个实体全部字段添加*/
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> insertOne(WxCmsPublicAccount entity) {
		ResultData<Void> resultData = wxCmsPublicAccountService.insertOne(entity);

		return resultData;
	}

	/**根据实体ID单个实体删除*/
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> deleteOne(String wxCmsPublicAccountId) {
		ResultData<Void> resultData = wxCmsPublicAccountService.deleteOne(wxCmsPublicAccountId);
		
		return resultData;
	}

	/**根据实体ID数组批量删除实体*/
	@RequestMapping(value = "/deleteBatch", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> deleteBatch(String[] wxCmsPublicAccountIds) {
		ResultData<Void> resultData = wxCmsPublicAccountService.deleteBatch(wxCmsPublicAccountIds);

		return resultData;
	}

	/**单个实体全部字段更新*/
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> updateOne(WxCmsPublicAccount entity) {
		ResultData<Void> resultData = wxCmsPublicAccountService.updateOne(entity);

		return resultData;
	}

	/**单个实体选择性字段更新*/
	@RequestMapping(value = "/updateSelective", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> updateOneSelective(WxCmsPublicAccount entity) {
		ResultData<Void> resultData = wxCmsPublicAccountService.updateOneSelective(entity);

		return resultData;
	}

	/**根据实体ID查询单个实体*/
	@RequestMapping(value = "/select", method = RequestMethod.GET)
	@ResponseBody
	public ResultData<WxCmsPublicAccount> selectOne(String wxCmsPublicAccountId) {
		ResultData<WxCmsPublicAccount> resultData = wxCmsPublicAccountService.selectOne(wxCmsPublicAccountId);

		return resultData;
	}

	/**根据选择性实体字段分页查询实体数组*/
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public ResultData<List<WxCmsPublicAccount>> selectList(WxCmsPublicAccount entity, Page page) {
		ResultData<List<WxCmsPublicAccount>> resultData = wxCmsPublicAccountService.selectList(entity, page);

		return resultData;
	}

	/**查询全部实体*/
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@ResponseBody
	public ResultData<List<WxCmsPublicAccount>> selectAll() {
		ResultData<List<WxCmsPublicAccount>> resultData = wxCmsPublicAccountService.selectAll();

		return resultData;
	}

}

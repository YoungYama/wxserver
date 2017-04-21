package com.yzz.ctrl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yzz.dto.Page;
import com.yzz.dto.ResultData;
import com.yzz.entity.WxCmsMenuGroup;
import com.yzz.service.WxCmsMenuGroupService;

/** 
* 
* @description: 实体类WxCmsMenuGroup的控制器WxCmsMenuGroupCtrl 
* 
* @author 杨志钊 
* @date 2017-04-21 10:07:02 
*/ 
@Controller
@RequestMapping("/wxCmsMenuGroup")
public class WxCmsMenuGroupCtrl {

	@Resource
	WxCmsMenuGroupService wxCmsMenuGroupService;

	/**单个实体全部字段添加*/
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> insertOne(WxCmsMenuGroup entity) {
		ResultData<Void> resultData = wxCmsMenuGroupService.insertOne(entity);

		return resultData;
	}

	/**根据实体ID单个实体删除*/
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> deleteOne(Integer wxCmsMenuGroupId) {
		ResultData<Void> resultData = wxCmsMenuGroupService.deleteOne(wxCmsMenuGroupId);
		
		return resultData;
	}

	/**根据实体ID数组批量删除实体*/
	@RequestMapping(value = "/deleteBatch", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> deleteBatch(Integer[] wxCmsMenuGroupIds) {
		ResultData<Void> resultData = wxCmsMenuGroupService.deleteBatch(wxCmsMenuGroupIds);

		return resultData;
	}

	/**单个实体全部字段更新*/
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> updateOne(WxCmsMenuGroup entity) {
		ResultData<Void> resultData = wxCmsMenuGroupService.updateOne(entity);

		return resultData;
	}

	/**单个实体选择性字段更新*/
	@RequestMapping(value = "/updateSelective", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> updateOneSelective(WxCmsMenuGroup entity) {
		ResultData<Void> resultData = wxCmsMenuGroupService.updateOneSelective(entity);

		return resultData;
	}

	/**根据实体ID查询单个实体*/
	@RequestMapping(value = "/select", method = RequestMethod.GET)
	@ResponseBody
	public ResultData<WxCmsMenuGroup> selectOne(Integer wxCmsMenuGroupId) {
		ResultData<WxCmsMenuGroup> resultData = wxCmsMenuGroupService.selectOne(wxCmsMenuGroupId);

		return resultData;
	}

	/**根据选择性实体字段分页查询实体数组*/
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public ResultData<List<WxCmsMenuGroup>> selectList(WxCmsMenuGroup entity, Page page) {
		ResultData<List<WxCmsMenuGroup>> resultData = wxCmsMenuGroupService.selectList(entity, page);

		return resultData;
	}

	/**查询全部实体*/
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@ResponseBody
	public ResultData<List<WxCmsMenuGroup>> selectAll() {
		ResultData<List<WxCmsMenuGroup>> resultData = wxCmsMenuGroupService.selectAll();

		return resultData;
	}

}

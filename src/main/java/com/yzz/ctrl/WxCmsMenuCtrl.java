package com.yzz.ctrl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yzz.dto.Page;
import com.yzz.dto.ResultData;
import com.yzz.entity.WxCmsMenu;
import com.yzz.service.WxCmsMenuService;

/** 
* 
* @description: 实体类WxCmsMenu的控制器WxCmsMenuCtrl 
* 
* @author 杨志钊 
* @date 2017-04-21 10:07:02 
*/ 
@Controller
@RequestMapping("/wxCmsMenu")
public class WxCmsMenuCtrl {

	@Resource
	WxCmsMenuService wxCmsMenuService;

	/**单个实体全部字段添加*/
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> insertOne(WxCmsMenu entity) {
		ResultData<Void> resultData = wxCmsMenuService.insertOne(entity);

		return resultData;
	}

	/**根据实体ID单个实体删除*/
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> deleteOne(String wxCmsMenuId) {
		ResultData<Void> resultData = wxCmsMenuService.deleteOne(wxCmsMenuId);
		
		return resultData;
	}

	/**根据实体ID数组批量删除实体*/
	@RequestMapping(value = "/deleteBatch", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> deleteBatch(String[] wxCmsMenuIds) {
		ResultData<Void> resultData = wxCmsMenuService.deleteBatch(wxCmsMenuIds);

		return resultData;
	}

	/**单个实体全部字段更新*/
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> updateOne(WxCmsMenu entity) {
		ResultData<Void> resultData = wxCmsMenuService.updateOne(entity);

		return resultData;
	}

	/**单个实体选择性字段更新*/
	@RequestMapping(value = "/updateSelective", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> updateOneSelective(WxCmsMenu entity) {
		ResultData<Void> resultData = wxCmsMenuService.updateOneSelective(entity);

		return resultData;
	}

	/**根据实体ID查询单个实体*/
	@RequestMapping(value = "/select", method = RequestMethod.GET)
	@ResponseBody
	public ResultData<WxCmsMenu> selectOne(String wxCmsMenuId) {
		ResultData<WxCmsMenu> resultData = wxCmsMenuService.selectOne(wxCmsMenuId);

		return resultData;
	}

	/**根据选择性实体字段分页查询实体数组*/
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public ResultData<List<WxCmsMenu>> selectList(WxCmsMenu entity, Page page) {
		ResultData<List<WxCmsMenu>> resultData = wxCmsMenuService.selectList(entity, page);

		return resultData;
	}

	/**查询全部实体*/
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@ResponseBody
	public ResultData<List<WxCmsMenu>> selectAll() {
		ResultData<List<WxCmsMenu>> resultData = wxCmsMenuService.selectAll();

		return resultData;
	}

}

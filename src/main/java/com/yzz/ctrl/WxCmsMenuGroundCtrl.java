package com.yzz.ctrl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yzz.dto.Page;
import com.yzz.dto.ResultData;
import com.yzz.entity.WxCmsMenuGround;
import com.yzz.service.WxCmsMenuGroundService;

/** 
* 
* @description: 实体类WxCmsMenuGround的控制器WxCmsMenuGroundCtrl 
* 
* @author 杨志钊 
* @date 2017-04-17 16:54:06 
*/ 
@Controller
@RequestMapping("/wxCmsMenuGround")
public class WxCmsMenuGroundCtrl {

	@Resource
	WxCmsMenuGroundService wxCmsMenuGroundService;

	/**单个实体全部字段添加*/
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> insertOne(WxCmsMenuGround entity) {
		ResultData<Void> resultData = wxCmsMenuGroundService.insertOne(entity);

		return resultData;
	}

	/**根据实体ID单个实体删除*/
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> deleteOne(Integer wxCmsMenuGroundId) {
		ResultData<Void> resultData = wxCmsMenuGroundService.deleteOne(wxCmsMenuGroundId);
		
		return resultData;
	}

	/**根据实体ID数组批量删除实体*/
	@RequestMapping(value = "/deleteBatch", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> deleteBatch(Integer[] wxCmsMenuGroundIds) {
		ResultData<Void> resultData = wxCmsMenuGroundService.deleteBatch(wxCmsMenuGroundIds);

		return resultData;
	}

	/**单个实体全部字段更新*/
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> updateOne(WxCmsMenuGround entity) {
		ResultData<Void> resultData = wxCmsMenuGroundService.updateOne(entity);

		return resultData;
	}

	/**单个实体选择性字段更新*/
	@RequestMapping(value = "/updateSelective", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> updateOneSelective(WxCmsMenuGround entity) {
		ResultData<Void> resultData = wxCmsMenuGroundService.updateOneSelective(entity);

		return resultData;
	}

	/**根据实体ID查询单个实体*/
	@RequestMapping(value = "/select", method = RequestMethod.GET)
	@ResponseBody
	public ResultData<WxCmsMenuGround> selectOne(Integer wxCmsMenuGroundId) {
		ResultData<WxCmsMenuGround> resultData = wxCmsMenuGroundService.selectOne(wxCmsMenuGroundId);

		return resultData;
	}

	/**根据选择性实体字段分页查询实体数组*/
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public ResultData<List<WxCmsMenuGround>> selectList(WxCmsMenuGround entity, Page page) {
		ResultData<List<WxCmsMenuGround>> resultData = wxCmsMenuGroundService.selectList(entity, page);

		return resultData;
	}

	/**查询全部实体*/
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@ResponseBody
	public ResultData<List<WxCmsMenuGround>> selectAll() {
		ResultData<List<WxCmsMenuGround>> resultData = wxCmsMenuGroundService.selectAll();

		return resultData;
	}

}

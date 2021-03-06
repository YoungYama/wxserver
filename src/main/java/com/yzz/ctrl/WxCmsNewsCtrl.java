package com.yzz.ctrl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yzz.dto.Page;
import com.yzz.dto.ResultData;
import com.yzz.entity.WxCmsNews;
import com.yzz.service.WxCmsNewsService;

/** 
* 
* @description: 实体类WxCmsNews的控制器WxCmsNewsCtrl 
* 
* @author 杨志钊 
* @date 2017-04-17 16:54:06 
*/ 
@Controller
@RequestMapping("/wxCmsNews")
public class WxCmsNewsCtrl {

	@Resource
	WxCmsNewsService wxCmsNewsService;

	/**单个实体全部字段添加*/
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> insertOne(WxCmsNews entity) {
		ResultData<Void> resultData = wxCmsNewsService.insertOne(entity);

		return resultData;
	}

	/**根据实体ID单个实体删除*/
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> deleteOne(String wxCmsNewsId) {
		ResultData<Void> resultData = wxCmsNewsService.deleteOne(wxCmsNewsId);
		
		return resultData;
	}

	/**根据实体ID数组批量删除实体*/
	@RequestMapping(value = "/deleteBatch", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> deleteBatch(String[] wxCmsNewsIds) {
		ResultData<Void> resultData = wxCmsNewsService.deleteBatch(wxCmsNewsIds);

		return resultData;
	}

	/**单个实体全部字段更新*/
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> updateOne(WxCmsNews entity) {
		ResultData<Void> resultData = wxCmsNewsService.updateOne(entity);

		return resultData;
	}

	/**单个实体选择性字段更新*/
	@RequestMapping(value = "/updateSelective", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> updateOneSelective(WxCmsNews entity) {
		ResultData<Void> resultData = wxCmsNewsService.updateOneSelective(entity);

		return resultData;
	}

	/**根据实体ID查询单个实体*/
	@RequestMapping(value = "/select", method = RequestMethod.GET)
	@ResponseBody
	public ResultData<WxCmsNews> selectOne(String wxCmsNewsId) {
		ResultData<WxCmsNews> resultData = wxCmsNewsService.selectOne(wxCmsNewsId);

		return resultData;
	}

	/**根据选择性实体字段分页查询实体数组*/
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public ResultData<List<WxCmsNews>> selectList(WxCmsNews entity, Page page) {
		ResultData<List<WxCmsNews>> resultData = wxCmsNewsService.selectList(entity, page);

		return resultData;
	}

	/**查询全部实体*/
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@ResponseBody
	public ResultData<List<WxCmsNews>> selectAll() {
		ResultData<List<WxCmsNews>> resultData = wxCmsNewsService.selectAll();

		return resultData;
	}

}

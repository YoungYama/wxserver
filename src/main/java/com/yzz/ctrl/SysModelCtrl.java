package com.yzz.ctrl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yzz.dto.Page;
import com.yzz.dto.ResultData;
import com.yzz.entity.SysModel;
import com.yzz.service.SysModelService;

/** 
* 
* @description: 实体类SysModel的控制器SysModelCtrl 
* 
* @author 杨志钊 
* @date 2017-04-17 18:17:44 
*/ 
@Controller
@RequestMapping("/sysModel")
public class SysModelCtrl {

	@Resource
	SysModelService sysModelService;

	/**单个实体全部字段添加*/
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> insertOne(SysModel entity) {
		ResultData<Void> resultData = sysModelService.insertOne(entity);

		return resultData;
	}

	/**根据实体ID单个实体删除*/
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> deleteOne(Integer sysModelId) {
		ResultData<Void> resultData = sysModelService.deleteOne(sysModelId);
		
		return resultData;
	}

	/**根据实体ID数组批量删除实体*/
	@RequestMapping(value = "/deleteBatch", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> deleteBatch(Integer[] sysModelIds) {
		ResultData<Void> resultData = sysModelService.deleteBatch(sysModelIds);

		return resultData;
	}

	/**单个实体全部字段更新*/
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> updateOne(SysModel entity) {
		ResultData<Void> resultData = sysModelService.updateOne(entity);

		return resultData;
	}

	/**单个实体选择性字段更新*/
	@RequestMapping(value = "/updateSelective", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> updateOneSelective(SysModel entity) {
		ResultData<Void> resultData = sysModelService.updateOneSelective(entity);

		return resultData;
	}

	/**根据实体ID查询单个实体*/
	@RequestMapping(value = "/select", method = RequestMethod.GET)
	@ResponseBody
	public ResultData<SysModel> selectOne(Integer sysModelId) {
		ResultData<SysModel> resultData = sysModelService.selectOne(sysModelId);

		return resultData;
	}

	/**根据选择性实体字段分页查询实体数组*/
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public ResultData<List<SysModel>> selectList(SysModel entity, Page page) {
		ResultData<List<SysModel>> resultData = sysModelService.selectList(entity, page);

		return resultData;
	}

	/**查询全部实体*/
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@ResponseBody
	public ResultData<List<SysModel>> selectAll() {
		ResultData<List<SysModel>> resultData = sysModelService.selectAll();

		return resultData;
	}

}

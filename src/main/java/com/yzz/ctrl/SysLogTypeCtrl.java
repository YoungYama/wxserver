package com.yzz.ctrl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yzz.dto.Page;
import com.yzz.dto.ResultData;
import com.yzz.entity.SysLogType;
import com.yzz.service.SysLogTypeService;

/** 
* 
* @description: 实体类SysLogType的控制器SysLogTypeCtrl 
* 
* @author 杨志钊 
* @date 2017-04-17 16:54:06 
*/ 
@Controller
@RequestMapping("/sysLogType")
public class SysLogTypeCtrl {

	@Resource
	SysLogTypeService sysLogTypeService;

	/**单个实体全部字段添加*/
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> insertOne(SysLogType entity) {
		ResultData<Void> resultData = sysLogTypeService.insertOne(entity);

		return resultData;
	}

	/**根据实体ID单个实体删除*/
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> deleteOne(Integer sysLogTypeId) {
		ResultData<Void> resultData = sysLogTypeService.deleteOne(sysLogTypeId);
		
		return resultData;
	}

	/**根据实体ID数组批量删除实体*/
	@RequestMapping(value = "/deleteBatch", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> deleteBatch(Integer[] sysLogTypeIds) {
		ResultData<Void> resultData = sysLogTypeService.deleteBatch(sysLogTypeIds);

		return resultData;
	}

	/**单个实体全部字段更新*/
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> updateOne(SysLogType entity) {
		ResultData<Void> resultData = sysLogTypeService.updateOne(entity);

		return resultData;
	}

	/**单个实体选择性字段更新*/
	@RequestMapping(value = "/updateSelective", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> updateOneSelective(SysLogType entity) {
		ResultData<Void> resultData = sysLogTypeService.updateOneSelective(entity);

		return resultData;
	}

	/**根据实体ID查询单个实体*/
	@RequestMapping(value = "/select", method = RequestMethod.GET)
	@ResponseBody
	public ResultData<SysLogType> selectOne(Integer sysLogTypeId) {
		ResultData<SysLogType> resultData = sysLogTypeService.selectOne(sysLogTypeId);

		return resultData;
	}

	/**根据选择性实体字段分页查询实体数组*/
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public ResultData<List<SysLogType>> selectList(SysLogType entity, Page page) {
		ResultData<List<SysLogType>> resultData = sysLogTypeService.selectList(entity, page);

		return resultData;
	}

	/**查询全部实体*/
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@ResponseBody
	public ResultData<List<SysLogType>> selectAll() {
		ResultData<List<SysLogType>> resultData = sysLogTypeService.selectAll();

		return resultData;
	}

}

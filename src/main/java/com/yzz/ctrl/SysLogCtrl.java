package com.yzz.ctrl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yzz.dto.Page;
import com.yzz.dto.ResultData;
import com.yzz.entity.SysLog;
import com.yzz.service.SysLogService;

/** 
* 
* @description: 实体类SysLog的控制器SysLogCtrl 
* 
* @author 杨志钊 
* @date 2017-04-17 16:54:06 
*/ 
@Controller
@RequestMapping("/sysLog")
public class SysLogCtrl {

	@Resource
	SysLogService sysLogService;

	/**单个实体全部字段添加*/
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> insertOne(SysLog entity) {
		ResultData<Void> resultData = sysLogService.insertOne(entity);

		return resultData;
	}

	/**根据实体ID单个实体删除*/
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> deleteOne(String sysLogId) {
		ResultData<Void> resultData = sysLogService.deleteOne(sysLogId);
		
		return resultData;
	}

	/**根据实体ID数组批量删除实体*/
	@RequestMapping(value = "/deleteBatch", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> deleteBatch(String[] sysLogIds) {
		ResultData<Void> resultData = sysLogService.deleteBatch(sysLogIds);

		return resultData;
	}

	/**单个实体全部字段更新*/
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> updateOne(SysLog entity) {
		ResultData<Void> resultData = sysLogService.updateOne(entity);

		return resultData;
	}

	/**单个实体选择性字段更新*/
	@RequestMapping(value = "/updateSelective", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<Void> updateOneSelective(SysLog entity) {
		ResultData<Void> resultData = sysLogService.updateOneSelective(entity);

		return resultData;
	}

	/**根据实体ID查询单个实体*/
	@RequestMapping(value = "/select", method = RequestMethod.GET)
	@ResponseBody
	public ResultData<SysLog> selectOne(String sysLogId) {
		ResultData<SysLog> resultData = sysLogService.selectOne(sysLogId);

		return resultData;
	}

	/**根据选择性实体字段分页查询实体数组*/
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public ResultData<List<SysLog>> selectList(SysLog entity, Page page) {
		ResultData<List<SysLog>> resultData = sysLogService.selectList(entity, page);

		return resultData;
	}

	/**查询全部实体*/
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@ResponseBody
	public ResultData<List<SysLog>> selectAll() {
		ResultData<List<SysLog>> resultData = sysLogService.selectAll();

		return resultData;
	}

}

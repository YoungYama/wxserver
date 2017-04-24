/**
 * 公共方法
 */

/**
 * 对数据库进行啊增删改操作，并弹窗提示
 */
function databaseOperationByAjax(url, method = 'POST', data = {}){
	var result = null;
	$.ajax({
		url : url,
		type : method,
		data : data,
		async:false,// 同步
		success : function(callbackData){
			if(callbackData.success){
				result = callbackData.data;
				alert(callbackData.msg);
			}else{
				alert(callbackData.msg);
			}
		},
		error : function(){
			alert('服务器错误，请重新尝试或者尝试联系管理员');
		}
	});
	
	return result;
}

/**
 * 获取根URI
 * 
 * @returns
 */
function getRootPath() {
	var pathName = window.document.location.pathname;
	var projectName = pathName.substring(0, pathName.substr(1).indexOf(
			'/') + 1);

	var rootPath = window.location.protocol + "//"
			+ window.location.host + projectName;

	return rootPath;
}

/**
 * 字符串全部替换
 */
String.prototype.replaceAll = function(oldString, newString) {
	return this.replace(new RegExp(oldString, "gm"), newString);
}

/**
 * 遍历数组是否包括某值
 */
Array.prototype.contains = function(value){
	var result = false;
	for(var i in this){
		if (this[i].toString() == value.toString()) {
			result = true;
		}
	}
	
	return result;
}
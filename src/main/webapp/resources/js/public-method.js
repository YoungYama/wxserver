/**
 * 公共方法
 */

/**
 * 对数据库进行啊增删改操作，并弹窗提示
 */
function databaseOperationByAjax(url, method = 'POST', data = {}){
	$.ajax({
		url : url,
		type : method,
		data : data,
		success : function(callbackData){
			if(callbackData.success){
				alert(JSON.stringify(callbackData.data));
				alert(callbackData.msg);
			}else{
				alert(callbackData.msg);
			}
		},
		error : function(){
			alert('服务器错误，请重新尝试或者尝试联系管理员');
		}
	});
}

/**
 * 获取根URI
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
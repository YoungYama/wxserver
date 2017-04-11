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
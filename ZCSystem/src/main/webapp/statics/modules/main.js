/**
 * @Title 封装通用Ajax请求
 * @param updateDiv
 *            要更新的div (id选择需传#id)
 * @param req_url
 *            请求URL
 * @param req_type
 *            "GET/POST"
 * @param req_dataType
 *            "返回数据类型：如json/xml/html/jsonp/text/script"
 * @param callback
 *            用户自定义回调函数,ajax请求返回后如有特殊处理逻辑，可以通过回调函数实现
 * @author shijingbang
 */
function sendAjaxRequest(updateDiv, req_url, req_type, req_dataType, req_data,callback, errCallback) {
	req_type = req_type || 'GET';// 默认GET请求
	req_dataType = req_dataType || 'json';// 默认返回纯文本 HTML信息,包含的 script标签会在插入dom 时执行
	req_data = req_data || '';
	$.ajax({
		url : req_url,
		type : req_type,
		data : req_data,
		dataType : req_dataType,
		success : function(text) {
			if ('json' == req_dataType) {
				//暂时什么都不处理
			} else if ('html' == req_dataType && updateDiv) {
				$(updateDiv).html(text);//更新DIV
			}
			if (callback) {// 用户自定义回调函数
				callback(text);
			}
		},
		error : function(xhr, textStatus) {
			$.messager.alert('提示', '系统发生异常,请联系管理员!', 'info');
			if (errCallback) {//用户自定义错误回调处理函数
				errCallback(xhr, textStatus);
			}
		}
	});
}

/**
 * 根据form表单的id获取表单下所有可提交的表单数据，封装成对象
 * 
 * @param formId
 * @returns
 * @author shijingbang
 */
function getFormData(formId){
	var data = {};
	var results = $(formId).serializeArray();
	$.each(results,function(index,item){
		//文本表单的值不为空才处理
		if(item.value && $.trim(item.value)!=""){
			if(!data[item.name]){
				data[item.name]=item.value;
			}else{
				//name属性相同的表单，值以英文,拼接
				data[item.name]=data[item.name]+','+item.value;
			}
		}
	});
	//console.log(data);
	return data;
}



/**
 * 扩展Date类原型对象，格式化日期
 * 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符， 
 * 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字) 
 * 例子： 
 * (new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2015-07-02 08:09:04.423 
 * (new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2015-7-2 8:9:4.18 
 */
Date.prototype.Format = function (fmt) { 
    var o = {
        "M+": this.getMonth() + 1, //月份 
        "d+": this.getDate(), //日 
        "h+": this.getHours(), //小时 
        "m+": this.getMinutes(), //分 
        "s+": this.getSeconds(), //秒 
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
        "S": this.getMilliseconds() //毫秒 
    };
    //使用正则表达式格式化日期
    if (/(y+)/.test(fmt)) {
       fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    }
    for (var k in o){
    	if (new RegExp("(" + k + ")").test(fmt)){
    		fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    	}
    }
    return fmt;
}
/**
 * 微信端 根据部门ID获取部门下所有用户信息
 */
function getUsersByDeptId(url){
	var users = {};
	sendAjaxRequest(null, url, "GET", "json", null, function(result){
		users = result;
	}, null);
	return users;
}

/**
 * 微信端 根据部门ID获取部门下所有用户信息
 */
function getUsersByTagId(url){
	var users = {};
	sendAjaxRequest(null, url, "GET", "json", null, function(result){
		users = result;
	}, null);
	return users;
}
/**
 * 数组合并，不校验是否有重复
 */
Array.prototype.merge=function(arr2){
	for(var i=0;i<arr2.length;i++){
		this.push(arr2[i]);
	}
}

function concatUsers(users){
	var user={};
	if(users&&users['userlist']){
		user.userIds=[];
		user.userNames=[];
		for(var i=0;i<users['userlist'].length;i++){
			user.userIds.push(users['userlist'][i].userid);
			user.userNames.push(users['userlist'][i].name);
		}
	}
	return user;
}


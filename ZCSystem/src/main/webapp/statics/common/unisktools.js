/**
 * 判断值是否不为'',null，undefined,直接返回改值
 */
function getNull(v){
	if(v == null || v == "" || v == "null" || typeof(v) == 'undefined'){
		return null;
	}else{
		return v;
	}
}

//获取参数值
function getParameter(param){
	var v = getValueByName(window.location.search,param);
	return v;
}

//获取表单值
function getForm(data,param){
	var v = getValueByName(data,param);
	return v;
}

//获取链接值
function getValueByName(query,param){
	var query = query.split('?')[1];
	var iLen = param.length;
    var iStart = query.indexOf(param);
    if (iStart == -1) return "";
	iStart += iLen + 1;
	var iEnd = query.indexOf("&", iStart);
    if (iEnd == -1) return query.substring(iStart); 
	return query.substring(iStart, iEnd);
}

function generateMixed(n) {
    var jschars = ['0','1','2','3','4','5','6','7','8','9'];
    var res = "";
    for(var i = 0; i < n ; i ++) {
        var id = Math.ceil(Math.random()*10);
        res += jschars[id-1];
    }
    return res;
}

// 发送jsop请求
function sendRequestPost(url, data, successfn, errorfn) {
	$.ajax({
		type : "post",
		dataType : "json",
//		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		data : data,
		url : url,
		context : $(this),
		success : function(d) {
			successfn(d);
		},
		error : function(e) {
			if( errorfn ) errorfn(e);
		}
	});
}

function uploadFile(fileId, saveid, showid) {
	var options = {
		target : '/backstage/common/uploadFile.do?'
				+ Math.random().toString(16).substring(2), // target element(s)
		success : showResponse, // post-submit callback
		url : '/backstage/common/uploadFile.do?'
				+ Math.random().toString(16).substring(2), // override for
		dataType : 'text' // 'xml', 'script', or 'json' (expected server
	};
	var form = jQuery('<form></form>');
	jQuery(form).append(jQuery('#' + fileId));
	jQuery(form).ajaxSubmit(options);
	if ($('#' + saveid).siblings('#' + fileId).size() == 0)
		$('#' + saveid).parent().append($(form).children('#' + fileId));
	return false;
	// post-submit callback
	function showResponse(responseText, statusText, xhr, $form) {
		if (responseText.length > 0) {
			var data = JSON.parse(responseText);
			$('#' + saveid).val("" + data.url);
		} else {
			alert(responseText);
		}

	}
}

/**
 * id : 对那个方法使用这个全选方法
 * container : 范围
 */
var selectAll = function(id,container){
	$('#' + id).on('click',function(){
		var _this = this , _checked = $('input[type="checkbox"]',container).not('#' + id);
		if($(_this).attr('checked')) $(_checked).attr('checked', 'checked' );
		else $(_checked).attr('checked', false );
	});
}

function upload(fileId, saveid, showid) {
	var options = {
		target : '/upload.do?' + Math.random().toString(16).substring(2), // target element(s)
		success : showResponse, // post-submit callback
		url : '/upload.do?' + Math.random().toString(16).substring(2), // override for
		dataType : 'text' // 'xml', 'script', or 'json' (expected server
	};
	var form = jQuery('<form method="post" enctype="multipart/form-data"></form>');
	jQuery('#' + fileId).clone().appentTo(form);
	jQuery(form).ajaxSubmit(options);
	return false;

	function showResponse(responseText, statusText, xhr, $form) {
		if (responseText.length > 0) {
			$('#' + saveid).val("" + responseText);
		}
	}
}
function validPhone( phone ){
	if( !phone || phone == '' || phone.length == 0 )
	var pattern = /^((13[0-9])|(15[^4,\d])|(18[0,5-9]))\d{8}$/;
	if( !  pattern.test(phone) )return false; 
	else return true;
}
/**
 * 扩展validate  用于验证mobile类型的input
 * 使用 class="mobile"
 */
$.validator.addMethod('mobile', function(mobile, element) {
	return this.optional(element) || mobile.length == 11 &&
	mobile.match(/^((13[0-9])|(15[0-3,5-9])|(18[0,5-9]))\d{8}$/);
}, '请输入正确手机号码...');


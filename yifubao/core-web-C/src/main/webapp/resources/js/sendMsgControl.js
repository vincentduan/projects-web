/**
 * send message change
 */

$(function() {
	$("#btnCode").click(function() {
		//执行获取验证码的操作
		GetNumber();
	});
})

var count = 90;
function GetNumber() {
	$("#btnCode").attr("disabled", "disabled");
	$("#btnCode").val(count + "秒之后点击获取")
	count--;
	if (count > 0) {
		setTimeout(GetNumber, 1000);
	} else {
		$("#btnCode").val("点击获取验证码");
		$("#btnCode").attr("disabled", "");
	}
}

$(document).ready(function() {
	$(".ui-input").focus(function() {
		$(this).addClass("hover");
	});
	 $(".nav-dl dl").hover(function() {
		$(this).addClass("hover");
	}, function() {
		$(this).removeClass("hover");
	});
	$(".stills a").click(function() {
		var imgurl = $(this).attr("href");
		moviePhoto(imgurl);
		return false;
	});
	$(".img a").click(function() {
		var imgurl = $(this).attr("href");
		moviePhoto(imgurl);
		return false;
	});
});
/*弹窗*/
function getWindow(id) {
    showPoplayer(id);
    $("#"+id+" a.pop-close").click(function () {
        hidePoplayer(id);
    });
	$("#"+id+" .btn-cancel").click(function () {
        hidePoplayer(id);
    });
    $("#shadowlayer").click(function () {
        hidePoplayer(id);
    });
}
function hidePoplayer(id){
    $("#"+id).hide();
    $("#shadowlayer").remove();
    if ($.browser.msie && $.browser.version == "6.0") {
        $(".cont select").show();
    }
}
function showPoplayer(id) {
	var idH = -$("#" + id).height()/2;
    $('<div id="shadowlayer"></div>').appendTo("body").show();
	$("#" + id).show().css("margin-top",idH);
    if ($.browser.msie && $.browser.version == "6.0") {
        var $wHeight = $(window).height();
        var $dHeight = $(document).height();
        var $maxHeight = Math.max($dHeight, $wHeight);
        var ctop = $(window).scrollTop() + $wHeight / 2;
        $("#shadowlayer").css("height",$maxHeight);
        $("#"+id).css("top",ctop);
		$("#"+id).find(".pop-border").css({"width":$("#"+id).width()+10,"height":$("#"+id).height()+10});
        $(window).scroll(function () {
            var ctop = $(this).scrollTop() + $wHeight / 2;
            $("#" + id).css("top",ctop);
        });
        $(".cont select").hide();
    }
}
/*图片弹窗*/
function moviePhoto(imgurl){
	var moviePhotoBox=$('<div class="pop-view" id="movie-photo" style="width:599px;height:399px;margin-top:-199.5px;margin-left:-299.5px;"><a href="javascript:void(0);" class="pop-view-close iepng"><i></i></a><div class="pop-border"></div><div class="pop-main"><img src="'+imgurl+'" /><div class="pop-view-pn"><a class="pop-view-prev iepng" hidefocus="true" href="javascript:void(0);"><i></i></a><a class="pop-view-next iepng" hidefocus="true" href="javascript:void(0);"><i></i></a></div></div></div>');
	moviePhotoBox.appendTo("body");
	showPoplayer("movie-photo");
	$("#shadowlayer").click(function(){
		hidePoplayer("movie-photo");
		$("#movie-photo").remove();
	});
	$("#movie-photo a.pop-view-close").click(function(){
		hidePoplayer("movie-photo");
		$("#movie-photo").remove();
	});
}
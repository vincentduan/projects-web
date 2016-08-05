$(function(){
	$("input[type='text']").not(".no").each(function(){
		$(this).placeholder();
	});
	$(".tabs").each(function(){
		$(this).tabs();
	});
	resize();
	$(window).resize(function(event) {
		resize();
	});


	$(".daohang_2").hover(function () {
	    $(".daohang_2").removeClass("on")
	    $(this).addClass("on");
	});

	$(".sem").hover(function () { $(this).addClass("on"); }, function () { $(this).removeClass("on"); })

	//$(".list i").hover(function () { 
	//    if ($(this).parents(".item").hasClass("on")) {
	//        $(".tanchuan").hide();
	//        $(this).parents(".list").find(".tanchuan").show();
	//    }
	//}, function () {
	//    $(".tanchuan").hide()
	//})

	$(".togg_list span").click(function () {
	    $(".togg_list span").removeClass("on");
	    $(this).addClass("on");
	    $(".togg_cont .taggle").hide().eq($(this).index()).show();
	})
 
	$(".con_right ul li").last().addClass("on")

    /*info*/
			$(".cur").click(function () {
			    if ($(this).hasClass("cur_top")) {
			        $(".slider_left ul").stop().animate({ scrollTop: 0 }, 1000)
			    }
			    else {
			        $(".slider_left ul").stop().animate({ scrollTop: 410 }, 1000)

			    }
			})
			$(".pro_desc .item p.p_color span").click(function () {
			    $(".pro_desc .item p.p_color span").removeClass("on");
			    $(this).addClass("on");
			    $(".slider_pic .img").find("img").attr("src", $(this).find("img").attr("src"));
			})
			$(".slider_left ul li").hover(function () {
			    $(".slider_left ul li").removeClass("on")
			    $(this).addClass("on")
			    $(".slider_pic .img").find("img").attr("src", $(this).find("img").attr("src"));
			})


});

/*main*/
//

/*call*/
//

 









function resize(){
	var ht=$(window).height();
	$(".flht").height(ht);
}
$.fn.placeholder = function () {
    var $obj = this;
    var v = $(this).val();
    $obj.focus(function (event) {
        if ($obj.val() == v) {
            $obj.val("");
        }
    });
    $obj.blur(function (event) {
        if ($obj.val() == "") {
            $obj.val(v);
        }
    });
}
$.fn.tabs = function () {
    var $obj = this;
    var $tabs = $obj.find(".ts >.t");
    var $cnts = $obj.find(".cs >.c");

    $tabs.click(function (event) {
        var i = $tabs.index(this);
        $cnts.hide();
        $cnts.eq(i).show();

        $tabs.removeClass('on');
        $(this).addClass('on');

        return false;
    });
    $tabs.first().click();
}
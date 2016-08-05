<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
    <head>
        
<script type="text/javascript"> 
    var page_begintime = (+new Date());

    var biz = "MzA3ODc4NjkyMw==";
    var sn = "155e3d9cb2a79383b28602197339272c" || "";
    var mid = "212369325" || "";
    var idx = "1" || "" ;
    
    //辟谣需求
    var is_rumor = ""*1;
    var norumor = ""*1;
    if (!!is_rumor&&!norumor){
      if (!document.referrer || document.referrer.indexOf("mp.weixin.qq.com/mp/rumor") == -1){
        location.href = "http://mp.weixin.qq.com/mp/rumor?action=info&__biz=" + biz + "&mid=" + mid + "&idx=" + idx + "&sn=" + sn + "#wechat_redirect";
      }
    }

    //原创需求，需要跳转到中间页
    /*
    var copyrightInfo = {
        display_source : ""*1,
        nocopyrightsource : ""*1
    };
    if (!!copyrightInfo.display_source&&!copyrightInfo.nocopyrightsource){
      if (!document.referrer || document.referrer.indexOf("mp.weixin.qq.com/mp/reprint") == -1){
        location.href = "http://mp.weixin.qq.com/mp/reprint?action=info&__biz=" + biz + "&mid=" + mid + "&idx=" + idx + "&sn=" + sn + "#wechat_redirect";
      }
    }*/
</script>

        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0" />

<link rel="dns-prefetch" href="//res.wx.qq.com">
<link rel="dns-prefetch" href="//mmbiz.qpic.cn">
<link rel="shortcut icon" type="image/x-icon" href="http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/images/icon/common/favicon22c41b.ico">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no">
<script type="text/javascript">
    String.prototype.html = function(encode) {
        var replace =["&#39;", "'", "&quot;", '"', "&nbsp;", " ", "&gt;", ">", "&lt;", "<", "&amp;", "&", "&yen;", "¥"];
        if (encode) {
            replace.reverse();
        }
        for (var i=0,str=this;i< replace.length;i+= 2) {
             str=str.replace(new RegExp(replace[i],'g'),replace[i+1]);
        }
        return str;
    };

    window.isInWeixinApp = function() {
        return /MicroMessenger/.test(navigator.userAgent);
    };

    window.getQueryFromURL = function(url) {
        url = url || 'http://qq.com/s?a=b#rd'; // 做一层保护，保证URL是合法的
        var query = url.split('?')[1].split('#')[0].split('&'),
            params = {};
        for (var i=0; i<query.length; i++) {
            var arg = query[i].split('=');
            params[arg[0]] = arg[1];
        }
        if (params['pass_ticket']) {
        	params['pass_ticket'] = encodeURIComponent(params['pass_ticket'].html(false).html(false).replace(/\s/g,"+"));
        }
        return params;
    };

    (function() {
	    var params = getQueryFromURL(location.href);
        window.uin = params['uin'] || '';
        window.key = params['key'] || '';
        window.wxtoken = params['wxtoken'] || '';
        window.pass_ticket = params['pass_ticket'] || '';
    })();

    window.logs = {
    	pagetime: {}
    };
</script>

        <title>沃众筹微信平台用户操作帮助指南</title>
        
<link rel="stylesheet" type="text/css" href="http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/style/page/appmsg/page_mp_article_improve29d6da.css">
<style>
     
    </style>
<!--[if lt IE 9]>
<link rel="stylesheet" type="text/css" href="http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/style/page/appmsg/page_mp_article_improve_pc2826cc.css">
<![endif]-->
<script type="text/javascript">
    document.domain = "qq.com";
</script>

    </head>
    <body id="activity-detail" class="zh_CN mm_appmsg" ontouchstart="">
        
    <script type="text/javascript">
        var write_sceen_time = (+new Date());
    </script>
    
    <div id="js_cmt_mine" class="discuss_container editing access" style="display:none;">
        <div class="discuss_container_inner">
            <h2 class="rich_media_title">沃众筹微信平台用户操作帮助指南</h2>
            <span id="log"></span>
            <div class="frm_textarea_box_wrp">
                <span class="frm_textarea_box">
                    <textarea id="js_cmt_input" class="frm_textarea" placeholder="评论将由公众帐号筛选后显示，对所有人可见。"></textarea>
                    <div class="emotion_tool">
                        <span class="emotion_switch" style="display:none;"></span>
                        <span id="js_emotion_switch" class="pic_emotion_switch_wrp">
                            <img class="pic_default" src="http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/images/icon/appmsg/emotion/icon_emotion_switch.2x278965.png" alt="">
                            <img class="pic_active" src="http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/images/icon/appmsg/emotion/icon_emotion_switch_active.2x278965.png" alt="">
                        </span>
                        <div class="emotion_panel" id="js_emotion_panel">
                            <span class="emotion_panel_arrow_wrp" id="js_emotion_panel_arrow_wrp">
                                <i class="emotion_panel_arrow arrow_out"></i>
                                <i class="emotion_panel_arrow arrow_in"></i>
                            </span>
                            <div class="emotion_list_wrp" id="js_slide_wrapper">
                                
                                
                            </div>
                            <ul class="emotion_navs" id="js_navbar">
                                
                            </ul>
                        </div>
                    </div>
                </span>
            </div>
            <div class="discuss_btn_wrp"><a id="js_cmt_submit" class="btn btn_primary btn_discuss btn_disabled" href="javascript:;">提交</a></div>
            <div class="discuss_list_wrp" style="display:none">
                <div class="rich_tips with_line title_tips discuss_title_line">
                    <span class="tips">我的评论</span>
                </div>
                <ul class="discuss_list" id="js_cmt_mylist"></ul>
            </div>
            <div class="rich_tips tips_global loading_tips" id="js_mycmt_loading">
                <img src="http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/images/icon/common/icon_loading_white2805ea.gif" class="rich_icon icon_loading_white" alt="">
                <span class="tips">加载中</span>
            </div>
            <div class="wx_poptips" id="js_cmt_toast" style="display:none;">
                <img alt="" class="icon_toast" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAGoAAABqCAYAAABUIcSXAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAA3NpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuNS1jMDE0IDc5LjE1MTQ4MSwgMjAxMy8wMy8xMy0xMjowOToxNSAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wTU09Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9tbS8iIHhtbG5zOnN0UmVmPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvc1R5cGUvUmVzb3VyY2VSZWYjIiB4bWxuczp4bXA9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC8iIHhtcE1NOk9yaWdpbmFsRG9jdW1lbnRJRD0ieG1wLmRpZDoyMTUxMzkxZS1jYWVhLTRmZTMtYTY2NS0xNTRkNDJiOGQyMWIiIHhtcE1NOkRvY3VtZW50SUQ9InhtcC5kaWQ6MTA3QzM2RTg3N0UwMTFFNEIzQURGMTQzNzQzMDAxQTUiIHhtcE1NOkluc3RhbmNlSUQ9InhtcC5paWQ6MTA3QzM2RTc3N0UwMTFFNEIzQURGMTQzNzQzMDAxQTUiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENDIChNYWNpbnRvc2gpIj4gPHhtcE1NOkRlcml2ZWRGcm9tIHN0UmVmOmluc3RhbmNlSUQ9InhtcC5paWQ6NWMyOGVjZTMtNzllZS00ODlhLWIxZTYtYzNmM2RjNzg2YjI2IiBzdFJlZjpkb2N1bWVudElEPSJ4bXAuZGlkOjIxNTEzOTFlLWNhZWEtNGZlMy1hNjY1LTE1NGQ0MmI4ZDIxYiIvPiA8L3JkZjpEZXNjcmlwdGlvbj4gPC9yZGY6UkRGPiA8L3g6eG1wbWV0YT4gPD94cGFja2V0IGVuZD0iciI/Pmvxj1gAAAVrSURBVHja7J15rF1TFMbXk74q1ZKHGlMkJVIhIgg1FH+YEpEQJCKmGBpThRoSs5jVVNrSQUvEEENIhGiiNf9BiERICCFIRbUiDa2qvudbOetF3Tzv7XWGffa55/uS7593977n3vO7e5+199p7v56BgQGh0tcmvAUERREUQVEERREUQVEERREUQVEERREUQVEERREUQVEERREUQVEERVAUQVEERVAUQbVYk+HdvZVG8b5F0xj4RvhouB+eCy8KrdzDJc1RtAX8ILxvx98V1GyCSkN98Cx4z/95/Wn4fj6j6tUEeN4wkFSnw1MJqj5NhBfAuwaUHREUg4lqNMmePVsHll/HFhVfe1t3FwpJI8DXCCquDrCWNN4B6Tb4M3Z98aTPmTvh0YHl18PXw29yZiKejoPvcUD6E74yFBJbVDk6Bb7K8aP/Hb4c/tRzEYIqprPhSxzlf4Uvhb/0Xoig8qnHAJ3lqPMzfDH8XZ4LEpRf2sVdA5/sqPO9Qfop70UJyn+/boaPddT5yrq7VUUvTIVJI7q74MMddXR8NB1eXcYvhBpZm0s2w72/o86HFoKvLau/pYaXzjLMdUJ6y0LwtWV9CIIaXtvA8+G9HHV03u5q+K+yH47U0NoRngPv7KjzHDwTLj0bS1BDazfJJlcnOOostC6ysnCT+q80G/sIvFVgeW09D8FPVT0uoP7VfvAD8NjA8pqmuAN+OcYAjso0RbIZ8DGB5TVNcRO8JMaHY9SXSdfa3eeANJimWBLrA7JFiZwIXye+NMUV8CcxP2SRFjXefok7NRjSGZJlWUPvw2/wtNiQirSoXWyMsR28wR7AzzYM0oXw+Y7yK+CLJGeaoqjyrJSdZJD6Ov4+z5y6NJc0Az7NUecHydIUy+v60KNyQHoM3nKI1y7YCFiq0i7uBvgER52vDdKqWn9djhY1Dn4G3n6Ecqm2rF74dvgoR53S0hQxW9RJAZAGW5bSn58QJA27dQ7uIEedjywEX5NKVxCqsY6y+qA+LxFI4+yZ6oH0trWkNan80jygtIUsc5SflgAsDXgehfdx1KkkTRE76tN+Xue2jnTU0Ru1oIbvpt30bBtKhOp5yaaRkts0lic8V1i6dPcIRx2d/l8Y8XtNNEg7OOo8bl1kmmOKnDsO88CaYzejau0hWZqiL7C83oCH4SeTHvwV2BqqsHRVztSEYOmWF80NeXZT6Hd4KflResE9vCnBOlCyGfDNAstHTVPUDWoQ1t3iW+9WNizvlhfd4aerXd+ThqiMfNR6+9LvOOro5OY5JX2H4+F7HZD+kGzlamMgldWiirQsjcwWFbjmqZJteekJLK9pisvgL6RhKvuciZiwzrWWGapfrPy30kBVcSBIrw0aD3PU0XB6cehntq7rTMf7/2iQlktDVdXJLXlg6VjmiYBn6rWSTRCH6hvJ0hQrpcGq8oidsmHpTP8t8DGO9/vcWt9qabiqPgup1yKyQwvC2tSefZ73SSpNkUJ4PlLorlHZ+446nc8f3fIyywlJhwrTuwVSjBa1ccvSxN0hjjoK5xVrYZMd9V6XbFfgBukixTwGLg8sDam3dZR/wZ6L/dJlin1en8LS+bgpFbz3Ygvzu1J1HKxYNqxGpCmaCEo12rrBorD6LRp8UbpcdR5VWhTW35KlKd6QFqjuM2XzwlpnMxTvSkuUwuG/Xlg6NtPjbT6WFimF/VG6LEvXgn8QGDjMbBukVECFwhpoS+CQatfX2Q1q6H7wENHdrfCr0lKleEB9JyxNneus+VJpsVL9TwI6W65LovWIGl3KtVJaLv7LBwYTFEERFEVQFEERFEVQFEERFEVQFEERFEVQFEERFEVQFEERFFWq/hFgADUMN4RzT6/OAAAAAElFTkSuQmCC">
                <p class="toast_content">已评论</p>
            </div>
        </div>
    </div>

    <div id="js_article" class="rich_media">
        
        <div id="js_top_ad_area" class="top_banner">
 
        </div>
                

        <div class="rich_media_inner">
            <div id="page-content">
                <div id="img-content" class="rich_media_area_primary">
                    <h2 class="rich_media_title" id="activity-name">
                       沃众筹微信平台用户操作帮助指南
                    </h2>
                    <div class="rich_media_meta_list">
                        												<a class="rich_media_meta meta_enterprise_tag" href="https://qy.weixin.qq.com/cgi-bin/wap_vcard?__biz=MzA3MjgxNDIwMg=="><img src="http://mmbiz.qpic.cn/mmbiz/sHibkLymD5JfI1XUv5tdpAZETvKt1zClkU3zlVOHcicRD7Deb5ELUNCcEktFovdZHcaNhPe1AFUSGgmZW6tiaSibnw/0"></a>
						                        <em id="post-date" class="rich_media_meta rich_media_meta_text">2015-07-28</em>

                                                <a class="rich_media_meta rich_media_meta_link rich_media_meta_nickname" href="javascript:void(0);" id="post-user">企业号管理员助手</a>
                        <span class="rich_media_meta rich_media_meta_text rich_media_meta_nickname">企业号管理员助手</span>

                        <div id="js_profile_qrcode" class="profile_container" style="display:none;">
                            <div class="profile_inner">
                                <strong class="profile_nickname">企业号管理员助手</strong>
                                <img class="profile_avatar" id="js_profile_qrcode_img" src="" alt="">

                                <p class="profile_meta">
                                <label class="profile_meta_label">微信号</label>
                                <span class="profile_meta_value"></span>
                                </p>

                                <p class="profile_meta">
                                <label class="profile_meta_label">功能介绍</label>
                                <span class="profile_meta_value">微信企业号版本更新，帮助你更好的了解企业号</span>
                                </p>
                                
                            </div>
                            <span class="profile_arrow_wrp" id="js_profile_arrow_wrp">
                                <i class="profile_arrow arrow_out"></i>
                                <i class="profile_arrow arrow_in"></i>
                            </span>
                        </div>
                    </div>
                                        
                                                            
                                                            
                    
                    <div class="rich_media_content " id="js_content">
                        
                        <p><span style="font-size: 18px;background-color: yellow;color: red;">欢迎您使用沃众筹微信平台，平台正在建设中。。。后续会开放帮助指南！O(∩_∩)O谢谢！！</span></p><p><span style="font-size: 18px;">赶快试试吧~</span></p><p><br/></p><p><span style="font-size: 18px;">如何发起群聊？</span></p><p><span style="font-size: 18px;">方式一：从微信聊天列表进入</span></p><p><img src="http://shp.qpic.cn/mmocbiz/1Pwl8EEt6pnQoxXZEzln4SibaIWZpJyPb3mkdjAMD44d7A7diapqic1icA/"/></p><p><br/></p><p><span style="font-size: 18px;">方式二：从微信通讯录进入</span></p><p><img src="http://shp.qpic.cn/mmocbiz/1Pwl8EEt6pnQoxXZEzln4SibaIWZpJyPbRhqrD4s9iaGkzs6xJGjVZOw/"/></p><p><br/></p>
                    </div>
                    <script type="text/javascript">
                        var first_sceen__time = (+new Date());

                        if ("" == 1 && document.getElementById('js_content'))
                            document.getElementById('js_content').addEventListener("selectstart",function(e){ e.preventDefault(); });

                                        (function(){
                            if (navigator.userAgent.indexOf("WindowsWechat") != -1){
                                var link = document.createElement('link');
                                var head = document.getElementsByTagName('head')[0];
                                link.rel = 'stylesheet';
                                link.type = 'text/css';
                                link.href = "http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/style/page/appmsg/page_mp_article_improve_pc2826cc.css";
                                head.appendChild(link);
                            }
                        })();
                    </script>
                    <link rel="stylesheet" type="text/css" href="http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/style/page/appmsg/page_mp_article_improve_combo29ab01.css">
                                        
                                        
                                        <div class="rich_media_tool" id="js_toobar3">
                                                                    <div id="js_read_area3" class="media_tool_meta tips_global meta_primary" style="display:none;">阅读 <span id="readNum3"></span></div>

                        <span style="display:none;" class="media_tool_meta meta_primary tips_global meta_praise" id="like3">
                            <i class="icon_praise_gray"></i><span class="praise_num" id="likeNum3"></span>
                        </span>

                        <a id="js_report_article3" style="display:none;" class="media_tool_meta tips_global meta_extra" href="javascript:void(0);">举报</a>

                    </div>
                </div>

                <div class="rich_media_area_extra">

                    
                                        <div class="mpda_bottom_container" id="js_bottom_ad_area">
                        
                    </div>

                    
                    <div id="js_iframetest" style="display:none;"></div>

                    
                                    </div>
               
            </div>
            <div id="js_pc_qr_code" class="qr_code_pc_outer" style="display:none;">
                <div class="qr_code_pc_inner">
                    <div class="qr_code_pc">
                        <img id="js_pc_qr_code_img" class="qr_code_pc_img">
                        <p>微信扫一扫<br>关注该公众号</p>
                    </div>
                </div>
            </div>

        </div>
    </div>


        
        <script>window.moon_map = {"appmsg/emotion/caret.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/emotion/caret278965.js","appmsg/emotion/map.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/emotion/map278965.js","appmsg/emotion/textarea.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/emotion/textarea27cdc5.js","appmsg/emotion/nav.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/emotion/nav278965.js","appmsg/emotion/common.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/emotion/common278965.js","appmsg/emotion/slide.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/emotion/slide27cdc5.js","biz_wap/jsapi/cardticket.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_wap/jsapi/cardticket275627.js","pages/report.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/pages/report292ed8.js","pages/music_player.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/pages/music_player298e98.js","pages/loadscript.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/pages/loadscript292ed8.js","appmsg/emotion/dom.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/emotion/dom278965.js","appmsg/emotion/emotion.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/emotion/emotion27f4f1.js","biz_wap/utils/hashrouter.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_wap/utils/hashrouter2805ea.js","a/gotoappdetail.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/a/gotoappdetail2a21d2.js","a/ios.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/a/ios275627.js","a/android.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/a/android275627.js","a/profile.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/a/profile29b1f8.js","a/card.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/a/card29b1f8.js","biz_wap/utils/position.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_wap/utils/position29b1f8.js","appmsg/a_report.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/a_report282222.js","biz_common/utils/monitor.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_common/utils/monitor27f4f1.js","biz_common/utils/report.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_common/utils/report275627.js","biz_common/utils/huatuo.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_common/utils/huatuo293afc.js","biz_common/utils/cookie.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_common/utils/cookie275627.js","pages/voice_component.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/pages/voice_component298e98.js","new_video/ctl.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/new_video/ctl292ed8.js","biz_common/utils/spin.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_common/utils/spin275627.js","biz_wap/jsapi/pay.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_wap/jsapi/pay275627.js","appmsg/reward_entry.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/reward_entry29bb2b.js","appmsg/comment.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/comment29f4e9.js","appmsg/like.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/like29f4e9.js","appmsg/a.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/a29ff2a.js","pages/version4video.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/pages/version4video292ed8.js","biz_wap/utils/storage.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_wap/utils/storage275627.js","biz_common/tmpl.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_common/tmpl275627.js","biz_common/ui/imgonepx.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_common/ui/imgonepx275627.js","biz_common/dom/attr.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_common/dom/attr275627.js","biz_wap/utils/ajax.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_wap/utils/ajax297cdb.js","biz_common/utils/string/html.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_common/utils/string/html29f4e9.js","appmsg/report.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/report29f4e9.js","biz_common/dom/class.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_common/dom/class275627.js","appmsg/report_and_source.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/report_and_source29f4e9.js","appmsg/page_pos.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/page_pos29f4e9.js","appmsg/cdn_speed_report.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/cdn_speed_report275627.js","appmsg/voice.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/voice29ef1e.js","appmsg/qqmusic.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/qqmusic29ef1e.js","appmsg/iframe.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/iframe2989c1.js","appmsg/review_image.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/review_image29d138.js","appmsg/outer_link.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/outer_link275627.js","biz_wap/jsapi/core.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_wap/jsapi/core275627.js","biz_common/dom/event.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_common/dom/event275627.js","appmsg/copyright_report.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/copyright_report2805ea.js","appmsg/pay_for_reading.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/pay_for_reading28f721.js","appmsg/async.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/async2a21d2.js","biz_wap/ui/lazyload_img.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_wap/ui/lazyload_img275627.js","biz_common/log/jserr.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_common/log/jserr2805ea.js","appmsg/share.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/share29bb2b.js","biz_wap/utils/mmversion.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_wap/utils/mmversion275627.js","appmsg/cdn_img_lib.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/cdn_img_lib275627.js","biz_common/utils/url/parse.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_common/utils/url/parse275627.js","biz_wap/utils/device.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_wap/utils/device27f46f.js","biz_wap/jsapi/a8key.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_wap/jsapi/a8key2a0083.js","appmsg/index.js":"http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/index2a26a2.js"};window.moon_crossorigin = true;</script><script type="text/javascript" src="http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_wap/moon275627.js" crossorigin></script>
    <script id="voice_tpl" type="text/html">        
        <span id="voice_main_<#=voiceid#>_<#=posIndex#>" class="db audio_area <#if(!musicSupport){#> unsupport<#}#>">
            <span class="tc tips_global unsupport_tips" <#if(show_not_support!==true){#>style="display:none;"<#}#>>
            当前浏览器不支持播放音乐或语音，请在微信或其他浏览器中播放            </span>
            <span class="audio_wrp db">
                <span id="voice_play_<#=voiceid#>_<#=posIndex#>" class="audio_play_area">
                    <i class="icon_audio_default"></i>
                    <i class="icon_audio_playing"></i>
                    <img src="http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/images/icon/appmsg/audio/icon_audio_unread26f1f1.png" alt="" class="pic_audio_default">
                </span>
                <span class="audio_length tips_global"><#=duration_str#></span>
                <span class="db audio_info_area">
                    <strong class="db audio_title"><#=title#></strong>
                    <span class="audio_source tips_global"><#if(window.nickname){#>来自<#=window.nickname#><#}#></span>
                </span>
                <span id="voice_progress_<#=voiceid#>_<#=posIndex#>" class="progress_bar" style="width:0px;"></span>
            </span>
        </span>
    </script>

    <script id="qqmusic_tpl" type="text/html">        
        <span id="qqmusic_main_<#=comment_id#>_<#=posIndex#>" class="db qqmusic_area <#if(!musicSupport){#> unsupport<#}#>">
            <span class="tc tips_global unsupport_tips" <#if(show_not_support!==true){#>style="display:none;"<#}#>>
            当前浏览器不支持播放音乐或语音，请在微信或其他浏览器中播放            </span>
            <span class="db qqmusic_wrp">
                <span class="db qqmusic_bd">
                    <span id="qqmusic_play_<#=musicid#>_<#=posIndex#>" class="play_area">
                        <i class="icon_qqmusic_switch"></i>
                        <img src="http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/images/icon/appmsg/qqmusic/icon_qqmusic_default.2x26f1f1.png" alt="" class="pic_qqmusic_default">
                        <img src="<#=music_img#>" data-autourl="<#=audiourl#>" data-musicid="<#=musicid#>" class="qqmusic_thumb" alt="">
                    </span>
                                        <a id="qqmusic_home_<#=musicid#>_<#=posIndex#>" href="javascript:void(0);" class="access_area">
                        <span class="qqmusic_songname"><#=music_name#></span>
                        <span class="qqmusic_singername"><#=singer#></span>
                        <span class="qqmusic_source"><img src="http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/images/icon/appmsg/qqmusic/icon_qqmusic_source263724.png" alt=""></span>
                    </a>
                </span>
            </span>       
        </span>
    </script>

    <script id="t_cmt" type="text/html">
        <li class="discuss_item" id="cid<# if (is_from_me == 1) { #><#=my_id#><# } else { #><#=content_id#><# } #>">
            <# if(is_elected == 1){ #>
            <div class="discuss_opr">
                <span class="media_tool_meta tips_global meta_praise js_comment_praise <# if(like_status == 1){ #>praised<# } #>" data-status="<#=like_status#>" data-content-id='<#=content_id#>'>
                    <i class="icon_praise_gray"></i>
                    <span class="praise_num"><# if(like_num_format !== 0){ #><#=like_num_format#> <# } #></span>
                </span>
            </div>
            <# } #>
            <div class="user_info">
                <strong class="nickname"><#=nick_name#><# if(is_from_friend == 1){ #>(朋友)<# } #></strong>
                <img class="avatar" src="<#=logo_url#>">
            </div>
            <div class="discuss_message">
                <span class="discuss_status"><#=status#></span>
                <div class="discuss_message_content">
                <#=content#>
                </div>
            </div>
            <p class="discuss_extra_info">
                <#=time#>               
                <# if (is_from_me == 1) { #>
                <a class="discuss_del js_del" href="javascript:;" data-my-id="<#=my_id#>" data-content-id="<#=content_id#>">删除</a>
                <# } #>
            </p>
            <# if(reply && reply.reply_list && reply.reply_list.length > 0){ #>
                <div class="reply_result">
                    <div class="nickname">作者回复</div>
                    <div class="discuss_message">
                        <div class="discuss_message_content">
                        <#=reply.reply_list[0].content#>
                        </div>
                    </div>
                    <p class="discuss_extra_info"><#=reply.reply_list[0].time#></p>
                </div>
            <# } #>
                
        </li>
    </script>

    <script type="text/html" id="img_copyright_tpl">
        <span class="original_img_wrp">            
            <span class="tips_global">来自: <#=source_nickname#></span>
        </span>    
    </script>

  <script id="t_ad" type="text/html">
    <div class="rich_media_extra" id="gdt_area">
        <# if(pos_type==0){ #>
        <div class="rich_tips with_line title_tips">
            <span class="tips">广告</span>
        </div>
        <# } #>
        <div class="js_ad_link extra_link" data-type="<#=type#>" data-ticket="<#=ticket#>" data-url="<#=url#>" data-rl="<#=rl#>"  data-aid="<#=aid#>" data-pt="<#=pt#>" data-tid="<#=traceid#>" data-gid="<#=group_id#>" data-apurl="<#=apurl#>">




            <# if(pt==1){ #>
            <#=hint_txt#>
            <img class="icon_arrow_gray" src="http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/images/icon/common/icon_arrow_gray1ef6d4.png">
            <img class="icon_loading_white icon_after" style="display:none;" id="loading_<#=traceid#>" src="http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/images/icon/common/icon_loading_white2805ea.gif">
            <# }else if(pt==2){ #>
            
            <# if (logo.indexOf("http://mmsns.qpic.cn/") == 0){ #>
            <div class="brand_logo"><img src="<#=logo#>" alt="logo图片"></div>
            <# } #>
            <img class="appmsg_banner" src="<#=image_url#>">
            <# if(watermark_type!=0){ #><i class="promotion_tag"><# if(watermark_type==1){ #>商品推广<# }else if (watermark_type==2){ #>活动推广<# }else if (watermark_type==3){ #>应用下载<# } #></i><# } #>
            <# }else if(pt==7){ #>
            
            <div class="preview_group preview_card">
                <div class="preview_group_inner card_inner">
                    <div class="preview_group_info">
                        <strong class="preview_group_title2"><#=hint_txt#></strong>
                        <div class="preview_group_desc"><#=ad_desc#></div>
                        <img src="<#=image_url#>" alt="" class="preview_card_avatar">
                    </div>
                </div>
            </div>
            <# }else if(pt==100){ #>
            <div class="preview_group">
                <div class="preview_group_inner">
                    <div class="preview_group_info append_btn">
                        <strong class="preview_group_title"><#=biz_info.nick_name#></strong>
                        <div class="preview_group_desc"><#=hint_txt#></div>
                        <# if(!!biz_info.head_img){ #>
                        <img src="<#=biz_info.head_img#>" alt="" class="preview_group_avatar br_radius">
                        <# }else{ #>
                        <img class="preview_group_avatar br_radius" src="http://mmbiz.qpic.cn/mmbiz/a5icZrUmbV8p5jb6RZ8aYfjfS2AVle8URwBt8QIu6XbGewB9wiaWYWkPwq4R7pfdsFibuLkic16UcxDSNYtB8HnC1Q/0" alt="<#=biz_info.nick_name#>">
                        <# } #>                                 
                    </div>
                    <div class="preview_group_opr">
                        <a id="js_view_profile_<#=pos_type#>" <# if(biz_info.is_subscribed == 0){ #>style="display:none"<# } #> class="btn btn_inline btn_primary btn_line js_ad_btn" href="javascript:void(0);">查看</a>
                        <a id="js_add_contact_<#=pos_type#>" data-url="<#=url#>" data-type="<#=type#>" data-tid="<#=traceid#>" data-rl="<#=rl#>" <# if(biz_info.is_subscribed ==1){ #>style="display:none"<# } #> class="btn btn_inline btn_line  btn_primary js_ad_btn" href="javascript:void(0);">关注</a>
                    </div>
                </div>
            </div>
            <# }else if(pt==102){ #>
            <div class="preview_group">
                <div class="preview_group_inner">
                    <div class="preview_group_info append_btn">
                        <strong class="preview_group_title"><#=app_info.app_name#></strong>
                        <div class="preview_group_desc"><#=hint_txt#></div>
                        <img src="<#=app_info.icon_url#>" alt="" class="preview_group_avatar br_radius">
                    </div>
                    <div class="preview_group_opr">
                        <a id="js_app_action_<#=pos_type#>" class="btn btn_inline btn_primary js_ad_btn btn_download" href="javascript:void(0);">下载</a>
                    </div>
                </div>
            </div>
            <# }else if(pt==101){ #>
            <div class="preview_group preview_card">
                <div class="preview_group_inner card_inner">                            
                    <div class="preview_group_info append_btn">
                        <strong class="preview_group_title"><#=app_info.app_name#></strong>
                        <div class="preview_group_desc"><#=hint_txt#></div>
                        <img src="<#=app_info.icon_url#>" alt="" class="preview_card_avatar">                               
                    </div>
                    <div class="preview_group_opr">
                        <a href="javascript:void(0);" id="js_app_action_<#=pos_type#>" class="btn btn_inline btn_primary js_ad_btn">下载</a>
                    </div>
                </div>                        
            </div>
            <# }else if(pt==103||pt==104){ #>
            <div class="preview_group obvious_app">
                <div class="preview_group_inner">
                    <div class="pic_app">
                        <img src="<#=image_url#>" alt="">
                    </div>
                    <div class="info_app">
                        <p class="name_app"><#=app_info.app_name#></p>
                        <# if(pt==103){ #>
                        <p class="profile_app" style="display:none;"><span class="fun_exp"><#=app_info._category#></span><em>|</em><span class="compacity"><#=app_info._app_size#></span></p>
                        <# } else if(pt==104){ #>
                        <p class="profile_app" style="display:none;"><span class="fun_exp"><#=app_info._app_size#></span><em>|</em><span class="compacity"><#=app_info._down_count#></span></p>
                        <# } #>
                        
                        <p class="grade_app" id="js_app_rating_<#=pos_type#>">
                            
                            <span class="js_stars stars" style="display:none;"></span>
                            
                            <span class="js_scores scores"></span>
                        </p>
                        <div class="dm_app">
                            <a href="javascript:void(0);" id="js_appdetail_action_<#=pos_type#>" class="ad_btn btn_download js_ad_btn">下载</a>
                            <p class="extra_info">来自<# if(pt==103){ #>App Store<# }else{ #>腾讯应用宝<# } #></p>
                        </div>
                    </div>
                </div>            
            </div>
            <# }else if(pt==105){ #>
            <div class="mpda_card cardticket">
                <div class="cardticket_hd cell">
                    <div class="cell_hd">
                        <span class="radius_avatar">
                            <img class="avatar" src="<#=card_info.card_logo_url#>">
                        </span>
                    </div>
                    <div class="cell_bd cell_primary"><#=card_info.card_title#></div>
                    <div class="cell_ft">
                        <a href="javascript:void(0);"  class="btn btn_plain_primary btn_inline js_ad_btn" id="js_card_action_<#=pos_type#>">领券</a>
                    </div>
                </div>
                <div class="cardticket_ft">
                    <div class="cardticket_theme"></div>
                    <p class="cardticket_source tips_global"><#=card_info.card_brand_name#></p>
                </div>
            </div>
            <# } #>
        </div>
    </div>
  </script>
  <script type="text/javascript">
      var not_in_mm_css = "http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/style/page/appmsg/not_in_mm2637ae.css";
      var windowwx_css = "http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/style/page/appmsg/page_mp_article_improve_pc2826cc.css";
      var tid = "";
      var aid = "";
      var clientversion = "0";
      var appuin = "MzA3ODc4NjkyMw==";

      var source = "";
      var scene = 75;
      
      var itemidx = "";
      var nickname = "企业号管理员助手";
      var ct = "1438055448";
      var user_name = "gh_22bea6f8040e";
      var user_name_new = "";
      var fakeid   = "";
      var version   = "";
      var is_limit_user   = "0";
      var msg_title = "已开通微信企业号群聊功能";
      var msg_desc = "同事之间可直接聊天，赶快试试吧！";
      var msg_cdn_url = "http://mmbiz.qpic.cn/mmbiz/IZC4HgibyP1SQXhQCBeU3micLTzPicsaBIWjSYHfOaa7TVZzlUPnz6g2ViaNONNcDZnicnay9bEPqr7NgXvBZMKfa1g/0?wx_fmt=jpeg";
      var msg_link = "http://mp.weixin.qq.com/s?__biz=MzA3ODc4NjkyMw==&amp;mid=212369325&amp;idx=1&amp;sn=155e3d9cb2a79383b28602197339272c#rd";
      var user_uin = "0"*1;
      var msg_source_url = '';
      var img_format = 'jpeg';
      var srcid = '';
      var networkType;
      var appmsgid = '' || '212369325';
      var comment_id = "0" * 1;
      var comment_enabled = "" * 1;
      var is_need_reward = "0" * 1;
      var is_https_res = ("" * 1) && (location.protocol == "https:");

      var devicetype = "";
      var source_username = "";
      var reprint_ticket = "";
      var source_mid = "";
      var source_idx = "";

      var show_comment = "";
      var __appmsgCgiData = {
            can_use_page : "0"*1,
            is_wxg_stuff_uin : "0"*1,
            card_pos : "",
            copyright_stat : "0",
            hd_head_img : "http://wx.qlogo.cn/mmhead/Q3auHgzwzM7AQIOSv0icnL1GUb4xzGI4FHUOsMV8DOJ0lic2WMpqhuDg/0"||(window.location.protocol+"//"+window.location.host + "http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/images/pic/appmsg/pic_rumor_link.2x264e76.jpg")
      };
      var _empty_v = "http://res.wx.qq.com/mmbizwap/zh_CN/htmledition/images/pic/pages/voice/empty26f1f1.mp3";

      var copyright_stat = "0" * 1;

      var pay_fee = "" * 1; // 付费阅读费用
      var pay_timestamp = "";
      var need_pay = "" * 1;

      var need_report_cost = "0" * 1;
      
            window.wxtoken = "";
        </script>

  <script type="text/javascript">
      seajs.use('appmsg/index.js');
  </script>


    </body>
</html>

 

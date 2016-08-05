<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>商品管理>>商品列表</title>
<link href="/core-admin/resources/css/common.css" rel="stylesheet" type="text/css"/>
<link href="/core-admin/resources/css/goodsStyle.css" rel="stylesheet" type="text/css"/>
<script src="/core-admin/resources/js/jquery.min.js" type="text/javascript"></script>
<script src="/core-admin/resources/js/base_v1.js" type="text/javascript"></script>
<!--[if IE 6]>
<SCRIPT src="http://d1.lashouimg.com/static/js/release/iepng.js"></SCRIPT>
<script type="text/javascript">
	DD_belatedPNG.fix('.iepng');
</script>
<![endif]-->
</head>
<body>
<%@ include file="/WEB-INF/view/common/header.jsp"%>
  <div class="w">
    <ul class="nav-subul">
      <li class="hover"><a href="#">商品管理>>商品列表</a></li>
    </ul>
  </div>
</div>
<!--nav end-->
<!--content-->
<div class="cont">
  <div class="w">
    <!--三级-->
    <!--<div class="mag-navbox cf">
			<ul class="mag-navlist">
				<li class="hover"><a href="#">商品列表</a></li>
				<li class=" noline"><a href="#">商品分类列表</a></li>
				<li class=" noline"><a href="#">属性列表</a></li>
			</ul>
		</div>-->
    <div class="cf">
      <ul class="cfr mode-filter">
        <li><strong>商品名称： </strong></li>
        <li>
          <select class="" style="width:120px;">
            <option value="" selected="true">1</option>
            <option value="">2</option>
          </select>
        </li>
        <li>商品分类： </li>
        <li>
          <select class="" style="width:150px;">
            <option value="0" selected="true">请选择</option>
            <option value="1">正常</option>
            <option value="2">停用</option>
            <option value="3">删除</option>
          </select>
        </li>
        <li>
          <input type="text" class="text-input" value="" placeholder="请输入">
        </li>
        <li>
          <input type="button" value="搜索" tabindex="12" class="export">
        </li>
      </ul>
    </div>
    <!-- 添加商品 -->
    <div class="addGoods"> <a href="#" class="l add-export"><i class="ui-icon"></i>添加商品</a> </div>
    <!--内容-->
    <div class="view-list">
      <table width="100%" class="ui-tab">
        <tbody>
          <tr>
            <th>商品ID</th>
            <th>商品名称</th>
            <th>商品分类</th>
            <th>排序</th>
            <th>状态</th>
            <th>操作</th>
          </tr>
          <tr>
            <td class="noline">1000000</td>
            <td>男士经典弹性棉免烫商务长袖衬衫店</td>
            <td>西服正装/衬衫/长袖衬衫</td>
            <td><input type="text" value="序号" class="" size="5"/></td>
            <td>正常</td>
            <td><p><span class="spanUnderline">查看详情</span> <span style="color:#999999;"> | </span> <span class="spanUnderline">冻结</span> <span style="color:#999999;"> | </span> <span class="spanUnderline">删除</span> </p></td>
          </tr>
			<tr>
            <td class="noline">1000000</td>
            <td>男士经典弹性棉免烫商务长袖衬衫店</td>
            <td>西服正装/衬衫/长袖衬衫</td>
            <td><input type="text" value="序号" class="" size="5"/></td>
            <td>正常</td>
            <td><p><span class="spanUnderline">查看详情</span> <span style="color:#999999;"> | </span> <span class="spanUnderline">冻结</span> <span style="color:#999999;"> | </span> <span class="spanUnderline">删除</span> </p></td>
          </tr>
          <tr>
            <td class="noline">1000000</td>
            <td>男士经典弹性棉免烫商务长袖衬衫店</td>
            <td>西服正装/衬衫/长袖衬衫</td>
            <td><input type="text" value="序号" class="" size="5"/></td>
            <td>正常</td>
            <td><p><span class="spanUnderline">查看详情</span> <span style="color:#999999;"> | </span> <span class="spanUnderline">冻结</span> <span style="color:#999999;"> | </span> <span class="spanUnderline">删除</span> </p></td>
          </tr>
          <tr>
            <td class="noline">1000000</td>
            <td>男士经典弹性棉免烫商务长袖衬衫店</td>
            <td>西服正装/衬衫/长袖衬衫</td>
            <td><input type="text" value="序号" class="" size="5"/></td>
            <td>正常</td>
            <td><p><span class="spanUnderline">查看详情</span> <span style="color:#999999;"> | </span> <span class="spanUnderline">冻结</span> <span style="color:#999999;"> | </span> <span class="spanUnderline">删除</span> </p></td>
          </tr>
          <tr>
            <td class="noline">1000000</td>
            <td>男士经典弹性棉免烫商务长袖衬衫店</td>
            <td>西服正装/衬衫/长袖衬衫</td>
            <td><input type="text" value="序号" class="" size="5"/></td>
            <td>正常</td>
            <td><p><span class="spanUnderline">查看详情</span> <span style="color:#999999;"> | </span> <span class="spanUnderline">冻结</span> <span style="color:#999999;"> | </span> <span class="spanUnderline">删除</span> </p></td>
          </tr>
          <tr>
            <td class="noline">1000000</td>
            <td>男士经典弹性棉免烫商务长袖衬衫店</td>
            <td>西服正装/衬衫/长袖衬衫</td>
            <td><input type="text" value="序号" class="" size="5"/></td>
            <td>正常</td>
            <td><p><span class="spanUnderline">查看详情</span> <span style="color:#999999;"> | </span> <span class="spanUnderline">冻结</span> <span style="color:#999999;"> | </span> <span class="spanUnderline">删除</span> </p></td>
          </tr>
        </tbody>
      </table>
    </div>
    <!--内容 end-->
    <!--分页-->
    <div class="page"> <span class="page_text"> 88 条记录</span><a class="pageup pageup-dis" href="javascript:void(0)" title="上一页"><em></em>上一页</a> <a class="current" href="javascript:void(0)">1</a><a href="/page2">2</a><a href="/page3">3</a><a href="/page4">4</a><a href="/page5">5</a> <span>...</span> <a href="/page207">207</a> <a class="pagedown" href="/page2" title="下一页">下一页<em></em></a> </div>
    <!--分页 end-->
  </div>
</div>
<!--content end-->
<!--footer-->
<div class="foot">
  <div class="w">
    <p class="copyright">©&nbsp;&nbsp;2014&nbsp;&nbsp;北京拉手网络技术有限公司&nbsp;&nbsp;LaShou.com&nbsp;&nbsp;京ICP证100571号&nbsp;&nbsp;京ICP备11004895号&nbsp;&nbsp;京公网安备110105001181号</p>
  </div>
</div>
<!--footer end-->
</body>
</html>


</body>
</html>

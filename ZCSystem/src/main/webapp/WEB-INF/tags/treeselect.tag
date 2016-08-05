<%@ tag language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" isELIgnored="false"%>
<%@ include file="/WEB-INF/views/sys/includes/taglib.jsp"%>
<%@ attribute name="id" type="java.lang.String" required="true" description="编号"%>
<%@ attribute name="name" type="java.lang.String" required="true" description="隐藏域名称（ID）"%>
<%@ attribute name="value" type="java.lang.String" required="true" description="隐藏域值（ID）"%>
<%@ attribute name="labelName" type="java.lang.String" required="true" description="输入框名称（Name）"%>
<%@ attribute name="labelValue" type="java.lang.String" required="true" description="输入框值（Name）"%>
<%@ attribute name="title" type="java.lang.String" required="true" description="选择框标题"%>
<%@ attribute name="url" type="java.lang.String" required="true" description="树结构数据地址"%>
<%@ attribute name="checked" type="java.lang.Boolean" required="false" description="是否显示复选框"%>
<%@ attribute name="extId" type="java.lang.String" required="false" description="排除掉的编号（不能选择的编号）"%>
<%@ attribute name="notAllowSelectRoot" type="java.lang.Boolean" required="false" description="不允许选择根节点"%>
<%@ attribute name="notAllowSelectParent" type="java.lang.Boolean" required="false" description="不允许选择父节点"%>
<%@ attribute name="module" type="java.lang.String" required="false" description="过滤栏目模型（只显示指定模型，仅针对CMS的Category树）"%>
<%@ attribute name="selectScopeModule" type="java.lang.Boolean" required="false" description="选择范围内的模型（控制不能选择公共模型，不能选择本栏目外的模型）（仅针对CMS的Category树）"%>
<%@ attribute name="allowClear" type="java.lang.Boolean" required="false" description="是否允许清除"%>
<%@ attribute name="cssClass" type="java.lang.String" required="false" description="css样式"%>
<%@ attribute name="cssStyle" type="java.lang.String" required="false" description="css样式"%>
<%@ attribute name="disabled" type="java.lang.String" required="false" description="是否限制选择，如果限制，设置为disabled"%>
<%@ attribute name="nodesLevel" type="java.lang.String" required="false" description="菜单展开层数"%>
<%@ attribute name="nameLevel" type="java.lang.String" required="false" description="返回名称关联级别"%>
<%@ attribute name="parentCtr" type="java.lang.String" required="false" description="父级节点"%>
<%@ attribute name="treetype" type="java.lang.String" required="true" description="类型"%>
<div class="input-append">
	<input id="${id}Id" name="${name}" class="${cssClass}" type="hidden" value="${value}"${disabled eq 'true' ? ' disabled=\'disabled\'' : ''}/>
	<input id="${id}Name" name="${labelName}" readonly="readonly" type="text" value="${labelValue}" maxlength="50"${disabled eq "true"? " disabled=\"disabled\"":""}"
		class="${cssClass}" style="${cssStyle}"/><a id="${id}Button" href="javascript:" class="btn${disabled eq 'true' ? ' disabled' : ''}"><i class="icon-search"></i></a>&nbsp;&nbsp;
</div><script type="text/javascript">
	$("#${id}Button").click(function(){
		// 是否限制选择，如果限制，设置为disabled
		if ($("#${id}Id").attr("disabled")){
			return true;
		}
		var orgCodeUrl ="";
		var parentIds = "${parentCtr}";
		var treetype="${treetype}";
		//alert(treetype);
		//alert("${url}");
		if(parentIds!=""){
			 var pInput = $("#"+parentIds+"Id"); 
			 if(pInput.length>0 && pInput.val()!=""){
				 orgCodeUrl ="?orgCode="+pInput.val();
			 }
		}
		
        var nameLevel = ${nameLevel eq null ? "1" : nameLevel};
		// 正常打开	
		top.$.jBox.open("iframe:${ctx}/tag/treeselect?url="+encodeURIComponent("${url}"+orgCodeUrl)+"&treetype="+treetype+"&module=${module}&checked=${checked}&extId=${extId}&nodesLevel=${nodesLevel}&selectIds="+$("#${id}Id").val(), "选择${title}", 300, 420, {
			buttons:{"确定":"ok", ${allowClear?"\"清除\":\"clear\", ":""}"关闭":true}, submit:function(v, h, f){
				if (v=="ok"){
					var tree = h.find("iframe")[0].contentWindow.tree;//h.find("iframe").contents();
					var ids = [], names = [], nodes = [];
					if ("${checked}" == "true"){
						nodes = tree.getCheckedNodes(true);
					}else{
						nodes = tree.getSelectedNodes();
					}
					for(var i=0; i<nodes.length; i++) {//<c:if test="${checked}">
						
						if (nodes[i].isParent){
							continue; // 如果为复选框选择，则过滤掉父节点
						}//</c:if><c:if test="${notAllowSelectRoot}">
						//</c:if><c:if test="${notAllowSelectParent}">
						//</c:if><c:if test="${not empty module && selectScopeModule}">
						if (nodes[i].module == ""){
							top.$.jBox.tip("不能选择公共模型（"+nodes[i].name+"）请重新选择。");
							return false;
						}else if (nodes[i].module != "${module}"){
							top.$.jBox.tip("不能选择当前栏目以外的栏目模型，请重新选择。");
							return false;
						}//</c:if>
						if(treetype == 1) {//如果是供应商
							if (nodes[i].level == 0 || nodes[i].level == 1){
								top.$.jBox.tip("不能选择根节点（"+nodes[i].name+"）请重新选择。");
								return false;
							}
							if (nodes[i].isParent){
								top.$.jBox.tip("不能选择父节点（"+nodes[i].name+"）请重新选择。");
								return false;
							}
						} 
						ids.push(nodes[i].id);
                        var t_node = nodes[i];
                        var t_name = "";
                        var name_l = 0;
                        do{
                            name_l++;
                            t_name = t_node.name + " " + t_name;
                            t_node = t_node.getParentNode();
                        }while(name_l < nameLevel);
						names.push(t_name);//<c:if test="${!checked}">
						break; // 如果为非复选框选择，则返回第一个选择  </c:if>
					}
					$("#${id}Id").val(ids);
					$("#${id}Name").val(names);
				}//<c:if test="${allowClear}">
				else if (v=="clear"){
					$("#${id}Id").val("");
					$("#${id}Name").val("");
                }//</c:if>
			}, loaded:function(h){
				$(".jbox-content", top.document).css("overflow-y","hidden");
			}
		});
	});
</script>
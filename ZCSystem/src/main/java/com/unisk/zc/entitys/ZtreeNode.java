package com.unisk.zc.entitys;

import java.io.Serializable;

/**
 * 
 * Title: Ztree菜单树实体封装类<br>
 * Description: <br>
 * Date: 2016年1月18日 <br>
 * 
 * @author bang
 */
public class ZtreeNode extends BaseQuery<ZtreeNode> implements Serializable {

	private static final long serialVersionUID = 884277287916347191L;

	private String id;// 节点id
	private String pId;// 父节点id
	private String name;// 节点名称
	private String isParent;// 是否是父节点
	private String open;// 节点开闭状态 true/false
	private String index;// 获取 treeNode 节点在同级节点中的位置。
	private String url;// 节点对应要访问的url
	private String target;// 设置点击节点后在何处打开 url。[treeNode.url 存在时有效]同超链接 target 属性: "_blank", "_self" 或 其他指定窗口名称,省略此属性，则默认为 "_blank"
	private String nocheck;// 强制节点的 checkBox / radio 的 半勾选状态;true 表示节点的输入框 强行设置为半勾选;false 表示节点的输入框 根据 zTree 的规则自动计算半勾选状态
	private String iconOpen;// 节点打开时显示图标
	private String iconClose;// 节点关闭时显示图标
	private String icon;// 节点图标
	private String iconSkin;// 配合 css 实现自定义图标
	private String checked;// 是否被选中 true/false
	private String halfCheck;// 强制节点的 checkBox / radio 的 半勾选状态。[setting.check.enable = true & treeNode.nocheck = false 时有效]

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsParent() {
		return isParent;
	}

	public void setIsParent(String isParent) {
		this.isParent = isParent;
	}

	public String getOpen() {
		return open;
	}

	public void setOpen(String open) {
		this.open = open;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getNocheck() {
		return nocheck;
	}

	public void setNocheck(String nocheck) {
		this.nocheck = nocheck;
	}

	public String getIconOpen() {
		return iconOpen;
	}

	public void setIconOpen(String iconOpen) {
		this.iconOpen = iconOpen;
	}

	public String getIconClose() {
		return iconClose;
	}

	public void setIconClose(String iconClose) {
		this.iconClose = iconClose;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getIconSkin() {
		return iconSkin;
	}

	public void setIconSkin(String iconSkin) {
		this.iconSkin = iconSkin;
	}

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	public String getHalfCheck() {
		return halfCheck;
	}

	public void setHalfCheck(String halfCheck) {
		this.halfCheck = halfCheck;
	}

}

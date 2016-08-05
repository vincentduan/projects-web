package com.unisk.zc.core.support;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.unisk.zc.entitys.UniskUser;

/**
 * mybatis分页查询封装类
 * 
 * @Description:
 * @author shijingbang
 * @Date 2015年12月22日
 * @param <E>
 */
public class Page<E> implements java.io.Serializable {

	private static final long serialVersionUID = 7995858305633519660L;
	private int maxNum = 10;// Integer.valueOf(Global.getConfig("page.pageSize")).intValue();// 每页显示最大记录数，默认30
	private int totalPage;// 总页数
	private int totalCount;// 总记录数
	private int startNum;// 开始记录数
	private int currentPage = 1;// 当前页
	private List<E> data = Collections.emptyList();// 业务数据集合
	private int first;
	private int last;
	private int prev;
	private int next;
	private final String funcName = "page";
	private boolean firstPage;
	private boolean lastPage;
	private final int length = 8;
	private final int slider = 1;
	private final Map<String, Object> params = new HashMap<String, Object>();

	public int getStartNum() {
		startNum = (getCurrentPage() - 1) * this.getMaxNum();
		if (startNum < 0) {
			startNum = 0;
		}
		return startNum;
	}

	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}

	public int getMaxNum() {
		return maxNum;
	}

	public void setMaxNum(int maxNum) {
		this.maxNum = maxNum;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		totalPage = (int) Math.ceil(totalCount * 1.0 / maxNum);
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getCurrentPage() {
		if (currentPage <= 0)
			currentPage = 1;
		if (currentPage > getTotalPage())
			currentPage = getTotalPage();
		return currentPage;
	}

	public List<E> getData() {
		return data;
	}

	public void setData(List<E> data) {
		this.data = data;
	}

	public void initialize() {
		this.first = 1;

		this.last = ((int) (this.totalCount / (this.maxNum < 1 ? 20 : this.maxNum) + this.first - 1L));
		if ((this.totalCount % this.maxNum != 0L) || (this.last == 0)) {
			this.last += 1;
		}
		if (this.last < this.first) {
			this.last = this.first;
		}
		if (this.currentPage <= 1) {
			this.currentPage = this.first;
			this.firstPage = true;
		}
		if (this.currentPage >= this.last) {
			this.currentPage = this.last;
			this.lastPage = true;
		}
		if (this.currentPage < this.last - 1) {
			this.next = (this.currentPage + 1);
		} else {
			this.next = this.last;
		}
		if (this.currentPage > 1) {
			this.prev = (this.currentPage - 1);
		} else {
			this.prev = this.first;
		}
		if (this.currentPage < this.first) {
			this.currentPage = this.first;
		}
		if (this.currentPage > this.last) {
			this.currentPage = this.last;
		}
	}

	public String getPageHtml() {
		initialize();

		StringBuilder sb = new StringBuilder();
		if (this.currentPage == this.first) {
			sb.append("<li class=\"disabled\"><a href=\"javascript:\">&#171; 上一页</a></li>\n");
		} else {
			sb.append("<li><a href=\"javascript:\" onclick=\"" + this.funcName + "(" + this.prev + "," + this.maxNum + ");\">&#171; 上一页</a></li>\n");
		}
		int begin = this.currentPage - this.length / 2;
		if (begin < this.first) {
			begin = this.first;
		}
		int end = begin + this.length - 1;
		if (end >= this.last) {
			end = this.last;
			begin = end - this.length + 1;
			if (begin < this.first) {
				begin = this.first;
			}
		}
		if (begin > this.first) {
			int i = 0;
			for (i = this.first; (i < this.first + this.slider) && (i < begin); i++) {
				sb.append("<li><a href=\"javascript:\" onclick=\"" + this.funcName + "(" + i + "," + this.maxNum + ");\">" + (i + 1 - this.first) + "</a></li>\n");
			}
			if (i < begin) {
				sb.append("<li class=\"disabled\"><a href=\"javascript:\">...</a></li>\n");
			}
		}
		for (int i = begin; i <= end; i++) {
			if (i == this.currentPage) {
				sb.append("<li class=\"active\"><a href=\"javascript:\">" + (i + 1 - this.first) + "</a></li>\n");
			} else {
				sb.append("<li><a href=\"javascript:\" onclick=\"" + this.funcName + "(" + i + "," + this.maxNum + ");\">" + (i + 1 - this.first) + "</a></li>\n");
			}
		}
		if (this.last - end > this.slider) {
			sb.append("<li class=\"disabled\"><a href=\"javascript:\">...</a></li>\n");
			end = this.last - this.slider;
		}
		for (int i = end + 1; i <= this.last; i++) {
			sb.append("<li><a href=\"javascript:\" onclick=\"" + this.funcName + "(" + i + "," + this.maxNum + ");\">" + (i + 1 - this.first) + "</a></li>\n");
		}
		if (this.currentPage == this.last) {
			sb.append("<li class=\"disabled\"><a href=\"javascript:\">下一页 &#187;</a></li>\n");
		} else {
			sb.append("<li><a href=\"javascript:\" onclick=\"" + this.funcName + "(" + this.next + "," + this.maxNum + ");\">" + "下一页 &#187;</a></li>\n");
		}
		sb.append("<li class=\"disabled controls\"><a href=\"javascript:\">当前 ");
		sb.append("<input type=\"text\" value=\"" + this.currentPage + "\" onkeypress=\"var e=window.event||this;var c=e.keyCode||e.which;if(c==13)");
		sb.append(this.funcName + "(this.value," + this.maxNum + ");\" onclick=\"this.select();\"/> / ");
		sb.append("<input type=\"text\" value=\"" + this.maxNum + "\" onkeypress=\"var e=window.event||this;var c=e.keyCode||e.which;if(c==13)");
		sb.append(this.funcName + "(" + this.currentPage + ",this.value);\" onclick=\"this.select();\"/> 条，");
		sb.append("共 " + this.totalCount + " 条</a><li>\n");

		sb.insert(0, "<ul>\n").append("</ul>\n");

		sb.append("<div style=\"clear:both;\"></div>");

		return sb.toString();
	}

	public Map<String, Object> getParams() {
		return params;
	}

	@Override
	public String toString() {
		return "Page [maxNum=" + maxNum + ", totalPage=" + totalPage + ", totalCount=" + totalCount + ", startNum=" + startNum + ", currentPage=" + currentPage + ", data=" + data
				+ ", first=" + first + ", last=" + last + ", prev=" + prev + ", next=" + next + ", funcName=" + funcName + ", firstPage=" + firstPage + ", lastPage=" + lastPage
				+ ", length=" + length + ", slider=" + slider + "]";
	}

	public static void main(String args[]) {
		Page<UniskUser> page = new Page<UniskUser>();
		page.setTotalCount(111);
		page.setCurrentPage(1);
		System.out.println(page.getTotalPage());
	}

}
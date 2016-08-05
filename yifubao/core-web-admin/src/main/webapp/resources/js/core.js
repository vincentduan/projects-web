$(document).ready(function() {
    $('#datepicker-example1-1').Zebra_DatePicker();
    $('#datepicker-example1-2').Zebra_DatePicker();
});

/*
 * 删除某元素之后的所有同级元素
 */
function removeAllNextElement(current){
	if(current.nextElementSibling != null){
		current.nextElementSibling.remove();
		removeAllNextElement(current);
	}
}
/*
 * 根据商品子类别数据生成select
 */
function createSelect(data){
	select = document.createElement("select");
	select.setAttribute("onchange", "change(this)");
	select.options.add(new Option("请选择","0"));
	for ( var i in data) {
		select.options.add(new Option(data[i]["name"],data[i]["id"]));
	}
	return select;
}
/*
 * 全选/全不选属性
 */
function changeClick(flag, name){
	checkboxs = document.getElementsByName(name);
	for (var i = 0; i < checkboxs.length; i++) {
		if (checkboxs[i].checked != flag) {
			$(checkboxs[i]).click();
		}
	}
}
/*
 * 清空表格
 */
function clearTable(tableId){
	table = document.getElementById(tableId);
    rowNum=table.rows.length;
    while(rowNum != 0)
    {
    	table.deleteRow(0);
        rowNum -= 1;
    }
}
package com.efubao.core.common.util;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * 生成EXCEL的工具类
 * 
 */
public class ExcelUtils {

    /**
     * 生成EXCEL的通用方法
     * 
     * @param filePath 生成EXCEL的地址
     * @param clazz 绑定数据的类型
     * @param list 数据列表
     * @param map EXCEL表头信息
     * @throws Exception
     */
    public static HSSFWorkbook generateExcel(Class<?> clazz, List<?> list,
            Map<String, ExcelTitle> map) throws Exception {
        HSSFWorkbook wb = new HSSFWorkbook();
        CreationHelper helper = wb.getCreationHelper();
        HSSFSheet sheet = wb.createSheet("sheet1");
        HSSFRow row = sheet.createRow(0);
        CellStyle cellStyle = ExcelUtils.createStyleCell(wb);
        cellStyle.setFont(ExcelUtils.createFonts(wb));
        int i = 0;
        for (String attr : map.keySet()) {
            sheet.setColumnWidth(i, 5000);
            ExcelTitle excelTitle = map.get(attr);
            int order = excelTitle.getOrder();
            String title = excelTitle.getTitle();
            HSSFCell cell = row.createCell(order);
            cellStyle = ExcelUtils.setCellStyleAlignment(cellStyle, CellStyle.ALIGN_CENTER,
                    CellStyle.VERTICAL_CENTER);
            cellStyle.setWrapText(true);    
            cell.setCellStyle(cellStyle);
            cell.setCellValue(title);
            i++;
        }
        int rowNum = 1;
        if (list != null) {
            for (Object obj : list) {
                row = sheet.createRow(rowNum);
                for (String attr : map.keySet()) {
                    ExcelTitle excelTitle = map.get(attr);
                    int order = excelTitle.getOrder();
                    Class<?> type = excelTitle.getType();
                    String getMethod = "get" + attr.substring(0, 1).toUpperCase()
                            + attr.substring(1);
                    Method method = clazz.getMethod(getMethod, new Class[] {});
                    Object value = method.invoke(obj, new Object[] {});
                    HSSFCell cell = row.createCell(order);
                    if (value != null) {
                        if (Double.class.equals(type)) {
                            cellStyle = ExcelUtils.setCellStyleAlignment(cellStyle,
                                    CellStyle.ALIGN_RIGHT, CellStyle.VERTICAL_CENTER);
                            cellStyle = ExcelUtils.setCellFormat(helper, cellStyle, "#,##0.00");
                            cell.setCellStyle(cellStyle);
                            double doubleValue = Double.valueOf(value.toString());
                            cell.setCellValue(doubleValue);
                        } else if (Long.class.equals(type)) {
                            cellStyle = ExcelUtils.setCellStyleAlignment(cellStyle,
                                    CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER);
                            cell.setCellStyle(cellStyle);
                            long longValue = Long.valueOf(value.toString());
                            cell.setCellValue(longValue);
                        } else if (String.class.equals(type)) {
                            cellStyle.setWrapText(true);   
                            cell.setCellStyle(cellStyle);
                            cell.setCellValue(new HSSFRichTextString(value.toString()));
                        } else if (Date.class.equals(type)) {
                            // TODO 处理时间
                        	SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            String ctime = format.format(value); 
                        	cell.setCellValue(ctime);
                        }
                        else if (BigDecimal.class.equals(type)) {
                        	BigDecimal bigDecimal=(BigDecimal) value;
                        	String bigDecimalValue = bigDecimal.toString();
                        	cell.setCellValue(bigDecimalValue);
                        }else if(Integer.class.equals(type)){
                        	if(value != null){
                        	 	cell.setCellValue(Integer.parseInt((value.toString())));
                        	}
                        }
                    }
                }
                rowNum++;
            }
        }
        return wb;
    }

    public static CellStyle createStyleCell(Workbook wb) {
        CellStyle cellStyle = wb.createCellStyle();
        //        // 设置一个单元格边框颜色
        //        cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
        //        cellStyle.setBorderTop(CellStyle.BORDER_THIN);
        //        cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
        //        cellStyle.setBorderRight(CellStyle.BORDER_THIN);
        //        // 设置一个单元格边框颜色
        //        cellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
        //        cellStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        //        cellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        //        cellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
        return cellStyle;
    }

    /**
     * 设置文字在单元格里面的位置 CellStyle.ALIGN_CENTER CellStyle.VERTICAL_CENTER
     * 
     * @param cellStyle
     * @param halign
     * @param valign
     * @return
     */
    public static CellStyle setCellStyleAlignment(CellStyle cellStyle, short halign, short valign) {
        // 设置上下
        cellStyle.setAlignment(halign);
        // 设置左右
        cellStyle.setVerticalAlignment(valign);
        return cellStyle;
    }

    /**
     * 格式化单元格 如#,##0.00,m/d/yy去HSSFDataFormat或XSSFDataFormat里面找
     * 
     * @param cellStyle
     * @param fmt
     * @return
     */
    public static CellStyle setCellFormat(CreationHelper helper, CellStyle cellStyle, String fmt) {
        // 还可以用其它方法创建format
        cellStyle.setDataFormat(helper.createDataFormat().getFormat(fmt));
        return cellStyle;
    }

    /**
     * 设置字体
     * 
     * @param wb
     * @return
     */
    public static Font createFonts(Workbook wb) {
        // 创建Font对象
        Font font = wb.createFont();
        // 设置字体
        font.setFontName("微软雅黑");
        // 着色
        font.setColor(HSSFColor.BLACK.index);
        return font;
    }

    /**
     * 生成EXCEL通用方法使用的表头类
     * 
     */
    public static class ExcelTitle{
        private int order;
        private Class<?> type;
        private String title;
        public int getOrder() {
            return order;
        }
        public void setOrder(int order) {
            this.order = order;
        }
        public String getTitle() {
            return title;
        }
        public void setTitle(String title) {
            this.title = title;
        }
        public Class<?> getType() {
            return type;
        }
        public void setType(Class<?> type) {
            this.type = type;
        }
        public ExcelTitle(int order, Class<?> type, String title) {
            super();
            this.order = order;
            this.type = type;
            this.title = title;
        }
    }
}

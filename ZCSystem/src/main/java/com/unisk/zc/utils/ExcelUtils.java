package com.unisk.zc.utils;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;

import org.apache.poi.ss.usermodel.Cell;

import com.unisk.zc.exceptions.UniskException;

public class ExcelUtils {

	public static String getCellValue(Cell cell) throws UniskException {
		try {
			if( cell.getCellType() == Cell.CELL_TYPE_STRING )
				return new String( cell.getStringCellValue().getBytes(),"UTF-8" );
			if( cell.getCellType() == Cell.CELL_TYPE_NUMERIC ){
				BigDecimal db = new BigDecimal(cell.getNumericCellValue());
				return db.toPlainString();
			}
				
		} catch (UnsupportedEncodingException e) {
			new UniskException(Constant.SERVICE_FAILURE_CODE,Constant.SERVICE_FAILURE_DESC,"转换编码错误");
		}
	return null;
}
	
}

package com.efubao.core.common.domain.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Short类型处理器
 * MyBatis使用类型处理器（type handler）将数据从数据库特定的数据类型转换为应用程序中的数据类型，
 * 这样你就可以创建一个以一种尽可能透明的方式来使用数据库的应用程序。
 * 类型处理器本质上就是一个翻译器（translator）--他将数据库返回的结果集合中的列“翻译”为相应的JavaBean中的字段。
 * @author Luke
 *
 */
public class LashouShortArrayTypeHandler extends BaseTypeHandler<Short[]> {

    public LashouShortArrayTypeHandler() {
        super();
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i,
    		Short[] parameter, JdbcType jdbcType) throws SQLException {
    	Array arr = ps.getConnection().createArrayOf("int2", parameter);
        ps.setArray(i, arr);
    }

    @Override
    public Short[] getNullableResult(ResultSet rs, String columnName) 
            throws SQLException {
        Array array = rs.getArray(columnName);
        if(array == null) {
        	return null;
        }
        Object[] arr = (Object[])array.getArray();
        List<Short> temp = new ArrayList<Short>();
        for (Object object : arr) {
			if(object instanceof Integer){
				temp.add(((Integer) object).shortValue());
			}
		}
        return temp.toArray(new Short[temp.size()]);
    }

    @Override
    public Short[] getNullableResult(ResultSet rs, int columnIndex)
            throws SQLException {
        Array array = rs.getArray(columnIndex);
        if(array == null) {
        	return null;
        }
        Object[] arr = (Object[])array.getArray();
        List<Short> temp = new ArrayList<Short>();
        for (Object object : arr) {
			if(object instanceof Integer){
				temp.add(((Integer) object).shortValue());
			}
		}
        return temp.toArray(new Short[temp.size()]);
    }

    @Override
    public Short[] getNullableResult(CallableStatement cs, int columnIndex)
            throws SQLException {
        Array array = cs.getArray(columnIndex);
        if(array == null) {
        	return null;
        }
        Object[] arr = (Object[])array.getArray();
        List<Short> temp = new ArrayList<Short>();
        for (Object object : arr) {
			if(object instanceof Integer){
				temp.add(((Integer) object).shortValue());
			}
		}
        return temp.toArray(new Short[temp.size()]);
    }
}
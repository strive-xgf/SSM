package com.xgf.mybatis_generator.typeHandler;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.springframework.stereotype.Component;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



//mybatis-generator.xml自动生成的 自定义类型处理器handler
//@Component  spring将其当成bean来管理
@Component
@MappedJdbcTypes(JdbcType.VARCHAR)  //@MappedJdbcTypes(JdbcType.VARCHAR) 注解表示映射到JDBC的VARCHAR类型
//BaseTypeHandler<String[]>的string[]表示处理的是字符串数组，将其映射成数据库的VARCHAR
public class StringArrayVarcharHandler extends BaseTypeHandler<String[]> {

      //把传入的字符串转化为一个数组:
     //参1：PreparedStatement是数据库操作  参2：i是第几列  参3：Strings是要转化成的数组  参4：jdbcType是数据库的数据类型
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, String[] strings, JdbcType jdbcType) throws SQLException {
        //      将字符串按 ,逗号 分隔成一个字符串数组
        if(ArrayUtils.isNotEmpty(strings)){
            String result = StringUtils.join(strings,","); //字符串数组
            preparedStatement.setString(i,result);
        }

    }

    //查询的时候进行类型转换
    @Override
    public String[] getNullableResult(ResultSet resultSet, String columnName) throws SQLException {

        String[] result = new String[0];//长度为0的字符串数组，没有取到值得时候
         String value = resultSet.getString(columnName);
        if(StringUtils.isNotEmpty(value)){
            result = value.split(",");//将字符串按,分割成数组
        }
        return result;
    }

    @Override
    public String[] getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return new String[0];
    }

    @Override
    public String[] getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return new String[0];
    }
}

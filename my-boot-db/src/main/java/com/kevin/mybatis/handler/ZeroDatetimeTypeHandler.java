package com.kevin.mybatis.handler;

import org.apache.ibatis.type.DateTypeHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by gtzhou on 2017/7/3.
 */
public class ZeroDatetimeTypeHandler extends DateTypeHandler {
    @Override
    public Date getNullableResult(ResultSet rs, String columnName) throws SQLException {
        try {
            Timestamp sqlTimestamp = rs.getTimestamp(columnName);
        }catch (SQLException ex){
            return null;
        }
        return super.getNullableResult(rs, columnName);
    }
}

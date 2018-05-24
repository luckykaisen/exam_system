package com.jiyinhui.exam.config.mybatis.handler;

import com.jiyinhui.exam.entity.Bool;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoolHandler extends BaseTypeHandler<Bool> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Bool parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.getId());
    }

    @Override
    public Bool getNullableResult(ResultSet rs, String columnName) throws SQLException {
        int anInt = rs.getInt(columnName);
        if (rs.wasNull()) {
            return null;
        } else {
            return Bool.fromId(anInt);
        }
    }

    @Override
    public Bool getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        int anInt = rs.getInt(columnIndex);
        if (rs.wasNull()) {
            return null;
        } else {
            return Bool.fromId(anInt);
        }
    }

    @Override
    public Bool getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        int anInt = cs.getInt(columnIndex);
        if (cs.wasNull()) {
            return null;
        } else {
            return Bool.fromId(anInt);
        }
    }
}

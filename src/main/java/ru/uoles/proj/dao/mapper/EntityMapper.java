package com.mkyong.dao.mapper;

import com.mkyong.model.Entity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EntityMapper implements RowMapper<Entity> {

    @Override
    public Entity mapRow(ResultSet resultSet, int i) throws SQLException {
        return null;
    }
}

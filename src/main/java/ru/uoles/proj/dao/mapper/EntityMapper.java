package ru.uoles.proj.dao.mapper;

import ru.uoles.proj.model.Entity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EntityMapper implements RowMapper<Entity> {

    @Override
    public Entity mapRow(ResultSet resultSet, int i) throws SQLException {
        final Long id = resultSet.getLong("id");
        final String text = resultSet.getString("text");

        return new Entity(id, text);
    }
}

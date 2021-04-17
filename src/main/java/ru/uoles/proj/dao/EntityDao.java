package ru.uoles.proj.dao;

import org.springframework.jdbc.core.RowMapper;

import java.util.List;
import java.util.Map;

public interface EntityDao {

	<T> List<T> query(String sql, Map<String, Object> params, RowMapper<T> rowMapper);
}
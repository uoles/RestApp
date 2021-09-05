package ru.uoles.proj.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class EntityDaoImpl implements EntityDao {

	private final Logger logger = LoggerFactory.getLogger(EntityDaoImpl.class);

	private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public EntityDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public <T> List<T> query(String sql, Map<String, Object> params, RowMapper<T> rowMapper) {
		List<T> entities = null;
		try {
			entities = namedParameterJdbcTemplate.query(sql, params, rowMapper);
		} catch (DataAccessException e) {
			logger.error("Database error: {}", e.getMessage());
		} catch (Exception e) {
			logger.error("Error: {}", e.getMessage());
		}

		return (entities == null) ? new ArrayList<>() : entities;
	}
}
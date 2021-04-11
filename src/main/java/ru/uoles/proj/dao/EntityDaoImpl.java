package ru.uoles.proj.dao;

import ru.uoles.proj.dao.mapper.EntityMapper;
import ru.uoles.proj.model.Entity;
import ru.uoles.proj.rest.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EntityDaoImpl implements EntityDao {

	private final Logger logger = LoggerFactory.getLogger(RestController.class);

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public List<Entity> query(String sql) {
		List<Entity> entities = null;
		try {
			entities = namedParameterJdbcTemplate.query(sql, new EntityMapper());
		} catch (DataAccessException e) {
			logger.error("Database error: {}", e.getMessage());
		} catch (Exception e) {
			logger.error("Error: {}", e.getMessage());
		}
		return entities == null ? new ArrayList<>() : entities;
	}
}
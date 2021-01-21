package com.mkyong.dao;

import com.mkyong.dao.mapper.EntityMapper;
import com.mkyong.model.Entity;
import com.mkyong.rest.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
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
//			logger.error("Database error", e);

			Throwable t = e.getCause();
			while(t != null) {
				if (t instanceof SQLException) {
					System.out.println("Cause: " + t.getMessage());
				}
				t = t.getCause();
			}

//			throw e;
		}
		return entities == null ? new ArrayList<>() : entities;
	}
}
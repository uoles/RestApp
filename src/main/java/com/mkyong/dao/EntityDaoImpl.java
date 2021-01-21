package com.mkyong.dao;

import org.springframework.stereotype.Repository;

@Repository
public class EntityDaoImpl implements EntityDao {

	public String save() {
		return "Jersey + Spring example";
	}
}
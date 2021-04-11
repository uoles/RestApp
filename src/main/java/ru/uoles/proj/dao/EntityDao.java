package com.mkyong.dao;

import com.mkyong.model.Entity;

import java.util.List;

public interface EntityDao {

	List<Entity> query(String sql);
}
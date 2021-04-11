package ru.uoles.proj.dao;

import ru.uoles.proj.model.Entity;

import java.util.List;

public interface EntityDao {

	List<Entity> query(String sql);
}
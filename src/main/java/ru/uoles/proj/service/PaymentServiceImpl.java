package ru.uoles.proj.service;

import org.springframework.stereotype.Service;
import ru.uoles.proj.dao.EntityDao;
import ru.uoles.proj.dao.mapper.EntityMapper;
import ru.uoles.proj.model.Entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PaymentServiceImpl implements PaymentService {

    public static final String GET_ENTITIES = "SELECT id, text FROM entity WHERE message = :message";

    private final EntityDao entityDao;

    public PaymentServiceImpl(EntityDao entityDao) {
        this.entityDao = entityDao;
    }

    @Override
    public List<Entity> getEntities(String param) {
        return entityDao.query(GET_ENTITIES, mapToParams(param), new EntityMapper());
    }

    public static Map<String, Object> mapToParams(String param) {
        Map<String, Object> params = new HashMap<>();
        params.put("message", param);
        return params;
    }
}

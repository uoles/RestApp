package ru.uoles.proj.service;

import ru.uoles.proj.dao.EntityDao;
import ru.uoles.proj.dao.mapper.EntityMapper;
import ru.uoles.proj.model.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private EntityDao entityDao;

    @Override
    public List<Entity> getEntities(String param) {
        return entityDao.query("SELECT id, text FROM entity WHERE message = :message", mapToParams(param), new EntityMapper());
    }

    private Map<String, Object> mapToParams(String param) {
        Map<String, Object> params = new HashMap<>();
        params.put("message", param);
        return params;
    }
}

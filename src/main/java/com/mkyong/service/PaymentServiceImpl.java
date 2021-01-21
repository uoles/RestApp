package com.mkyong.service;

import com.mkyong.dao.EntityDao;
import com.mkyong.model.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private EntityDao entityDao;

    @Override
    public List<Entity> getEntities() {
        return entityDao.query("select id, text from entity");
    }
}

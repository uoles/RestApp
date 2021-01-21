package com.mkyong.service;

import com.mkyong.dao.EntityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private EntityDao entityDao;

    @Override
    public String savePayment() {
        return entityDao.save();
    }
}

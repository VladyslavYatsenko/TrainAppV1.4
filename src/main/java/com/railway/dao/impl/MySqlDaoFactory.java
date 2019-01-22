package com.railway.dao.impl;

import com.railway.dao.DaoFactory;
import com.railway.dao.OrderDAO;
import com.railway.dao.PassangerDAO;
import com.railway.dao.TrainDAO;

public class MySqlDaoFactory implements DaoFactory {
    @Override
    public OrderDAO createOrderDao() {
        return new MySqlOrderDao();
    }

    @Override
    public PassangerDAO createPassangerDao() {
        return new MySqlPassangerDao();
    }

    @Override
    public TrainDAO createTrainDao() {
        return new MySqlTrainDao();
    }
}

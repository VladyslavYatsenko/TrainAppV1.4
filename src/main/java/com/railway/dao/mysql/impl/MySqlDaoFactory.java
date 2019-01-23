package com.railway.dao.mysql.impl;

import com.railway.dao.DaoFactory;
import com.railway.dao.OrderDao;
import com.railway.dao.PassangerDao;
import com.railway.dao.TrainDao;

public class MySqlDaoFactory implements DaoFactory {
    @Override
    public OrderDao createOrderDao() {
        return new MySqlOrderDao();
    }

    @Override
    public PassangerDao createPassangerDao() {
        return new MySqlPassangerDao();
    }

    @Override
    public TrainDao createTrainDao() {
        return new MySqlTrainDao();
    }
}

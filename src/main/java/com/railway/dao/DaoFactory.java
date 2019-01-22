package com.railway.dao;

public interface DaoFactory {
    public abstract OrderDAO createOrderDao();
    public abstract PassangerDAO createPassangerDao();
    public abstract TrainDAO createTrainDao();
}

package com.railway.dao;

public interface DaoFactory {
    public abstract OrderDao createOrderDao();
    public abstract PassangerDao createPassangerDao();
    public abstract TrainDao createTrainDao();
}

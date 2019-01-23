package com.railway.dao;

import classes.order.Order;
import classes.passanger.Passanger;
import com.railway.dao.mysql.impl.DataAccessException;

import java.util.List;

public interface OrderDao {
    public abstract List<Order> initOrdersList() throws DataAccessException;

    public abstract Order findOrder(int orderId) throws DataAccessException;

    public abstract void createOrder(Passanger passanger) throws DataAccessException;
}

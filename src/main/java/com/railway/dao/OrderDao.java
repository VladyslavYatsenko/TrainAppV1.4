package com.railway.dao;

import classes.order.Order;
import com.railway.dao.mysql.impl.DataAccessException;

import java.util.List;

public interface OrderDao {
    public abstract List<Order> initOrdersList() throws DataAccessException;

    public abstract Order findOrder(int orderId) throws DataAccessException;

}

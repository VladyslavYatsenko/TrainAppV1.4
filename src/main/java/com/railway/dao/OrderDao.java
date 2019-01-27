package com.railway.dao;

import classes.order.Order;
import classes.passanger.Passanger;
import com.railway.dao.mysql.impl.DataAccessException;

import javax.xml.crypto.Data;
import java.util.List;

public interface OrderDao {
    public abstract List<Order> initOrdersList() throws DataAccessException;

    public abstract Order findOrder(int orderId) throws DataAccessException;

    public abstract void createOrder(Passanger passanger) throws DataAccessException;

    public abstract void deleteOrder(int passangerId) throws DataAccessException;

    public abstract void deleteOrderWithTrains(int trainId) throws DataAccessException;
}

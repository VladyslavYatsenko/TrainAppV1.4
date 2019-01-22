package com.railway.dao;

import classes.order.Order;
import com.railway.dao.impl.DataAccessException;

import javax.xml.crypto.Data;
import java.sql.SQLException;
import java.util.List;

public interface OrderDAO {
    public abstract List<Order> initOrdersList() throws DataAccessException;

    public abstract Order findOrder(int orderId) throws DataAccessException;

}

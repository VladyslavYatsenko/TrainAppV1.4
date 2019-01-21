package DAO.interfaces;

import classes.order.Order;

import java.sql.SQLException;
import java.util.List;

public interface OrderDAO {
    public abstract void initOrdersList() throws SQLException;

    public abstract int getTrainId(int orderId) throws SQLException;

    public abstract int getPassangerId(int orderId) throws SQLException;

    public abstract List<Order> getOrdersList();
}

package com.railway.dao.impl;

import classes.order.Order;
import com.railway.dao.OrderDAO;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlOrderDao extends MySqlConnect implements OrderDAO {
    final static Logger logger=Logger.getLogger(DataAccessException.class);
    @Override
    public List<Order> initOrdersList() throws DataAccessException {
        List<Order> ordersList=new ArrayList<>();
        try {
            connectDb();
            String query = "SELECT * FROM orders";
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ordersList.add(new Order(resultSet.getInt("order_id"), resultSet.getInt("train_id"), resultSet.getInt("passanger_id")));
            }
            resultSet.close();
        }catch (SQLException ex){
            throw new DataAccessException(3);
        }
        finally {
            closeConnection();
        }
        logger.info("Orders List Created "+ordersList);
        return ordersList;
    }

    @Override
    public Order findOrder(int orderId) throws DataAccessException {
        Order order=new Order();
        try{
            connectDb();
            String query="SELECT * FROM orders WHERE order_id= "+orderId;
            PreparedStatement preparedStatement=getConnection().prepareStatement(query);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                order = new Order(resultSet.getInt("order_id"),resultSet.getInt("train_id"),resultSet.getInt("passanger_id"));
            }

            resultSet.close();
        }catch (SQLException ex){
            throw new DataAccessException(3);
        }
        finally {
            closeConnection();
        }
        logger.info("Order was find "+order.toString());
        return order;
    }
}

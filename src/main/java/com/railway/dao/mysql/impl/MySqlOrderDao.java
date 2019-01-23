package com.railway.dao.mysql.impl;

import classes.order.Order;
import com.railway.dao.OrderDao;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlOrderDao extends MySqlConnect implements OrderDao {
    final static Logger logger=Logger.getLogger(MySqlOrderDao.class);
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
            logger.info("Orders List Created "+ordersList);
        }catch (SQLException ex){
            throw new DataAccessException(3);
        }
        finally {
            closeConnection();
        }

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
            logger.info("Order was find "+order.toString());
        }catch (SQLException ex){
            throw new DataAccessException(3);
        }
        finally {
            closeConnection();
        }

        return order;
    }
}

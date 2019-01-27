package com.railway.dao.mysql.impl;

import classes.order.Order;
import classes.passanger.Passanger;
import com.railway.dao.OrderDao;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlOrderDao extends MySqlConnect implements OrderDao {
    final static Logger logger = Logger.getLogger(MySqlOrderDao.class);

    @Override
    public List<Order> initOrdersList() throws DataAccessException {
        List<Order> ordersList = new ArrayList<>();
        try {
            connectDb();
            String query = "SELECT * FROM orders";
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ordersList.add(new Order(resultSet.getInt("order_id"), resultSet.getInt("train_id"), resultSet.getInt("passanger_id")));
            }
            resultSet.close();
            logger.info("Orders List Created " + ordersList);
        } catch (SQLException ex) {
            throw new DataAccessException(3);
        } finally {
            closeConnection();
        }

        return ordersList;
    }

    @Override
    public Order findOrder(int orderId) throws DataAccessException {
        Order order = new Order();
        try {
            connectDb();
            String query = "SELECT * FROM orders WHERE order_id= " + orderId;
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                order = new Order(resultSet.getInt("order_id"), resultSet.getInt("train_id"), resultSet.getInt("passanger_id"));
            }
            resultSet.close();
            logger.info("Order was find " + order.toString());
        } catch (SQLException ex) {
            throw new DataAccessException(3);
        } finally {
            closeConnection();
        }

        return order;
    }

    @Override
    public void createOrder(Passanger passanger) throws DataAccessException {
        try {
            connectDb();
            String query = "INSERT INTO orders (train_id,passanger_id) VALUES (" + passanger.getTrainId() + "," + passanger.getPassangerId() + ")";
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.executeUpdate(query);
            logger.info("Order was created");
        } catch (SQLException ex) {

            throw new DataAccessException(1);
        } finally {
            closeConnection();
        }
    }

    @Override
    public void deleteOrder(int passangerId) throws DataAccessException {
        try{
            connectDb();
            String query="DELETE FROM orders WHERE passanger_id ="+passangerId;
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.execute();
            logger.info("Order was deleted from orders ");
        }catch (SQLException ex){
            throw new DataAccessException(2);
        }finally {
            closeConnection();
        }
    }

    @Override
    public void deleteOrderWithTrains(int trainId) throws DataAccessException {
        try{
            connectDb();
            String query="DELETE FROM orders WHERE train_id ="+trainId;
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.execute();
            logger.info("Order was deleted from orders ");
        }catch (SQLException ex){
            throw new DataAccessException(2);
        }finally {
            closeConnection();
        }
    }
}

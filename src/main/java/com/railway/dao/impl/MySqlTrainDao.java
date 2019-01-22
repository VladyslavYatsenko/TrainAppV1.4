package com.railway.dao.impl;

import classes.order.Order;
import classes.passanger.Passanger;
import classes.train.Train;
import com.railway.dao.TrainDAO;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MySqlTrainDao extends MySqlConnect implements TrainDAO {
    final static Logger logger=Logger.getLogger(DataAccessException.class);
    @Override
    public List<Train> initTrainsList() throws DataAccessException {
        List<Train> trainsList = new ArrayList<>();
        try {
            connectDb();
            String query = "SELECT * FROM trains";
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                trainsList.add(new Train(resultSet.getInt("train_id"),
                        resultSet.getInt("train_num"),
                        resultSet.getString("initial_station"),
                        resultSet.getString("end_station"),
                        resultSet.getDouble("cost"),
                        resultSet.getString("departure_date"),
                        resultSet.getString("departure_time"),
                        resultSet.getString("arrival_date"),
                        resultSet.getString("arrival_time")));
            }
            resultSet.close();

        } catch (SQLException ex) {
            throw new DataAccessException(3);
        } finally {
            closeConnection();
        }
        logger.info("Trains list was created "+trainsList);
        return trainsList;
    }

    @Override
    public void createTrain(Train train) throws DataAccessException {
        try {
            connectDb();
            String query = "INSERT INTO trains " +
                    "(train_num,initial_station,end_station,cost,departure_date,departure_time,arrival_date,arrival_time)"
                    + " VALUES " + "('" + train.getTrainNumber() + "','" + train.getInitialStation() + "'," + "'" + train.getEndStation() + "'," + "'" + train.getCost() + "',"
                    + "'" + train.getDepartureDate() + "'," + "'" + train.getDepartureTime() + "'," + "'" + train.getArrivalDate() + "'," + "'" + train.getArrivalTime() + "')";
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.executeUpdate(query);

        } catch (SQLException ex) {
            throw new DataAccessException(1);
        } finally {
            closeConnection();
        }
        logger.info("Train was created"+train.toString());
    }

    @Override
    public Train findTrain(int trainId) throws DataAccessException {
        Train train = new Train();
        try {
            connectDb();
            String query = "SELECT * FROM  trains  WHERE train_id= " + trainId;
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                train = new Train(resultSet.getInt("train_id"),
                        resultSet.getInt("train_num"),
                        resultSet.getString("initial_station"),
                        resultSet.getString("end_station"),
                        resultSet.getDouble("cost"),
                        resultSet.getString("departure_date"),
                        resultSet.getString("departure_time"),
                        resultSet.getString("arrival_date"),
                        resultSet.getString("arrival_time"));
            }
            resultSet.close();
        } catch (SQLException ex) {
            throw new DataAccessException(3);
        } finally {
            closeConnection();
        }
        logger.info("Train was found"+train.toString());
        return train;
    }
}

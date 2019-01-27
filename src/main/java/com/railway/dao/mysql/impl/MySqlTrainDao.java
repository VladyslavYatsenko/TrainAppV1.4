package com.railway.dao.mysql.impl;

import classes.train.Train;
import com.railway.dao.TrainDao;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlTrainDao extends MySqlConnect implements TrainDao {
    final static Logger logger=Logger.getLogger(MySqlTrainDao.class);
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
            logger.info("Trains list was created "+trainsList);
        } catch (SQLException ex) {
            throw new DataAccessException(3);
        } finally {
            closeConnection();
        }
        return trainsList;
    }

    @Override
    public void createTrain(Train train) throws DataAccessException {
        try {
            connectDb();
            String query ="INSERT INTO trains " +
                    "(train_num,initial_station,end_station,cost,departure_date,departure_time,arrival_date,arrival_time)"
                    + " VALUES " + "('" + train.getTrainNumber() + "','" + train.getInitialStation() + "'," + "'" + train.getEndStation() + "'," + "'" + train.getCost() + "',"
                    + "'" + train.getDepartureDate() + "'," + "'" + train.getDepartureTime() + "'," + "'" + train.getArrivalDate() + "'," + "'" + train.getArrivalTime() + "')";
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.executeUpdate(query);
            logger.info("Train was added to trains"+train.toString());
        } catch (SQLException ex) {
            throw new DataAccessException(1);
        } finally {
            closeConnection();
        }

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
            logger.info("Train was found"+train.toString());
        } catch (SQLException ex) {
            throw new DataAccessException(3);
        } finally {
            closeConnection();
        }

        return train;
    }

    @Override
    public void deleteTrain(int trainId) throws DataAccessException {
        try{
            connectDb();
            String query="DELETE FROM trains WHERE train_id ="+trainId;
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.execute();
            logger.info("Train was deleted from trains");
        }catch (SQLException ex){
            throw new DataAccessException(2);
        }finally {
            closeConnection();
        }
    }

    @Override
    public void updateTrain(Train train) throws DataAccessException {
        try{
            connectDb();
            String query="UPDATE trains SET  "+
                    ",train_num="+train.getTrainNumber()+
                    ",initial_station="+train.getInitialStation()+
                    ",end_station="+train.getEndStation()+
                    ",cost="+train.getCost()+
                    ",departure_date="+train.getDepartureDate()+
                    ",departure_time="+train.getDepartureTime()+
                    ",arrival_date="+train.getArrivalDate()+
                    ",arrival_time="+train.getArrivalTime()+"WHERE train_id="+train.getTrainId();
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.execute();
            logger.info("Train was updated");
        }catch (SQLException ex){
            throw new DataAccessException(2);
        }finally {
            closeConnection();
        }
    }
}

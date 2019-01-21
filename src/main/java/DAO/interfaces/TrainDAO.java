package DAO.interfaces;

import classes.train.Train;

import java.sql.SQLException;
import java.util.List;

public interface TrainDAO {
    public abstract void initTrainsList() throws SQLException;

    public abstract int getTrainNumber(int trainId) throws SQLException;

    public abstract String getInitialStation(int trainId) throws SQLException;

    public abstract String getEndStation(int trainId) throws SQLException;

    public abstract double getCost(int trainId) throws SQLException;

    public abstract String getDepartureDate(int trainId) throws SQLException;

    public abstract String getDepartureTime(int trainId) throws SQLException;

    public abstract String getArrivalDate(int trainId) throws SQLException;

    public abstract String getArrivalTime(int trainId) throws SQLException;

    public abstract void createTrain(Train train) throws SQLException;

    public abstract List<Train> getTrainsList();

}

package DAO.interfaces;

import classes.train.Train;

public interface TrainDAO {
    public abstract void initTrainsList();
    public abstract int getTrainNumber(int trainId);
    public abstract String getInitialStation(int trainId);
    public abstract String getEndStation(int trainId);
    public abstract double getCost(int trainId);
    public abstract String getDepartureDate(int trainId);
    public abstract String getDepartureTime(int trainId);
    public abstract String getArrivalDate(int trainId);
    public abstract String getArrivalTime(int trainId);
    public abstract void createTrain(Train train);

}

package com.railway.dao;

import classes.train.Train;
import com.railway.dao.mysql.impl.DataAccessException;

import java.util.List;

public interface TrainDao {
    public abstract List<Train> initTrainsList() throws DataAccessException;

    public abstract void createTrain(Train train) throws DataAccessException;

    public abstract Train findTrain(int trainId) throws DataAccessException;

}

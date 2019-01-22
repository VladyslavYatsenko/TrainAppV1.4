package com.railway.dao;

import classes.train.Train;
import com.railway.dao.impl.DataAccessException;

import javax.xml.crypto.Data;
import java.sql.SQLException;
import java.util.List;

public interface TrainDAO {
    public abstract List<Train> initTrainsList() throws DataAccessException;

    public abstract void createTrain(Train train) throws DataAccessException;

    public abstract Train findTrain(int trainId) throws DataAccessException;

}

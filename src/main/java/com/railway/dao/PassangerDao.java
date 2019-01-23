package com.railway.dao;

import classes.passanger.Passanger;
import com.railway.dao.mysql.impl.DataAccessException;

import java.util.List;

public interface PassangerDao {

    public abstract List<Passanger> initPassengersList() throws DataAccessException;

    public  abstract Passanger findPassanger(int passangerId) throws DataAccessException;

    public abstract void createPassanger(Passanger passanger) throws DataAccessException;
}

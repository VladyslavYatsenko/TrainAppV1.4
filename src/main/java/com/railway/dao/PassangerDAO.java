package com.railway.dao;

import classes.passanger.Passanger;
import com.railway.dao.impl.DataAccessException;

import javax.xml.crypto.Data;
import java.sql.SQLException;
import java.util.List;

public interface PassangerDAO {

    public abstract List<Passanger> initPassengersList() throws DataAccessException;

    public  abstract Passanger findPassanger(int passangerId) throws DataAccessException;
}

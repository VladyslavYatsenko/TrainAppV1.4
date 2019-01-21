package DAO.interfaces;

import classes.passanger.Passanger;

import java.sql.SQLException;
import java.util.List;

public interface PassangerDAO {
    public abstract void initPassengersList() throws SQLException;

    public abstract String getPassangerFirstName(int passangerId) throws SQLException;

    public abstract String getPassangerLastName(int passangerId) throws SQLException;

    public abstract int getTrainId(int passangerId) throws SQLException;

    public abstract List<Passanger> getPassangersList();
}

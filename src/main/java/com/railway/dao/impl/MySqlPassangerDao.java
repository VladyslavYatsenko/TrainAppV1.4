package com.railway.dao.impl;

import classes.order.Order;
import classes.passanger.Passanger;
import com.railway.dao.PassangerDAO;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MySqlPassangerDao extends MySqlConnect implements PassangerDAO {
    final static Logger logger=Logger.getLogger(DataAccessException.class);
    @Override
    public List<Passanger> initPassengersList() throws DataAccessException {
        List<Passanger> passangersList = new ArrayList<>();
        try {
            connectDb();
            String query = "SELECT * FROM passangers";
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                passangersList.add(new Passanger(resultSet.getInt("passanger_id"),
                        resultSet.getString("passanger_firstName")
                        , resultSet.getString("passanger_lastName"),
                        resultSet.getInt("train_identificationNumber")));
            }
            resultSet.close();
        } catch (SQLException ex) {
            throw new DataAccessException(3);
        } finally {
            closeConnection();
        }
        logger.info("Passangers list was created "+passangersList);
        return passangersList;
    }

    @Override
    public Passanger findPassanger(int passangerId) throws DataAccessException {
        Passanger passanger = new Passanger();
        try {
            connectDb();
            String query = "SELECT * FROM  passangers  WHERE passanger_id= " + passangerId;
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                passanger = new Passanger(resultSet.getInt("passanger_id"),
                        resultSet.getString("passanger_firstName")
                        , resultSet.getString("passanger_lastName")
                        , resultSet.getInt("train_identificationNumber"));
            }
            resultSet.close();
        } catch (SQLException ex) {
            throw new DataAccessException(3);
        } finally {
            closeConnection();
        }
        logger.info("Passangers was find "+passanger.toString());
        return passanger;
    }
}

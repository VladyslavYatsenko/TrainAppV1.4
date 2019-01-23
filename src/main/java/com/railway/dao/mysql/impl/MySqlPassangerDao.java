package com.railway.dao.mysql.impl;

import classes.passanger.Passanger;
import com.railway.dao.PassangerDao;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlPassangerDao extends MySqlConnect implements PassangerDao {
    final static Logger logger = Logger.getLogger(DataAccessException.class);

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
            logger.info("Passangers list was created " + passangersList);
        } catch (SQLException ex) {
            throw new DataAccessException(3);
        } finally {
            closeConnection();
        }

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
            logger.info("Passangers was find " + passanger.toString());
        } catch (SQLException ex) {
            throw new DataAccessException(3);
        } finally {
            closeConnection();
        }
        return passanger;
    }

    @Override
    public void createPassanger(Passanger passanger) throws DataAccessException {
        try {
            connectDb();
            String query = "INSERT INTO passangers (passanger_firstName,passanger_lastName,train_identificationNumber)" +
                    " VALUES ('" + passanger.getFirstName() + "','" + passanger.getLastName() + "','" + passanger.getTrainId() + "')";
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.executeUpdate(query);
            logger.info("Passanger was added to passangers" + passanger.toString());
        } catch (SQLException ex) {
            throw new DataAccessException(3);
        } finally {
            closeConnection();
        }

    }
}

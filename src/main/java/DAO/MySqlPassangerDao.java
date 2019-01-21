package DAO;

import DAO.interfaces.PassangerDAO;
import classes.passanger.Passanger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class MySqlPassangerDao extends MySqlConnect implements PassangerDAO {
    private Passanger passanger;
    private List<Passanger> passangersList = new LinkedList<>();

    @Override
    public void initPassengersList() throws SQLException {
        connectDb();
        String query = "SELECT *FROM passangers";

        ResultSet rs = getStatement().executeQuery(query);
        while (rs.next()) {
            passanger = new Passanger(rs.getInt("passanger_id")
                    , rs.getString("passanger_firstName")
                    , rs.getString("passanger_lastName")
                    , rs.getInt("train_identificationNumber"));
            passangersList.add(passanger);
        }
        closeConnection();
    }

    @Override
    public String getPassangerFirstName(int passangerId) throws SQLException {
        connectDb();
        String query = "SELECT passanger_firstName FROM passangers WHERE passanger_id=" + passangerId;
        String passangerFirstName = null;
        ResultSet rs = getStatement().executeQuery(query);
        while (rs.next()) {
            passangerFirstName = rs.getString("passanger_firstName");
        }
        closeConnection();
        return passangerFirstName;
    }

    @Override
    public String getPassangerLastName(int passangerId) throws SQLException {
        connectDb();
        String query = "SELECT passanger_lastName FROM passangers WHERE passanger_id=" + passangerId;
        String passangerLastName = null;
        ResultSet rs = getStatement().executeQuery(query);

        while (rs.next()) {
            passangerLastName = rs.getString("passanger_lastName");
        }

        closeConnection();
        return passangerLastName;
    }

    @Override
    public int getTrainId(int passangerId) throws SQLException {
        connectDb();
        String query = "SELECT train_identificationNumber FROM passangers WHERE passanger_id=" + passangerId;
        int trainId = 0;
        ResultSet rs = getStatement().executeQuery(query);
        while (rs.next()) {
            trainId = rs.getInt("train_identificationNumber");
        }
        closeConnection();
        return trainId;

    }

    @Override
    public void createPassanger(Passanger passanger) throws SQLException {
        connectDb();
        String query="INSERT INTO passangers " +
                "(passanger_firstName,passanger_lastName,train_identificationNumber) VALUES ("
                +"'"+passanger.getFirstName()+"',"
                +"'"+passanger.getLastName()+"',"
                +"'"+passanger.getTrainId()+"')";
        getStatement().executeUpdate(query);
        closeConnection();
    }

    public List<Passanger> getPassangersList() {
        return passangersList;
    }
}

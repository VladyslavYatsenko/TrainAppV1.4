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
    public void initPassengersList() {
        connectDb();
        String query = "SELECT *FROM passanger";
        try {
            ResultSet rs = getStatement().executeQuery(query);
            while (rs.next()) {
                passanger = new Passanger(rs.getInt("passanger_id")
                        , rs.getString("passanger_firstName")
                        , rs.getString("passanger_lastName")
                        , rs.getInt("train_identificationNumber"));
                passangersList.add(passanger);
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        closeConnection();
    }

    @Override
    public String getPassangerFirstName(int passangerId) {
        connectDb();
        String query="SELECT passanger_firstName FROM passangers WHERE passanger_id="+passangerId;
        String passangerFirstName=null;
        try{
            ResultSet rs=getStatement().executeQuery(query);
            while (rs.next()){
                passangerFirstName= rs.getString("passanger_firstName");
            }

        }catch (SQLException ex){
            ex.getMessage();
        }
        closeConnection();
        return passangerFirstName;
    }

    @Override
    public String getPassangerLastName(int passangerId) {
        connectDb();
        String query = "SELECT passanger_lastName FROM passangers WHERE passanger_id=" + passangerId;
        String passangerLastName = null;
        try {
            ResultSet rs = getStatement().executeQuery(query);

            while (rs.next()) {
                passangerLastName = rs.getString("passanger_lastName");
            }

        } catch (SQLException ex) {
            ex.getMessage();
        }
        closeConnection();
        return passangerLastName;
    }

    @Override
    public int getTrainId(int passangerId) {
        connectDb();
        String query="SELECT train_identificationNumber FROM passangers WHERE passanger_id="+passangerId;
        int trainId=0;
        try{
            ResultSet rs=getStatement().executeQuery(query);
            while (rs.next()){
                trainId=rs.getInt("train_identificationNumber");
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        closeConnection();
        return trainId;

    }
}

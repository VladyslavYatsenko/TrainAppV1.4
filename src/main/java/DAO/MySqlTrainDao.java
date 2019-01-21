package DAO;

import DAO.interfaces.TrainDAO;
import classes.train.Train;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class MySqlTrainDao extends MySqlConnect implements TrainDAO {
    private List<Train> trainsList = new LinkedList<>();
    private Train train;
    @Override
    public void initTrainsList() {
        connectDb();
        String query = "SELECT *FROM trains";
        try {
            ResultSet rs = getStatement().executeQuery(query);
            while (rs.next()) {
                train = new Train(rs.getInt("train_id")
                        , rs.getInt("train_num")
                        , rs.getString("initial_station")
                        , rs.getString("end_station")
                        , rs.getDouble("cost")
                        , rs.getString("departure_date")
                        , rs.getString("departure_time")
                        , rs.getString("arrival_date")
                        , rs.getString("arrival_time"));
                System.out.println(train);
                trainsList.add(train);
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        closeConnection();
    }

    @Override
    public String getDepartureDate(int trainId) {
        connectDb();
        String departureDate=null;
        String query="SELECT departure_date FROM trains WHERE train_id="+trainId;
        try{
            ResultSet rs=getStatement().executeQuery(query);
            while (rs.next()){
                departureDate=rs.getString("departure_date");
            }
        }catch (SQLException ex){
            ex.getMessage();
        }
        closeConnection();
        return departureDate;
    }

    @Override
    public String getDepartureTime(int trainId) {
        connectDb();
        String departureTime=null;
        String query="SELECT departure_time FROM trains WHERE train_id="+trainId;
        try{
            ResultSet rs=getStatement().executeQuery(query);
            while (rs.next()){
                departureTime=rs.getString("departure_time");
            }
        }catch (SQLException ex){
            ex.getMessage();
        }
        closeConnection();
        return departureTime;
    }

    @Override
    public String getArrivalDate(int trainId) {
        connectDb();
        String arrivalDate=null;
        String query="SELECT arrival_date FROM trains WHERE train_id="+trainId;
        try{
            ResultSet rs=getStatement().executeQuery(query);
            while (rs.next()){
                arrivalDate=rs.getString("arrival_date");
            }
        }catch (SQLException ex){
            ex.getMessage();
        }
        closeConnection();
        return arrivalDate;
    }

    @Override
    public String getArrivalTime(int trainId) {
        connectDb();
        String arrivalTime=null;
        String query="SELECT arrival_time FROM trains WHERE train_id="+trainId;
        try{
            ResultSet rs=getStatement().executeQuery(query);
            while (rs.next()){
                arrivalTime=rs.getString("arrival_time");
            }
        }catch (SQLException ex){
            ex.getMessage();
        }
        closeConnection();
        return arrivalTime;
    }

    @Override
    public double getCost(int trainId) {
        connectDb();
        double cost=0;
        String query="SELECT cost FROM trains WHERE train_id="+trainId;
        try{
            ResultSet rs=getStatement().executeQuery(query);
            while (rs.next()){
                cost=rs.getDouble("cost");
            }
        }catch (SQLException ex){
            ex.getMessage();
        }
        closeConnection();
        return cost;
    }

    @Override
    public int getTrainNumber(int trainId) {
        connectDb();
        int trainNumber=0;
        String query="SELECT train_num FROM trains WHERE train_id="+trainId;
        try{
            ResultSet rs=getStatement().executeQuery(query);
            while (rs.next()){
                trainNumber=rs.getInt("train_num");
            }
        }catch (SQLException ex){
            ex.getMessage();
        }
        closeConnection();
        return trainNumber;
    }

    @Override
    public String getEndStation(int trainId) {
        connectDb();
        String endStation=null;
        String query="SELECT end_station FROM trains WHERE train_id="+trainId;
        try{
            ResultSet rs=getStatement().executeQuery(query);
            while (rs.next()){
                endStation=rs.getString("end_station");
            }
        }catch (SQLException ex){
            ex.getMessage();
        }
        closeConnection();
        return endStation;
    }

    @Override
    public String getInitialStation(int trainId) {
        connectDb();
        String initialStation=null;
        String query="SELECT initial_station FROM trains WHERE train_id="+trainId;
        try{
            ResultSet rs=getStatement().executeQuery(query);
            while (rs.next()){
                initialStation=rs.getString("initial_station");
            }
        }catch (SQLException ex){
            ex.getMessage();
        }
        closeConnection();
        return initialStation;

    }

    @Override
    public void createTrain(Train train) {
        connectDb();
        int trainNumber = train.getTrainNumber();
        String initialStation = train.getInitialStation();
        double cost = train.getCost();
        String endStation = train.getEndStation();
        String departureDate = train.getDepartureDate();
        String departureTime = train.getDepartureTime();
        String arrivalDate =train.getArrivalDate();
        String arrivalTime = train.getArrivalTime();
        String query="INSERT INTO trains " +
                "(train_num,initial_station,end_station,cost,departure_date,departure_time,arrival_date,arrival_time)"
                + " VALUES "+"('"+trainNumber+"','"+initialStation+"',"+"'"+endStation+"',"+"'"+cost+"',"
                +"'"+departureDate+"',"+"'"+departureTime+"',"+"'"+arrivalDate+"',"+"'"+arrivalTime+"')";
        try{
            getStatement().executeUpdate(query);
            System.out.print("Train added");
        }catch (SQLException ex){
            System.out.print("Cant add train,try again");
            ex.printStackTrace();
        }
        closeConnection();
    }
}

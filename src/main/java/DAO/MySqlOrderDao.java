package DAO;

import DAO.interfaces.OrderDAO;
import classes.order.Order;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlOrderDao extends MySqlConnect implements OrderDAO {
    private Order order;
    private List<Order> ordersList=new ArrayList<>();
    @Override
    public void initOrdersList() {
        connectDb();
        String query = "SELECT *FROM orders";
        try {
            ResultSet rs = getStatement().executeQuery(query);
            while (rs.next()) {
                order = new Order(rs.getInt("order_id")
                        ,rs.getInt("train_id")
                        ,rs.getInt("passanger_id"));
                System.out.println(order);
                ordersList.add(order);
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        closeConnection();
    }

    @Override
    public int getTrainId(int orderId) {
        connectDb();
        int trainId=0;
        String query="SELECT train_id FROM orders WHERE order_id="+orderId;
        try{
            ResultSet rs=getStatement().executeQuery(query);
            while (rs.next()){
                trainId=rs.getInt("train_id");

            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        closeConnection();
        return trainId;
    }

    @Override
    public int getPassangerId(int orderId) {
        connectDb();
        int passangerId=0;
        String query="SELECT passanger_id FROM orders WHERE order_id="+orderId;
        try{
            ResultSet rs=getStatement().executeQuery(query);
            while (rs.next()){
                passangerId=rs.getInt("passanger_id");

            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        closeConnection();
        return passangerId;
    }

}

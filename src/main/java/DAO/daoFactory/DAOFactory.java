package DAO.daoFactory;

import DAO.MySqlOrderDao;
import DAO.MySqlPassangerDao;
import DAO.MySqlTrainDao;
import DAO.interfaces.OrderDAO;
import DAO.interfaces.PassangerDAO;
import DAO.interfaces.TrainDAO;

public class DAOFactory {

    public OrderDAO createOrderDao(){
        return new MySqlOrderDao();
    }
    public PassangerDAO createPassangerDao(){
        return new MySqlPassangerDao();

    }
    public TrainDAO createTrainDao(){
        return new MySqlTrainDao();
    }
}

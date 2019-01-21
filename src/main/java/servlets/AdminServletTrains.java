package servlets;

import DAO.MySqlTrainDao;
import DAO.daoFactory.DAOFactory;
import DAO.interfaces.OrderDAO;
import DAO.interfaces.PassangerDAO;
import DAO.interfaces.TrainDAO;
import classes.order.Order;
import classes.passanger.Passanger;
import classes.train.Train;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/AdminServletTrains")
public class AdminServletTrains extends HttpServlet {
    DAOFactory daoFactory;
    List<Train> trainsList = new ArrayList<>();
    List<Order> ordersList = new ArrayList<>();
    List<Passanger> passangersList = new ArrayList<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/createTrainPage.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        daoFactory = new DAOFactory();
        TrainDAO trainsDAO = daoFactory.createTrainDao();
        PassangerDAO passangersDAO = daoFactory.createPassangerDao();
        OrderDAO ordersDAO = daoFactory.createOrderDao();
        try{
            trainsDAO.initTrainsList();
            passangersDAO.initPassengersList();
            ordersDAO.initOrdersList();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        trainsList = trainsDAO.getTrainsList();
        passangersList = passangersDAO.getPassangersList();
        ordersList = ordersDAO.getOrdersList();
        System.out.println("Passangers List->" + passangersList);
        System.out.println("Trains List->" + trainsList);
        System.out.println("Orders List->" + ordersList);
        request.setAttribute("fullTrainsList", trainsList);
        request.setAttribute("fullPassangersList", passangersList);
        request.setAttribute("fullOrdersList", ordersList);
        getServletContext().getRequestDispatcher("/adminPage.jsp").forward(request, response);

    }
}

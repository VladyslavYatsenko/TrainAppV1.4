package servlets;

import classes.passanger.Passanger;
import classes.train.Train;
import com.railway.dao.DaoFactory;
import com.railway.dao.OrderDao;
import com.railway.dao.PassangerDao;
import com.railway.dao.TrainDao;
import com.railway.dao.mysql.impl.DataAccessException;
import com.railway.dao.mysql.impl.MySqlDaoFactory;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/SettlementServlet")
public class SettlementServlet extends HttpServlet {
    final static Logger logger = Logger.getLogger(SettlementServlet.class);
    List<Passanger> passangersList = new ArrayList<>();
    Train train;
    Passanger passanger;
    DaoFactory daoFactory;
    PassangerDao passangerDao;
    OrderDao orderDao;
    TrainDao trainDao;
    public void init() {
        daoFactory=new MySqlDaoFactory();
        orderDao = daoFactory.createOrderDao();
        passangerDao = daoFactory.createPassangerDao();
        trainDao=daoFactory.createTrainDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            passangersList = passangerDao.initPassengersList();
            passanger = passangersList.get(passangersList.size() - 1);
            logger.info("Last passanger in list-> :" + passanger.getPassangerId());
            logger.info("His trainId: " + passanger.getTrainId());
            orderDao.createOrder(passanger);
            train=trainDao.findTrain(passanger.getTrainId());
            logger.info("His train: " + train.toString());
            String passangerFirstName = passanger.getFirstName();
            String passangerLastName =  passanger.getLastName();
            int trainNumber=train.getTrainNumber();
            String initialStation = train.getInitialStation();
            String endStation = train.getEndStation();
            String departureDate = train.getDepartureDate();
            String departureTime = train.getDepartureTime();
            String arrivalDate = train.getArrivalDate();
            String arrivalTime = train.getArrivalTime();
            double cost = train.getCost();
            request.setAttribute("passangerFirstName", passangerFirstName);
            request.setAttribute("passangerLastName", passangerLastName);
            request.setAttribute("trainNumber", trainNumber);
            request.setAttribute("initialStation", initialStation);
            request.setAttribute("endStation", endStation);
            request.setAttribute("departureDate", departureDate);
            request.setAttribute("departureTime", departureTime);
            request.setAttribute("arrivalDate", arrivalDate);
            request.setAttribute("arrivalTime", arrivalTime);
            request.setAttribute("cost", cost);
        } catch (DataAccessException ex) {
            logger.info("Data Access Exception " + ex.getErrorCode());
        }
        getServletContext().getRequestDispatcher("/billPage.jsp").forward(request, response);


    }
}

package servlets;

import classes.order.Order;
import classes.passanger.Passanger;
import classes.train.Train;
import com.railway.dao.DaoFactory;
import com.railway.dao.OrderDao;
import com.railway.dao.PassangerDao;
import com.railway.dao.TrainDao;
import com.railway.dao.mysql.impl.DataAccessException;
import com.railway.dao.mysql.impl.MySqlDaoFactory;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/AdminTrainsServlet")
public class AdminTrainsServlet extends HttpServlet {
    final static Logger logger=Logger.getLogger(AdminTrainsServlet.class);
    List<Train> trainsList = new LinkedList<>();
    List<Order> ordersList = new ArrayList<>();
    List<Passanger> passangersList = new LinkedList<>();
    DaoFactory daoFactory;
    OrderDao ordersDao;
    PassangerDao passangersDao;
    TrainDao trainsDao;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/createTrainPage.jsp");
    }
    public void init(){
        daoFactory=new MySqlDaoFactory();
        ordersDao=daoFactory.createOrderDao();
        passangersDao= daoFactory.createPassangerDao();
        trainsDao=daoFactory.createTrainDao();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        init();
        try{
            trainsList=trainsDao.initTrainsList();
            passangersList=passangersDao.initPassengersList();
            ordersList=ordersDao.initOrdersList();
            logger.info("Passangers List->" + passangersList);
            logger.info("Trains List->" + trainsList);
            logger.info("Orders List->" + ordersList);
        }catch (DataAccessException ex){
            ex.getErrorCode();
            logger.error("DataAccesException" +ex.getErrorCode());
        }
        request.setAttribute("fullTrainsList", trainsList);
        request.setAttribute("fullPassangersList", passangersList);
        request.setAttribute("fullOrdersList", ordersList);
        getServletContext().getRequestDispatcher("/adminPage.jsp").forward(request, response);

    }
}

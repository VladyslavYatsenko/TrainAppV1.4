package servlets;

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
import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet("/DeletePassengerServlet")
public class DeletePassengerServlet extends HttpServlet {
    final static Logger logger = Logger.getLogger(CreatePassengerServlet.class);
    List<Passanger> passangerList = new LinkedList<>();
    Set<Integer> passangersId = new TreeSet<>();
    DaoFactory daoFactory;
    PassangerDao passangerDao;
    OrderDao orderDao;

    public void init() {
        daoFactory = new MySqlDaoFactory();
        passangerDao = daoFactory.createPassangerDao();
        orderDao = daoFactory.createOrderDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            passangerList = passangerDao.initPassengersList();

            for (Passanger p : passangerList) {
                passangersId.add(p.getPassangerId());
            }
            request.setAttribute("passengersList", passangerList);
            request.setAttribute("passengersId", passangersId);

            getServletContext().getRequestDispatcher("/deletePassengerPage.jsp").forward(request, response);
        } catch (DataAccessException ex) {
            logger.error(ex.getMessage());
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            int passangerId = Integer.parseInt(request.getParameter("passengerId"));
            passangerDao.deletePassanger(passangerId);
            orderDao.deleteOrder(passangerId);
            out.print("Passenger was deleted everything is fine");
        } catch (DataAccessException ex) {
            logger.error(ex.getErrorCode());
        }
    }
}

package servlets;


import classes.passanger.Passanger;
import classes.train.Train;
import com.railway.dao.DaoFactory;
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
import java.sql.SQLException;

@WebServlet("/TicketRegistrationServlet")
public class TicketRegistrationServlet extends HttpServlet {
    Train userTrain;
    DaoFactory daoFactory;
    PassangerDao passangerDao;
    TrainDao trainDao;
    final static Logger logger=Logger.getLogger(TicketRegistrationServlet.class);

    public void init() {
        daoFactory=new MySqlDaoFactory();
        passangerDao = daoFactory.createPassangerDao();
        trainDao=daoFactory.createTrainDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        init();
        int trainId = Integer.parseInt(request.getParameter("trainId"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        try {
            passangerDao.createPassanger(new Passanger(firstName, lastName, trainId));

            for (Train train :trainDao.initTrainsList()) {
                if (trainId == train.getTrainId()) {
                    userTrain = train;
                }
            }
            logger.info("User train is "+ userTrain);
        } catch (DataAccessException ex) {
            logger.error("DataAccesException "+ex.getErrorCode());
        }
        request.setAttribute("userTrain", userTrain);
        request.setAttribute("firstName", firstName);
        request.setAttribute("lastName", lastName);
        getServletContext().getRequestDispatcher("/settlementPage.jsp").forward(request, response);
    }
}

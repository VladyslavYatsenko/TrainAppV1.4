package servlets;

import classes.train.Train;
import com.railway.dao.DaoFactory;
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
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;

@WebServlet("/CreateTrainServlet")
public class CreateTrainServlet extends HttpServlet {
    final static Logger logger = Logger.getLogger(CreateTrainServlet.class);

    DaoFactory daoFactory;
    TrainDao trainDao;

    public void init() {
        daoFactory = new MySqlDaoFactory();
        trainDao = daoFactory.createTrainDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            int trainNumber = Integer.parseInt(request.getParameter("trainNumber"));
            String initialStation = request.getParameter("initialStation");
            double cost = Double.parseDouble(request.getParameter("cost"));
            String endStation = request.getParameter("endStation");
            LocalDate arrivalDateFilter = LocalDate.parse(request.getParameter("arrivalDate"));
            String arrivalDate = arrivalDateFilter.toString();
            LocalDate departureDateFilter = LocalDate.parse(request.getParameter("departureDate"));
            String departureDate = departureDateFilter.toString();
            String departureTime = request.getParameter("departureTime");
            String arrivalTime = request.getParameter("arrivalTime");
            if (trainNumber <= 0 ) {
                out.print("Error train number,try again");
            } else if (initialStation.length() == 0 || !initialStation.matches("^\\D*$")) {
                out.print("Error initial station");
            } else if (initialStation.equals(endStation)) {
                out.print("Error initial station can`t be equal to end station");
            } else if (departureDateFilter.isAfter(arrivalDateFilter)) {
                out.print("error date (Departure Date is after Arrival Date");
            } else if (endStation.length() == 0 || !endStation.matches("^\\D*$")) {
                out.print("Error end station");
            } else if (cost <= 0) {
                out.print("Error cost");
            } else {
                trainDao.createTrain(new Train(trainNumber, initialStation, endStation, cost, departureDate, departureTime, arrivalDate, arrivalTime));
                out.print("Train Created");
            }
        } catch (DataAccessException ex) {
            out.print("Can`t create a train,check your parameters");
            logger.info("DataAccessException " + ex.getErrorCode());
        }
    }


}


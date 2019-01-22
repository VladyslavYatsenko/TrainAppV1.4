package servlets;

import DAO.interfaces.TrainDAO;
import classes.train.Train;

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
    DAOFactory daoFactory;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        daoFactory = new DAOFactory();
        TrainDAO trainDAO = daoFactory.createTrainDao();
        PrintWriter out = response.getWriter();
        int trainNumber = Integer.parseInt(request.getParameter("trainNumber"));
        String initialStation = request.getParameter("initialStation");
        double cost = Double.parseDouble(request.getParameter("cost"));
        String endStation = request.getParameter("endStation");
        LocalDate arrivalDateFilter = LocalDate.parse(request.getParameter("arrivalDate"));
        String arrivalDate = arrivalDateFilter.toString();
        LocalDate departureDateFilter = LocalDate.parse(request.getParameter("departureDate"));
        String departureDate = arrivalDateFilter.toString();
        String departureTime = request.getParameter("departureTime");
        String arrivalTime = request.getParameter("arrivalTime");
        if (trainNumber <= 0) {
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
            try {
                trainDAO.createTrain(new Train(trainNumber, initialStation, endStation, cost, departureDate, departureTime, arrivalDate, arrivalTime));
                out.print("Train Created");
            } catch (SQLException ex) {
                out.print("Can`t create a train,check your trainId or trainNumber they must be unique");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}


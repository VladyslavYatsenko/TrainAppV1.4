package servlets;

import DAO.daoFactory.DAOFactory;
import DAO.interfaces.TrainDAO;
import classes.train.Train;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/UsersTrainsServlet")
public class UsersTrainsServlet extends HttpServlet {
    private List<Train> fullTrainsList = new LinkedList<Train>();
    private List<Train> usersTrainsList = new LinkedList<>();
    DAOFactory daoFactory;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        daoFactory=new DAOFactory();
        TrainDAO trainDAO=daoFactory.createTrainDao();
        try{
            trainDAO.initTrainsList();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        usersTrainsList=new LinkedList<>();
        fullTrainsList=trainDAO.getTrainsList();
        System.out.println("Full trains list: "+fullTrainsList);
        String initialStation = request.getParameter("initialStation");
        String endStation = request.getParameter("endStation");
        String date = request.getParameter("date");
        String time = request.getParameter("time");
        LocalTime userTime= LocalTime.parse(time);
        for (Train train : fullTrainsList) {
            LocalTime trainTime=LocalTime.parse(train.getDepartureTime());
            if (initialStation.equals(train.getInitialStation())
                    && endStation.equals(train.getEndStation())
                    && date.equals(train.getDepartureDate())
                    && trainTime.isAfter(userTime)) {
                usersTrainsList.add(train);
                System.out.println(usersTrainsList);
            }
        }
        if (usersTrainsList.size() == 0) {
            String info="No available trains on your parameters";
            out.println(info);
        }else{
            request.setAttribute("trainsList", usersTrainsList);
            RequestDispatcher rd = request.getRequestDispatcher("/registrationPage.jsp");
            rd.forward(request, response);
        }

    }
}

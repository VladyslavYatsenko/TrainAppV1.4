package servlets;

import DAO.interfaces.PassangerDAO;
import DAO.interfaces.TrainDAO;
import classes.passanger.Passanger;
import classes.train.Train;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/TicketRegistrationServlet")
public class TicketRegistrationServlet extends HttpServlet {
    DAOFactory daoFactory;
    Train userTrain;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        daoFactory=new DAOFactory();
        PassangerDAO passangerDAO=daoFactory.createPassangerDao();
        TrainDAO trainDAO=daoFactory.createTrainDao();
        int trainId=Integer.parseInt(request.getParameter("trainId"));
        String firstName=request.getParameter("firstName");
        String lastName=request.getParameter("lastName");
        try{
            passangerDAO.createPassanger(new Passanger(firstName,lastName,trainId));
            trainDAO.initTrainsList();
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        for(Train train:trainDAO.getTrainsList()){
            if(trainId==train.getTrainId()){
                userTrain=train;
            }
        }
        request.setAttribute("userTrain",userTrain);
        request.setAttribute("firstName",firstName);
        request.setAttribute("lastName",lastName);
        getServletContext().getRequestDispatcher("/settlementPage.jsp").forward(request, response);
    }
}

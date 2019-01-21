package servlets;

import DAO.daoFactory.DAOFactory;
import DAO.interfaces.TrainDAO;
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
import java.util.Set;
import java.util.TreeSet;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
    Set<String> trainsInitialStation;
    Set<String> trainsEndStation;
    List<Train> fullTrainsList=new ArrayList<>();
    DAOFactory daoFactory;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        trainsInitialStation=new TreeSet<>();
        trainsEndStation=new TreeSet<>();
        daoFactory=new DAOFactory();
        TrainDAO trainDAO=daoFactory.createTrainDao();
        try{
            trainDAO.initTrainsList();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        fullTrainsList=trainDAO.getTrainsList();
        for(Train t:fullTrainsList){
            trainsInitialStation.add(t.getInitialStation());
            trainsEndStation.add(t.getEndStation());
        }
        request.setAttribute("trainsInitialStation", trainsInitialStation);
        request.setAttribute("trainsEndStation", trainsEndStation);
        getServletContext().getRequestDispatcher("/chooseTrainPage.jsp").forward(request, response);
    }
}

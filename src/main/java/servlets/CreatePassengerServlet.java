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
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet("/CreatePassengerServlet")
public class CreatePassengerServlet extends HttpServlet {
    final static Logger logger = Logger.getLogger(CreatePassengerServlet.class);
    List<Train> trainsList = new ArrayList<>();
    Set<Integer> trainsId=new TreeSet<>();
    List<Passanger> passangerList=new ArrayList<>();
    DaoFactory daoFactory;
    PassangerDao passangerDao;
    TrainDao trainDao;
    OrderDao orderDao;
    public void init()  {
        daoFactory=new MySqlDaoFactory();
        passangerDao=daoFactory.createPassangerDao();
        trainDao=daoFactory.createTrainDao();
        orderDao=daoFactory.createOrderDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            trainsList=trainDao.initTrainsList();

            for (Train t : trainsList) {
                trainsId.add(t.getTrainId());
            }
            request.setAttribute("trainsList", trainsList);
            request.setAttribute("trainsId",trainsId);

            getServletContext().getRequestDispatcher("/createPassengerPage.jsp").forward(request, response);

        } catch (DataAccessException ex) {
            logger.error(ex.getMessage());
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        try{
            String firstName=request.getParameter("firstName");
            String lastName=request.getParameter("lastName");
            int trainId=Integer.parseInt(request.getParameter("trainId"));
            if(firstName.length() == 0 || !firstName.matches("^\\D*$") || lastName.length()==0 || !lastName.matches("^\\D*$")){
                out.print("Can`t create a passenger,check yours parameters");
            }else{
                passangerDao.createPassanger(new Passanger(firstName,lastName,trainId));
                passangerList=passangerDao.initPassengersList();
                orderDao.createOrder(passangerList.get(passangerList.size()-1));
                out.print("Passenger was created everything is fine");
            }
        }catch (DataAccessException ex){
            logger.error("Can`t create a passenger");
        }
    }
}

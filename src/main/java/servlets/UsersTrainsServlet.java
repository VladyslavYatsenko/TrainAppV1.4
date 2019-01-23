package servlets;

import classes.train.Train;
import com.railway.dao.DaoFactory;
import com.railway.dao.TrainDao;
import com.railway.dao.mysql.impl.DataAccessException;
import com.railway.dao.mysql.impl.MySqlDaoFactory;
import org.apache.log4j.Logger;

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
    DaoFactory daoFactory;
    TrainDao trainDao;
    final static Logger logger=Logger.getLogger(UsersTrainsServlet.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    public void init(){
        daoFactory=new MySqlDaoFactory();
        trainDao=daoFactory.createTrainDao();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        init();
        usersTrainsList=new LinkedList<>();
        try{
            fullTrainsList=trainDao.initTrainsList();
            logger.info("Full trains list: "+fullTrainsList);
        }catch (DataAccessException ex){
            logger.error("Data Access Exception"+ex.getErrorCode());
        }
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
                logger.info("Users trains list is"+usersTrainsList);
            }
        }
        if (usersTrainsList.size() == 0) {
            String info="No available trains on your parameters";
            out.println(info);
            logger.warn("usersTrainsList is empty");
        }else{
            request.setAttribute("trainsList", usersTrainsList);
            RequestDispatcher rd = request.getRequestDispatcher("/registrationPage.jsp");
            rd.forward(request, response);
        }

    }
}

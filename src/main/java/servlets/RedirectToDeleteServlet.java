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
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@WebServlet("/RedirectToDeleteServlet")
public class RedirectToDeleteServlet extends HttpServlet {
    final static Logger logger = Logger.getLogger(DeleteTrainServlet.class);
    List<Train> trainsList = new LinkedList<>();
    Set<Integer> trainsId = new TreeSet<>();
    DaoFactory daoFactory;
    TrainDao trainDao;

    public void init() {
        daoFactory = new MySqlDaoFactory();
        trainDao = daoFactory.createTrainDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            trainsList = trainDao.initTrainsList();
            for (Train t : trainsList) {
                trainsId.add(t.getTrainId());
            }
            request.setAttribute("trainsId", trainsId);
            request.setAttribute("trainsList", trainsList);
            getServletContext().getRequestDispatcher("/deleteTrainPage.jsp").forward(request, response);
        } catch (DataAccessException ex) {
            logger.error(ex.getMessage());
        }
    }
}

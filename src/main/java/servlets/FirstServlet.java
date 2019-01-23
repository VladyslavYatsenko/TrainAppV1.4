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
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
    final static Logger logger=Logger.getLogger(FirstServlet.class);
    Set<String> trainsInitialStation;
    Set<String> trainsEndStation;
    List<Train> fullTrainsList = new ArrayList<>();
    DaoFactory daoFactory;
    TrainDao trainsDao;

    public void init() {
        daoFactory = new MySqlDaoFactory();
        trainsDao = daoFactory.createTrainDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        init();
        trainsInitialStation = new TreeSet<>();
        trainsEndStation = new TreeSet<>();

        try {
            fullTrainsList=trainsDao.initTrainsList();
        } catch (DataAccessException ex) {
            logger.error("Data Access Exception "+ex.getErrorCode());
        }
        for (Train t : fullTrainsList) {
            trainsInitialStation.add(t.getInitialStation());
            trainsEndStation.add(t.getEndStation());
        }
        logger.info("TrainsInitialStation -> "+trainsInitialStation);
        logger.info("TrainsEndStation -> "+trainsEndStation);
        request.setAttribute("trainsInitialStation", trainsInitialStation);
        request.setAttribute("trainsEndStation", trainsEndStation);
        getServletContext().getRequestDispatcher("/chooseTrainPage.jsp").forward(request, response);
    }
}

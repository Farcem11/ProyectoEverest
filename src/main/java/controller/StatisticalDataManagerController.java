package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.StatisticalDataManager;
import service.StatisticalDataManagerService;
import com.google.gson.Gson; 
import com.google.gson.GsonBuilder;  
import common.StatisticalFileManager;

@WebServlet(urlPatterns = {"getStatisticalDataManager", "saveStatisticalDataManager", "updateStatisticalDataManager"}, loadOnStartup = 1) 
public class StatisticalDataManagerController extends HttpServlet 
{
    private final String getUrlRequest = "/getStatisticalDataManager";
    private final String saveUrlRequest = "/saveStatisticalDataManager";
    private final String updateUrlRequest = "/updateStatisticalDataManager";

    private final StatisticalDataManagerService statisticalDataManagerService = new StatisticalDataManagerService();
    private final GsonBuilder builder = new GsonBuilder(); 
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        if(getUrlRequest.equals(request.getServletPath()))
        {
            builder.setPrettyPrinting(); 
            Gson gson = builder.create();
            List<StatisticalDataManager> statisticalDataManagers = statisticalDataManagerService.getStatisticalDataManagers();
            response.getWriter().print(gson.toJson(statisticalDataManagers));
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        if(saveUrlRequest.equals(request.getServletPath()))
        {
            String pathFile = request.getParameter("pathFile");
            StatisticalDataManager statisticalDataManager = StatisticalFileManager.getInstance().validateAndParseStatisticalData(pathFile);
            statisticalDataManagerService.saveStatisticalDataManagers(statisticalDataManager);
        }
    }
}

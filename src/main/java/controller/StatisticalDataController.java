package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.StatisticalData;
import service.StatisticalDataService;
import com.google.gson.Gson; 
import com.google.gson.GsonBuilder;  
import common.StatisticalFileManager;

@WebServlet(urlPatterns = {"getStatisticalData", "getStatisticalData", "updateStatisticalData", "deleteStatisticalData"}, loadOnStartup = 1) 
public class StatisticalDataController extends HttpServlet 
{
    private final String getUrlRequest = "/getStatisticalData";
    private final String saveUrlRequest = "/getStatisticalData";
    private final String updateUrlRequest = "/updateStatisticalData";
    private final String deleteUrlRequest = "/deleteStatisticalData";
    
    private final StatisticalDataService statisticalDataManagerService = new StatisticalDataService();
    private final GsonBuilder builder = new GsonBuilder(); 
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        if(getUrlRequest.equals(request.getServletPath()))
        {
            builder.setPrettyPrinting(); 
            Gson gson = builder.create();
            List<StatisticalData> statisticalDataManagers = statisticalDataManagerService.getStatisticalsData();
            response.getWriter().print(gson.toJson(statisticalDataManagers));
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        if(saveUrlRequest.equals(request.getServletPath()))
        {
            String pathFile = request.getParameter("pathFile");
            StatisticalData statisticalDataManager = StatisticalFileManager.getInstance().validateAndParseStatisticalData(pathFile);
            statisticalDataManagerService.saveStatisticalData(statisticalDataManager);
        }
        else if(updateUrlRequest.equals(request.getServletPath()))
        {
            String pathFile = request.getParameter("pathFile");
            StatisticalData statisticalDataManager = StatisticalFileManager.getInstance().validateAndParseStatisticalData(pathFile);
            statisticalDataManagerService.saveStatisticalData(statisticalDataManager);
        }
        else if(deleteUrlRequest.equals(request.getServletPath()))
        {
            Long id = Long.parseLong(request.getParameter("id"));
            statisticalDataManagerService.deleteStatisticalData(id);
        }
    }
}

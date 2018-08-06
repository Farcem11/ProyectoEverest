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
import common.StatisticalDataManager;
import common.StatisticalFileManager;
import database.MySqlConnection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(urlPatterns = {"getStatisticalData", "saveStatisticalData", "updateStatisticalData", "deleteStatisticalData"}, loadOnStartup = 1) 
public class StatisticalDataController extends HttpServlet 
{
    private final String getUrlRequest = "/getStatisticalData";
    private final String saveUrlRequest = "/saveStatisticalData";
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
            response.getWriter().print(gson.toJson(StatisticalDataManager.getInstance().statisticalDataMap));
        }
        else
        {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        try 
        {
            if(saveUrlRequest.equals(request.getServletPath()))
            {
                String pathFile = request.getParameter("pathFile");
                StatisticalData statisticalDataManager = StatisticalFileManager.getInstance().parseFileToStatisticalData(pathFile);
                Long uniqueDatabaseId = statisticalDataManagerService.saveStatisticalData(statisticalDataManager);
                statisticalDataManager.setId(uniqueDatabaseId);
                StatisticalDataManager.getInstance().statisticalDataMap.put(uniqueDatabaseId, statisticalDataManager);
            }
            else if(updateUrlRequest.equals(request.getServletPath()))
            {
                Long id = Long.parseLong(request.getParameter("id"));
                String pathFile = request.getParameter("pathFile");
                StatisticalData newStatisticalDataManager = StatisticalFileManager.getInstance().parseFileToStatisticalData(pathFile);
                newStatisticalDataManager.setId(id);
                statisticalDataManagerService.updateStatisticalData(newStatisticalDataManager);
                StatisticalDataManager.getInstance().statisticalDataMap.put(id, newStatisticalDataManager);                
            }
            else if(deleteUrlRequest.equals(request.getServletPath()))
            {
                Long id = Long.parseLong(request.getParameter("id"));
                statisticalDataManagerService.deleteStatisticalData(id);
                StatisticalDataManager.getInstance().statisticalDataMap.remove(id);
            }
            else
            {
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
            }
        }
        catch (SQLException ex) 
        {
            Logger.getLogger(MySqlConnection.class.getName()).log(Level.SEVERE, "SQL Exception {0}", ex.getMessage());
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage());
        }
    }
}

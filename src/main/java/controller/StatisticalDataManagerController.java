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

@WebServlet(name = "StatisticalDataManagerController", urlPatterns = {"StatisticalDataManager"}, loadOnStartup = 1) 
public class StatisticalDataManagerController extends HttpServlet 
{
    private final StatisticalDataManagerService statisticalDataManagerService = new StatisticalDataManagerService();
    private final GsonBuilder builder = new GsonBuilder(); 
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        builder.setPrettyPrinting(); 
        Gson gson = builder.create();
        List<StatisticalDataManager> statisticalDataManagers = statisticalDataManagerService.getStatisticalDataManagers();
        response.getWriter().print(gson.toJson(statisticalDataManagers,StatisticalDataManager.class));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        String name = request.getParameter("name");
        if (name == null) name = "World";
        request.setAttribute("user", name);
        request.getRequestDispatcher("response.jsp").forward(request, response); 
    }
}
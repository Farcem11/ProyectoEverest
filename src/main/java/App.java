import common.StatisticalFileManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.StatisticalDataManager;

import service.StatisticalDataManagerService;

public class App
{
    private static StatisticalDataManagerService statisticalDataManagerService = new StatisticalDataManagerService();
    
    public static void main(String[] args)
    {
        String pathFile = "C:\\GitLab-Runner\\builds\\b4713e69\\0\\sarcem1111\\ProyectoEverest\\files\\numbers.txt";
        StatisticalDataManager statisticalDataManager = StatisticalFileManager.getInstance().validateAndParseStatisticalData(pathFile);
            
    }
}

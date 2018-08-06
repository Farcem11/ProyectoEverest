import common.StatisticalFileManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.StatisticalData;

import service.StatisticalDataService;

public class App
{
    private static StatisticalDataService statisticalDataManagerService = new StatisticalDataService();
    
    public static void main(String[] args)
    {
        String pathFile = "C:\\GitLab-Runner\\builds\\b4713e69\\0\\sarcem1111\\ProyectoEverest\\files\\numbers.txt";
        StatisticalData statisticalDataManager = StatisticalFileManager.getInstance().validateAndParseStatisticalData(pathFile);
            
    }
}

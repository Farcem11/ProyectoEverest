

import java.sql.SQLException;
import logic.StatisticalFileManager;
import model.StatisticalDataManager;
import service.StatisticalDataManagerService;

public class App
{
    static StatisticalDataManagerService statisticalDataManagerService = new StatisticalDataManagerService();
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException 
    {
        StatisticalDataManager statisticalDataManager = StatisticalFileManager.getInstance().validateAndParseStatisticalData("files/numbers.txt");
        statisticalDataManagerService.setStatisticalDataManagers(statisticalDataManager);
    }
}

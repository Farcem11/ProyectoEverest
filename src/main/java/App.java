import java.sql.SQLException;
import java.util.List;
import logic.statistical.StatisticalFileManager;
import model.object.StatisticalDataManager;
import model.service.StatisticalDataManagerService;

public class App
{
    static StatisticalDataManagerService statisticalDataManagerService = new StatisticalDataManagerService();
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException 
    {
        StatisticalDataManager statisticalDataManager = StatisticalFileManager.getInstance().validateAndParseStatisticalData("files/numbers.txt");
        statisticalDataManagerService.setStatisticalDataManagers(statisticalDataManager);
    }
}

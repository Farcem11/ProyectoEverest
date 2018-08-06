import java.sql.SQLException;
import common.StatisticalFileManager;
import java.util.List;
import model.StatisticalDataManager;
import service.StatisticalDataManagerService;

public class App
{
    private static StatisticalDataManagerService statisticalDataManagerService = new StatisticalDataManagerService();
    
    public static void main(String[] args)
    {
        List<StatisticalDataManager> statisticalDataManagers = statisticalDataManagerService.getStatisticalDataManagers();
        
    }
}

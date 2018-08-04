import java.sql.SQLException;
import java.util.List;
import model.database.object.StatisticalDataManager;
import model.database.service.StatisticalDataManagerService;

public class App 
{
    static StatisticalDataManagerService statisticalDataManagerService = new StatisticalDataManagerService();
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException 
    {
        List<StatisticalDataManager> s = statisticalDataManagerService.getStatisticalDataManagers();
    }
}

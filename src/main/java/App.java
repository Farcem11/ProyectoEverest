import java.sql.SQLException;
import model.database.service.StatisticalDataManagerService;

public class App 
{
    static StatisticalDataManagerService statisticalDataManagerService = new StatisticalDataManagerService();
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException 
    {
        statisticalDataManagerService.getStatisticalDataManagers();
    }
}

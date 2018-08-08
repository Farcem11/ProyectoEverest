package common;

import java.sql.SQLException;
import java.util.Collections;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.StatisticalData;
import service.StatisticalDataService;

public class StatisticalDataManager 
{
    private static final StatisticalDataManager instance = new StatisticalDataManager();
    private final StatisticalDataService statisticalDataService = new StatisticalDataService();
    public Map<Long, StatisticalData> statisticalDataMap;
    
    private StatisticalDataManager()
    {
        try 
        {
            this.statisticalDataMap = statisticalDataService.getStatisticalDataMap();
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(StatisticalDataManager.class.getName()).log(Level.SEVERE, "SQL Exception {0}", ex.getMessage());
            this.statisticalDataMap = Collections.emptyMap();
        }
    }

    public static StatisticalDataManager getInstance()
    {
        return instance;
    }
}

package common;

import java.util.Map;
import model.StatisticalData;
import service.StatisticalDataService;

public class StatisticalDataManager 
{
    private static final StatisticalDataManager instance = new StatisticalDataManager();
    private final StatisticalDataService statisticalDataService = new StatisticalDataService();
    private final Map<Long, StatisticalData> statisticalDataMap = statisticalDataService.getStatisticalDataMap();
    
    private StatisticalDataManager(){}

    public static StatisticalDataManager getInstance()
    {
        return instance;
    }

	public Map<Long, StatisticalData> getStatisticalDataMap() 
	{
		return statisticalDataMap;
	}
}

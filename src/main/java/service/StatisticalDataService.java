package service;

import dao.StatisticalDataDao;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import model.StatisticalData;

public class StatisticalDataService 
{
    private final StatisticalDataDao statisticalDataDao = new StatisticalDataDao();
    
    public Map<Long, StatisticalData> getStatisticalDataMap() throws SQLException
    {
        Map<Long, StatisticalData> statisticalDataMap = new HashMap<>(); 
        for(StatisticalData statisticalData : statisticalDataDao.get())
        {
            statisticalDataMap.put(statisticalData.getId(), statisticalData);
        }
        return statisticalDataMap;
    }
    
    public Long saveStatisticalData(StatisticalData statisticalDataManager) throws SQLException
    {
        return statisticalDataDao.save(statisticalDataManager);
    }
    
    public void updateStatisticalData(StatisticalData newStatisticalDataManager) throws SQLException
    {
        statisticalDataDao.update(newStatisticalDataManager);
    }
    
    public void deleteStatisticalData(Long idStatisticalDataManager) throws SQLException
    {
        statisticalDataDao.delete(idStatisticalDataManager);
    }
}

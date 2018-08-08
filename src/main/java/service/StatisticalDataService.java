package service;

import dao.StatisticalDataDao;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import common.StatisticalDataManager;
import model.StatisticalData;

public class StatisticalDataService 
{
    private final StatisticalDataDao statisticalDataDao = new StatisticalDataDao();
    
    public Map<Long, StatisticalData> getStatisticalDataMap()
    {
        Map<Long, StatisticalData> statisticalDataMap = new HashMap<>(); 
        try 
        {
			for(StatisticalData statisticalData : statisticalDataDao.get())
			{
			    statisticalDataMap.put(statisticalData.getId(), statisticalData);
			}
			return statisticalDataMap;
		} 
        catch (SQLException ex) 
        {
        	Logger.getLogger(StatisticalDataManager.class.getName()).log(Level.SEVERE, "SQL Exception {0}", ex);
            return Collections.emptyMap();
		}
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

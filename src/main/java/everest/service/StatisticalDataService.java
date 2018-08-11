package everest.service;

import everest.dao.StatisticalDataDao;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import everest.model.StatisticalData;

@Service
public class StatisticalDataService 
{
    @Autowired
    private StatisticalDataDao statisticalDataDao;
    
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
            Logger.getLogger(StatisticalDataDao.class.getName()).log(Level.SEVERE, "SQL Exception {0}", ex);
            return Collections.emptyMap();
        }
    }
    
    public Long saveStatisticalData(StatisticalData newStatisticalData) throws SQLException
    {
        return statisticalDataDao.save(newStatisticalData);
    }
    
    public void updateStatisticalData(StatisticalData newStatisticalData) throws SQLException
    {
        statisticalDataDao.update(newStatisticalData);
    }
    
    public void deleteStatisticalData(Long newStatisticalData) throws SQLException
    {
        statisticalDataDao.delete(newStatisticalData);
    }
}

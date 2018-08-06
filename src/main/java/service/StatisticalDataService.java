package service;

import java.util.List;
import dao.StatisticalDataDao;
import model.StatisticalData;

public class StatisticalDataService 
{
    private final StatisticalDataDao statisticalDataDao = new StatisticalDataDao();
    
    public List<StatisticalData> getStatisticalsData()
    {
        return statisticalDataDao.get();
    }
    
    public void saveStatisticalData(StatisticalData statisticalDataManager)
    {
        statisticalDataDao.save(statisticalDataManager);
    }
    
    public void updateStatisticalData(StatisticalData statisticalDataManager)
    {
        statisticalDataDao.update(statisticalDataManager);
    }
    
    public void deleteStatisticalData(Long idStatisticalDataManager)
    {
        statisticalDataDao.delete(idStatisticalDataManager);
    }
}

package service;

import java.util.List;
import dao.StatisticalDataManagerDao;
import model.StatisticalDataManager;

public class StatisticalDataManagerService 
{
    private final StatisticalDataManagerDao statisticalDataManagerDao = new StatisticalDataManagerDao();
    
    public List<StatisticalDataManager> getStatisticalDataManagers()
    {
        return statisticalDataManagerDao.get();
    }
    
    public void saveStatisticalDataManagers(StatisticalDataManager statisticalDataManager)
    {
        statisticalDataManagerDao.save(statisticalDataManager);
    }
    
    public void updateStatisticalDataManagers(StatisticalDataManager statisticalDataManager)
    {
        statisticalDataManagerDao.update(statisticalDataManager);
    }
}

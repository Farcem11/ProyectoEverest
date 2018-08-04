package model.service;

import java.util.List;
import model.dao.StatisticalDataManagerDao;
import model.object.StatisticalDataManager;

public class StatisticalDataManagerService 
{
    private final StatisticalDataManagerDao statisticalDataManagerDao = new StatisticalDataManagerDao();
    
    public List<StatisticalDataManager> getStatisticalDataManagers()
    {
        return statisticalDataManagerDao.get();
    }
    
    public void setStatisticalDataManagers(StatisticalDataManager statisticalDataManager)
    {
        statisticalDataManagerDao.save(statisticalDataManager);
    }
}

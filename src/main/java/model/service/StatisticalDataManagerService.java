package model.service;

import java.util.List;
import model.dao.StatisticalDataManagerDao;
import model.object.StatisticalDataManager;

public class StatisticalDataManagerService 
{
    StatisticalDataManagerDao statisticalDataManagerDao = new StatisticalDataManagerDao();
    
    public List<StatisticalDataManager> getStatisticalDataManagers()
    {
        return statisticalDataManagerDao.get();
    }
}

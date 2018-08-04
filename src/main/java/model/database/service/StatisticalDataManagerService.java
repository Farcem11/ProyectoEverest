package model.database.service;

import java.util.List;
import model.database.dao.StatisticalDataManagerDao;
import model.database.object.StatisticalDataManager;

public class StatisticalDataManagerService 
{
    StatisticalDataManagerDao statisticalDataManagerDao = new StatisticalDataManagerDao();
    
    public List<StatisticalDataManager> getStatisticalDataManagers()
    {
        return statisticalDataManagerDao.get();
    }
}

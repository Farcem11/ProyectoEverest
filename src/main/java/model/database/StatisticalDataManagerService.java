package model.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import model.StatisticalDataManager;

public abstract class StatisticalDataManagerService 
{
    public List<StatisticalDataManager> getStatisticalDataManagers() throws SQLException
    {
        return null;
    }
}

package model.database.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.Statistical.StatisticalFileManager;
import model.database.object.StatisticalDataManager;
import model.MySqlConnection;

public class StatisticalDataManagerDao implements DataAcessObject<StatisticalDataManager>
{
    @Override
    public List<StatisticalDataManager> get() 
    {
        try 
        {
            List<StatisticalDataManager> statisticalDataManager = new ArrayList<>();
            Statement statement = MySqlConnection.getInstance().getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("call getStatisticalDataManagers()");
            
            while(resultSet.next())
            {
                String fileName = resultSet.getString("fileName");
                String filePath = resultSet.getString("filePath");
                int total = resultSet.getInt("total");
                int max = resultSet.getInt("max");
                int min = resultSet.getInt("min");
                double[] numbers = StatisticalFileManager.getInstance().castStringToNumbers(resultSet.getString("numbers"));

                statisticalDataManager.add(new StatisticalDataManager(numbers,total,max,min,fileName,filePath));
            }
            
            resultSet.close();
            statement.close();
            return statisticalDataManager;
        } 
        catch (SQLException ex) 
        {
           Logger.getLogger(MySqlConnection.class.getName()).log(Level.SEVERE, "SQL Exception {0}", ex.getMessage());
           return Collections.EMPTY_LIST;
        }
    }

    @Override
    public void save(StatisticalDataManager object) 
    {

    }

    @Override
    public void update(StatisticalDataManager object) 
    {

    }    
}

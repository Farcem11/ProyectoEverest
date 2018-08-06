package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import common.StatisticalFileManager;
import model.StatisticalDataManager;
import database.MySqlConnection;

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
                String fileContent = resultSet.getString("fileContent");
                double total = resultSet.getDouble("total");
                double max = resultSet.getDouble("max");
                double min = resultSet.getDouble("min");
                double[] numbers = StatisticalFileManager.getInstance().castStringToNumbers(resultSet.getString("fileContent"));

                statisticalDataManager.add(new StatisticalDataManager(numbers, total, max, min, fileName, filePath, fileContent));
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
        try 
        {            
            PreparedStatement preparedStatement = MySqlConnection.getInstance().getConnection().prepareStatement("call createStatisticalDataManagers(?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, object.getFileName());
            preparedStatement.setString(2, object.getFilePath());
            preparedStatement.setDouble(3, object.getTotal());
            preparedStatement.setDouble(4, object.getMax());
            preparedStatement.setDouble(5, object.getMin());
            preparedStatement.setString(6, object.getFileContent());
            
            preparedStatement.execute();
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(MySqlConnection.class.getName()).log(Level.SEVERE, "SQL Exception {0}", ex.getMessage());
        }
    }

    @Override
    public void update(StatisticalDataManager object) 
    {
        try 
        {            
            PreparedStatement preparedStatement = MySqlConnection.getInstance().getConnection().prepareStatement("call updateStatisticalDataManagers(?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, object.getFileName());
            preparedStatement.setString(2, object.getFilePath());
            preparedStatement.setDouble(3, object.getTotal());
            preparedStatement.setDouble(4, object.getMax());
            preparedStatement.setDouble(5, object.getMin());
            preparedStatement.setString(6, object.getFileContent());
            
            preparedStatement.execute();
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(MySqlConnection.class.getName()).log(Level.SEVERE, "SQL Exception {0}", ex.getMessage());
        }
    }    
}

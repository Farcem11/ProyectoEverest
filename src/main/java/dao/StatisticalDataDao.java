package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import common.StatisticalFileManager;
import model.StatisticalData;
import database.MySqlConnection;
import java.io.File;

public class StatisticalDataDao implements DataAcessObject<StatisticalData>
{
    @Override
    public List<StatisticalData> get() throws SQLException
    {
        List<StatisticalData> statisticalDataList = new ArrayList<>();
        try(Statement statement = MySqlConnection.getInstance().getConnection().createStatement())
        {
            try(ResultSet resultSet = statement.executeQuery("call getStatisticalDataManagers()"))
            {
                while(resultSet.next())
                {
                    long id = resultSet.getLong("idStatisticalDataManager");
                    File file = new File(resultSet.getString("filePath"));
                    String fileContent = resultSet.getString("fileContent");
                    double total = resultSet.getDouble("total");
                    double max = resultSet.getDouble("max");
                    double min = resultSet.getDouble("min");
                    double[] numbers = StatisticalFileManager.getInstance().castStringToNumbers(resultSet.getString("fileContent"));

                    statisticalDataList.add(new StatisticalData(id, numbers, total, max, min, file, fileContent));
                }
                return statisticalDataList;		
            }
        }
    }

    @Override
    public Long save(StatisticalData object) throws SQLException
    {
        String procedure = "call saveStatisticalDataManagers(?, ?, ?, ?, ?)";
        try(PreparedStatement preparedStatement = MySqlConnection.getInstance().getConnection().prepareStatement(procedure))
        {
            preparedStatement.setString(1, object.getFile().getAbsolutePath());
            preparedStatement.setDouble(2, object.getTotal());
            preparedStatement.setDouble(3, object.getMax());
            preparedStatement.setDouble(4, object.getMin());
            preparedStatement.setString(5, object.getFileContent());

            try(ResultSet resultSet = preparedStatement.executeQuery())
            {
                if(resultSet.next())
                {
                    return resultSet.getLong("id");
                }
                else 
                {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }	
            }
        }
    }

    @Override
    public void update(StatisticalData object) throws SQLException
    {
        try(PreparedStatement preparedStatement = MySqlConnection.getInstance().getConnection().prepareStatement("call updateStatisticalDataManagers(?, ?, ?, ?, ?, ?)"))
        {
            preparedStatement.setLong(1, object.getId());
            preparedStatement.setString(2, object.getFile().getAbsolutePath());
            preparedStatement.setDouble(3, object.getTotal());
            preparedStatement.setDouble(4, object.getMax());
            preparedStatement.setDouble(5, object.getMin());
            preparedStatement.setString(6, object.getFileContent());

            preparedStatement.execute();	
        }
    }    

    @Override
    public void delete(Long id) throws SQLException
    {
        try(PreparedStatement preparedStatement = MySqlConnection.getInstance().getConnection().prepareStatement("call deleteStatisticalDataManagers(?)"))
        {
            preparedStatement.setLong(1, id);            
            preparedStatement.execute();	
        }
    }
}
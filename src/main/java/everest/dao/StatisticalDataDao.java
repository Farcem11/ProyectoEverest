package everest.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import everest.common.StatisticalDataManager;
import everest.model.StatisticalData;
import everest.database.MySqlConnection;
import java.sql.SQLIntegrityConstraintViolationException;

@Repository 
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
                    String name = resultSet.getString("name");
                    String numbers = resultSet.getString("numbers");
                    double total = resultSet.getDouble("total");
                    double max = resultSet.getDouble("max");
                    double min = resultSet.getDouble("min");
                    double[] numbersArray = StatisticalDataManager.getInstance().castStringToNumbers(resultSet.getString("numbers"));

                    statisticalDataList.add(new StatisticalData(id, name, numbersArray, numbers, total, max, min));
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
            preparedStatement.setString(1, object.getName());
            preparedStatement.setDouble(2, object.getTotal());
            preparedStatement.setDouble(3, object.getMax());
            preparedStatement.setDouble(4, object.getMin());
            preparedStatement.setString(5, object.getNumbers());

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
        catch(SQLIntegrityConstraintViolationException ex)
        {
            throw new SQLIntegrityConstraintViolationException("That file already exists");
        }
        catch(NullPointerException ex)
        {
            throw new NullPointerException("The data can not be null");
        }
    }

    @Override
    public void update(StatisticalData object) throws SQLException
    {
        try(PreparedStatement preparedStatement = MySqlConnection.getInstance().getConnection().prepareStatement("call updateStatisticalDataManagers(?, ?, ?, ?, ?, ?)"))
        {
            preparedStatement.setLong(1, object.getId());
            preparedStatement.setString(2, object.getName());
            preparedStatement.setDouble(3, object.getTotal());
            preparedStatement.setDouble(4, object.getMax());
            preparedStatement.setDouble(5, object.getMin());
            preparedStatement.setString(6, object.getNumbers());

            preparedStatement.execute();	
        }
        catch(SQLIntegrityConstraintViolationException ex)
        {
            throw new SQLIntegrityConstraintViolationException("That file already exists");
        }
        catch(NullPointerException ex)
        {
            throw new NullPointerException("The data can not be null");
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

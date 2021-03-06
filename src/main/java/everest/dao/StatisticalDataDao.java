package everest.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import everest.common.StatisticalDataManager;
import everest.database.MySqlDatabase;
import everest.model.StatisticalData;
import java.sql.SQLIntegrityConstraintViolationException;

@Repository 
public class StatisticalDataDao implements DataAcessObject<StatisticalData>
{
	@Autowired
	private StatisticalDataManager statisticalDataManager;
	
	@Autowired
	private MySqlDatabase database;

    @Transactional
    @Override
    public List<StatisticalData> get() throws SQLException
    {
        List<StatisticalData> statisticalDataList = new ArrayList<>();
        try(Statement statement = database.getConnection().createStatement())
        {
            try(ResultSet resultSet = statement.executeQuery("call getStatisticalsData()"))
            {
                while(resultSet.next())
                {
                    long id = resultSet.getLong("idStatisticalData");
                    String name = resultSet.getString("name");
                    String numbers = resultSet.getString("numbers");
                    double total = resultSet.getDouble("total");
                    double max = resultSet.getDouble("max");
                    double min = resultSet.getDouble("min");
                    double[] numbersArray = statisticalDataManager.castStringToNumbers(resultSet.getString("numbers"));

                    statisticalDataList.add(new StatisticalData(id, name, numbersArray, numbers, total, max, min));
                }
                return statisticalDataList;		
            }
        }
    }

    @Transactional
    @Override
    public Long save(StatisticalData object) throws SQLException
    {
        String procedure = "call saveStatisticalData(?, ?, ?, ?, ?)";
        try(PreparedStatement preparedStatement = database.getConnection().prepareStatement(procedure))
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

    @Transactional
    @Override
    public void update(StatisticalData object) throws SQLException
    {
        try(PreparedStatement preparedStatement = database.getConnection().prepareStatement("call updateStatisticalData(?, ?, ?, ?, ?, ?)"))
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

    @Transactional
    @Override
    public void delete(Long id) throws SQLException
    {
        try(PreparedStatement preparedStatement = database.getConnection().prepareStatement("call deleteStatisticalData(?)"))
        {
            preparedStatement.setLong(1, id);
            preparedStatement.execute();	
        }
    }
}

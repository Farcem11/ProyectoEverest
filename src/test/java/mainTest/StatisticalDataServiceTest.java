package mainTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import common.StatisticalDataManager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Map;

import model.StatisticalData;
import service.StatisticalDataService;

public class StatisticalDataServiceTest 
{
	int initialDatabaseNumberOfRows;
	
	StatisticalDataService statisticalDataService = new StatisticalDataService();
	StatisticalData savedStatisticalData;
	Map<Long, StatisticalData> map;
	Long lastInsertedId;
	
	@Test
	@DisplayName("Database should not be empty")
    public void emptyDatabaseTest() throws IOException
    {
		map = statisticalDataService.getStatisticalDataMap();
		assertFalse(map.isEmpty());
    }
	
	@Nested
	class databaseDeleteTest
	{
		@BeforeEach
		@DisplayName("Save initial number of rows and add new record")
	    public void addNewStatisticalManager() throws IOException, SQLException
	    {
			initialDatabaseNumberOfRows = statisticalDataService.getStatisticalDataMap().size();
			savedStatisticalData = StatisticalDataManager.getInstance().validateAndParse("", "1,2,3,4,5");
			lastInsertedId = statisticalDataService.saveStatisticalData(savedStatisticalData);
	    }
		
		@Test
		@DisplayName("Test if database delete the data")
		public void deleteDatabaseTest() throws SQLException, IOException
		{
			statisticalDataService.deleteStatisticalData(lastInsertedId);
			int databaseNumberOfRowsAfterDelete = statisticalDataService.getStatisticalDataMap().size();
			assertEquals(initialDatabaseNumberOfRows, databaseNumberOfRowsAfterDelete);
		}
	}
	
	@Nested
	class databaseSaveTest
	{
		@BeforeEach
		@DisplayName("Save initial number of rows and add new record")
	    public void addNewStatisticalManager() throws IOException, SQLException
	    {
			initialDatabaseNumberOfRows = statisticalDataService.getStatisticalDataMap().size();
			savedStatisticalData = StatisticalDataManager.getInstance().validateAndParse("", "1,2,3,4,5");
			lastInsertedId = statisticalDataService.saveStatisticalData(savedStatisticalData);
			savedStatisticalData.setId(lastInsertedId);
	    }
		
		@Test
		@DisplayName("Test if data is saved correctly")
		public void saveDatabaseDataTest() throws SQLException, IOException
		{
			StatisticalData statisticalDataInTheDatabase = statisticalDataService.getStatisticalDataMap().get(lastInsertedId);
			assertTrue(compareStatisticalDataObjects(savedStatisticalData,statisticalDataInTheDatabase));
		}
		
		@Test
		@DisplayName("Test if save the data")
		public void saveDatabaseTest() throws SQLException, IOException
		{
			int databaseNumberOfRowsAfterSave = statisticalDataService.getStatisticalDataMap().size();
			assertEquals(initialDatabaseNumberOfRows + 1, databaseNumberOfRowsAfterSave);
		}
		
		@AfterEach()
		public void deleteRecord() throws SQLException
		{
			statisticalDataService.deleteStatisticalData(lastInsertedId);
		}
	}
	
	@Nested
	class databaseUpdateTest
	{
		@BeforeEach
		@DisplayName("Save initial number of rows and add new record")
	    public void addNewStatisticalManager() throws IOException, SQLException
	    {
			savedStatisticalData = StatisticalDataManager.getInstance().validateAndParse("Name", "1,2,3,4,5");
			lastInsertedId = statisticalDataService.saveStatisticalData(savedStatisticalData);
	    }
		
		@Test
		@DisplayName("Test if data is updated correctly")
		public void saveDatabaseDataTest() throws SQLException, IOException
		{
			StatisticalData newStatisticalData = StatisticalDataManager.getInstance().validateAndParse("NewFileName", "6,7,8,9,10");
			newStatisticalData.setId(lastInsertedId);
			statisticalDataService.updateStatisticalData(newStatisticalData);
			StatisticalData statisticalDataInTheDatabase = statisticalDataService.getStatisticalDataMap().get(lastInsertedId);
			assertTrue(compareStatisticalDataObjects(newStatisticalData, statisticalDataInTheDatabase));
		}
		
		@AfterEach()
		public void deleteRecord() throws SQLException
		{
			statisticalDataService.deleteStatisticalData(lastInsertedId);
		}
	}
	
	private boolean compareStatisticalDataObjects(StatisticalData statisticalData1, StatisticalData statisticalData2)
	{
		if(statisticalData1.getId() != statisticalData2.getId())
			return false;
		else if(statisticalData1.getMax() != statisticalData2.getMax())
			return false;
		else if(statisticalData1.getMin() != statisticalData2.getMin())
			return false;
		else if(!statisticalData1.getName().equals(statisticalData2.getName()))
			return false;
		else if(!statisticalData1.getNumbers().equals(statisticalData2.getNumbers()))
			return false;
		else if(!Arrays.equals(statisticalData1.getNumbersArray(), statisticalData2.getNumbersArray()))
			return false;
		else if(statisticalData1.getTotal() != statisticalData2.getTotal())
			return false;
		return true;
	}
}

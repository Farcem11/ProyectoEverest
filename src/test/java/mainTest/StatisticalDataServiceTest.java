package mainTest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import common.StatisticalDataManager;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import model.StatisticalData;
import service.StatisticalDataService;

public class StatisticalDataServiceTest 
{
	static int initialDatabaseNumberOfRows;
	
	static StatisticalDataService statisticalDataService = new StatisticalDataService();
	Map<Long, StatisticalData> map;
	static Long lastInsertedId;
	
	@Test
	@BeforeAll
	@DisplayName("Database should not be empty")
    public void emptyDatabaseTest() throws IOException
    {
		map = statisticalDataService.getStatisticalDataMap();
		assertFalse(map.isEmpty());
		initialDatabaseNumberOfRows = map.size();
    }
	
	@Nested
	static
	class databaseDeleteBehavior
	{
		@BeforeAll
		@DisplayName("Test if database save the data")
	    public static void addNewStatisticalManager() throws IOException, SQLException
	    {
			StatisticalData statisticalData = StatisticalDataManager.getInstance().validateAndParse("", "1,2,3,4,5");
			lastInsertedId = statisticalDataService.saveStatisticalData(statisticalData);
	    }
		
		@Test
		@DisplayName("Test if database delete the data")
		public void saveDatabaseTest() throws SQLException, IOException
		{
			statisticalDataService.deleteStatisticalData(lastInsertedId);
			long databaseNumberOfRowsAfterDelete = statisticalDataService.getStatisticalDataMap().size();
			assertEquals(initialDatabaseNumberOfRows, databaseNumberOfRowsAfterDelete);
		}
	}
}

package mainTest;

import everest.Application;
import org.springframework.beans.factory.annotation.Autowired;

import everest.common.StatisticalDataManager;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Arrays;

import everest.model.StatisticalData;
import everest.service.StatisticalDataService;
import java.io.IOException;
import java.sql.SQLException;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
@SpringBootTest(classes = Application.class)
public class StatisticalDataServiceTest
{	
    @Autowired
    private StatisticalDataService statisticalDataService;
    
    @Autowired
	StatisticalDataManager statisticalDataManager;
    
    int initialDatabaseNumberOfRows;

    StatisticalData savedStatisticalData;
    Long lastInsertedId;
    
    @Test
    @DisplayName("Database should not be empty")
    public void emptyDatabaseTest() throws IOException, SQLException
    {
        assertFalse(statisticalDataService.getStatisticalDataMap().isEmpty());
    }
	
    @Test
    @DisplayName("Test if database delete the data")
    public void deleteDatabaseTest() throws SQLException, IOException
    {
        initialDatabaseNumberOfRows = statisticalDataService.getStatisticalDataMap().size();
        savedStatisticalData = statisticalDataManager.validateAndParse("", "1,2,3,4,5");
        lastInsertedId = statisticalDataService.saveStatisticalData(savedStatisticalData);
        statisticalDataService.deleteStatisticalData(lastInsertedId);
        int databaseNumberOfRowsAfterDelete = statisticalDataService.getStatisticalDataMap().size();
        assertEquals(initialDatabaseNumberOfRows, databaseNumberOfRowsAfterDelete);
    }
    
    @Nested
    class databaseNestedTest
    {
        @BeforeEach
        @DisplayName("Save initial number of rows and add new record")
        public void addNewStatisticalManager() throws IOException, SQLException
        {
            initialDatabaseNumberOfRows = statisticalDataService.getStatisticalDataMap().size();
            savedStatisticalData = statisticalDataManager.validateAndParse("", "1,2,3,4,5");
            lastInsertedId = statisticalDataService.saveStatisticalData(savedStatisticalData);
            savedStatisticalData.setId(lastInsertedId);
        }

        @Test
        @DisplayName("Test if data is saved correctly")
        public void saveDatabaseDataTest() throws SQLException, IOException
        {
            StatisticalData statisticalDataInTheDatabase = statisticalDataService.getStatisticalDataMap().get(lastInsertedId);
            assertTrue(compareStatisticalDataObjects(savedStatisticalData, statisticalDataInTheDatabase));
        }

        @Test
        @DisplayName("Test if save the data")
        public void saveDatabaseTest() throws SQLException, IOException
        {
            int databaseNumberOfRowsAfterSave = statisticalDataService.getStatisticalDataMap().size();
            assertEquals(initialDatabaseNumberOfRows + 1, databaseNumberOfRowsAfterSave);
        }
        
        @Test
        @DisplayName("Test if data is updated correctly")
        public void updateDatabaseDataTest() throws SQLException, IOException
        {
            StatisticalData newStatisticalData = statisticalDataManager.validateAndParse("NewFileName", "6,7,8,9,10");
            newStatisticalData.setId(lastInsertedId);
            statisticalDataService.updateStatisticalData(newStatisticalData);
            StatisticalData statisticalDataInTheDatabase = statisticalDataService.getStatisticalDataMap().get(lastInsertedId);
            assertTrue(compareStatisticalDataObjects(newStatisticalData, statisticalDataInTheDatabase));
        }

        @AfterEach()
        @DisplayName("Delete the last saved record")
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

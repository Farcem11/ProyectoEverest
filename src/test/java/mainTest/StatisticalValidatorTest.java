package mainTest;

import model.StatisticalDataManager;
import logic.Statistical.StatisticalFileManager;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class StatisticalValidatorTest
{
    final String filesPath = "files/";
    
    @Nested
    class CalculateNumbers
    {
        StatisticalDataManager manager;
        
        @Test
        public void notExistingFileTest() 
        {
            assertNull(StatisticalFileManager.getInstance().validateAndParseStatisticalData("DoesNotExist.txt"));
        }
        
        @Test
        public void notCsvFormatTest() 
        {
            assertNull(StatisticalFileManager.getInstance().validateAndParseStatisticalData(filesPath + "NotCsvFormat.txt"));
        }
        
        @Test
        public void notNumbersTest() 
        {
            assertNull(StatisticalFileManager.getInstance().validateAndParseStatisticalData(filesPath + "NotNumbers.txt"));
        }
        
        @Test
        public void emptyFileTest()
        {
            assertNull(StatisticalFileManager.getInstance().validateAndParseStatisticalData(filesPath + "EmptyFile.txt"));
        }
        
        @Test
        public void correctFileTest()
        {
            assertNotNull(StatisticalFileManager.getInstance().validateAndParseStatisticalData(filesPath + "Numbers.txt"));
        }
        
        @Test
        public void firstLineEmptyTest()
        {
            assertNull(StatisticalFileManager.getInstance().validateAndParseStatisticalData(filesPath + "FirstLineEmpty.txt"));
        }
    }
}
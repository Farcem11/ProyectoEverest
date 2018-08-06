package mainTest;

import common.StatisticalFileManager;
import model.StatisticalData;
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
        StatisticalData data;
        
        @Test
        public void notExistingFileTest() 
        {
            assertNull(StatisticalFileManager.getInstance().parseFileToStatisticalData("DoesNotExist.txt"));
        }
        
        @Test
        public void notCsvFormatTest() 
        {
            assertNull(StatisticalFileManager.getInstance().parseFileToStatisticalData(filesPath + "NotCsvFormat.txt"));
        }
        
        @Test
        public void notNumbersTest() 
        {
            assertNull(StatisticalFileManager.getInstance().parseFileToStatisticalData(filesPath + "NotNumbers.txt"));
        }
        
        @Test
        public void emptyFileTest()
        {
            assertNull(StatisticalFileManager.getInstance().parseFileToStatisticalData(filesPath + "EmptyFile.txt"));
        }
        
        @Test
        public void correctFileTest()
        {
            assertNotNull(StatisticalFileManager.getInstance().parseFileToStatisticalData(filesPath + "Numbers.txt"));
        }
        
        @Test
        public void firstLineEmptyTest()
        {
            assertNull(StatisticalFileManager.getInstance().parseFileToStatisticalData(filesPath + "FirstLineEmpty.txt"));
        }
    }
}
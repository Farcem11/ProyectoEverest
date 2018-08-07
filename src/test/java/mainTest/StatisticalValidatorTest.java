package mainTest;

import common.StatisticalFileManager;
import java.io.File;
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
            File file = new File(filesPath + "DoesNotExist.csv");
            assertNull(StatisticalFileManager.getInstance().parseFileToStatisticalData(file));
        }
        
        @Test
        public void notCsvFormatTest() 
        {
            File file = new File(filesPath + "NotCsvFormat.csv");
            assertNull(StatisticalFileManager.getInstance().parseFileToStatisticalData(file));
        }
        
        @Test
        public void notNumbersTest() 
        {
            File file = new File(filesPath + "NotNumbers.csv");
            assertNull(StatisticalFileManager.getInstance().parseFileToStatisticalData(file));
        }
        
        @Test
        public void emptyFileTest()
        {
            File file = new File(filesPath + "EmptyFile.csv");
            assertNull(StatisticalFileManager.getInstance().parseFileToStatisticalData(file));
        }
        
        @Test
        public void correctFileTest()
        {
            File file = new File(filesPath + "Numbers.csv");
            assertNotNull(StatisticalFileManager.getInstance().parseFileToStatisticalData(file));
        }
        
        @Test
        public void firstLineEmptyTest()
        {
            File file = new File(filesPath + "FirstLineEmpty.csv");
            assertNull(StatisticalFileManager.getInstance().parseFileToStatisticalData(file));
        }
    }
}
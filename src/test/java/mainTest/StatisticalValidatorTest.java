package mainTest;

import common.StatisticalFileManager;
import java.io.File;
import java.io.IOException;
import model.StatisticalData;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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
        public void notExistingFileTest() throws IOException
        {
            File file = new File(filesPath + "DoesNotExist.csv");
            assertThrows(IOException.class, () -> StatisticalFileManager.getInstance().parseFileToStatisticalData(file));
        }
        
        @Test
        public void notCsvFormatTest() throws IOException
        {
            File file = new File(filesPath + "NotCsvFormat.csv");
            assertThrows(IOException.class, () -> StatisticalFileManager.getInstance().parseFileToStatisticalData(file));
        }
        
        @Test
        public void notNumbersTest() throws IOException
        {
            File file = new File(filesPath + "NotNumbers.csv");
            assertThrows(NumberFormatException.class, () -> StatisticalFileManager.getInstance().parseFileToStatisticalData(file));
        }
        
        @Test
        public void emptyFileTest() throws IOException
        {
            File file = new File(filesPath + "EmptyFile.csv");
            assertThrows(IOException.class, () -> StatisticalFileManager.getInstance().parseFileToStatisticalData(file));
        }
        
        @Test
        public void correctFileTest() throws IOException
        {
            File file = new File(filesPath + "Numbers.csv");
            assertNotNull(StatisticalFileManager.getInstance().parseFileToStatisticalData(file));
        }
        
        @Test
        public void firstLineEmptyTest() throws IOException
        {
            File file = new File(filesPath + "FirstLineEmpty.csv");
            assertThrows(IOException.class, () -> StatisticalFileManager.getInstance().parseFileToStatisticalData(file));
        }
    }
}
package logic;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class StatisticalValidatorTest
{
    final String filesPath = "C:\\Users\\Fabian\\Documents\\Avantica\\Everest\\ProyectoEverest\\files\\";
    
    @Nested
    class CalculateNumbers
    {
        StatisticalManager manager;
        
        @Test
        public void notExistingFileTest() 
        {
            assertNull(StatisticalValidator.getStatisticalManager("DoesNotExist.txt"));
        }
        
        @Test
        public void notCsvFormatTest() 
        {
            assertNull(StatisticalValidator.getStatisticalManager(filesPath + "NotCsvFormat.txt"));
        }
        
        @Test
        public void notNumbersTest() 
        {
            assertNull(StatisticalValidator.getStatisticalManager(filesPath + "NotNumbers.txt"));
        }
        
        @Test
        public void emptyFileTest()
        {
            assertNull(StatisticalValidator.getStatisticalManager(filesPath + "EmptyFile.txt"));
        }
        
        @Test
        public void correctFileTest()
        {
            assertNotNull(StatisticalValidator.getStatisticalManager(filesPath + "Numbers.txt"));
        }
        
        @Test
        public void firstLineEmptyTest()
        {
            assertNull(StatisticalValidator.getStatisticalManager(filesPath + "FirstLineEmpty.txt"));
        }
    }
}
package logic;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class StatisticalManagerTest
{
    final String filesPath = "C:\\Users\\Fabian\\Documents\\Avantica\\Everest\\ProyectoEverest\\files\\";
    
    @Nested
    class CalculateNumbers
    {
        StatisticalManager manager;
        
        @Test
        public void notExistingFileTest() 
        {
            assertNull(FileValidator.newStatisticalManager("DoesNotExist.txt"));
        }
        
        @Test
        public void notCsvFormatTest() 
        {
            assertNull(FileValidator.newStatisticalManager(filesPath + "NotCsvFormat.txt"));
        }
        
        @Test
        public void notNumbers() 
        {
            assertNull(FileValidator.newStatisticalManager(filesPath + "NotNumbers.txt"));
        }
        
        @Test
        public void emptyFile() 
        {
            assertNull(FileValidator.newStatisticalManager(filesPath + "EmptyFile.txt"));
        }
    }
}
package mainTest;

import common.StatisticalDataManager;
import common.StatisticalDataManager;
import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;

import model.StatisticalData;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class StatisticalValidatorTest
{
    @Nested
    class CalculateNumbers
    {
        StatisticalData data;
        
        @Test
        public void notExistingFileTest() throws IOException
        {
            assertThrows(NullPointerException.class, () -> StatisticalDataManager.getInstance().validateAndParse("", null));
        }
        
        @Test
        public void notCsvFormatTest() throws IOException
        {
            String numbers = "1,1,2,3,4,5\r\n" + 
            		"2\r\n" + 
            		"3\r\n" + 
            		"4\r\n" + 
            		"5\r\n" + 
            		"6\r\n" + 
            		"7\r\n" + 
            		"8\r\n" + 
            		"9";
            assertThrows(IOException.class, () -> StatisticalDataManager.getInstance().validateAndParse("", numbers));
        }
        
        @Test
        public void notNumbersTest() throws IOException
        {
        	String numbers = "Computer, -7.5, Lake, TV";
            assertThrows(NumberFormatException.class, () -> StatisticalDataManager.getInstance().validateAndParse("", numbers));
        }
        
        @Test
        public void emptyFileTest() throws IOException
        {
            String numbers = "";
            assertThrows(NoSuchElementException.class, () -> StatisticalDataManager.getInstance().validateAndParse("", numbers));
        }
        
        @Test
        public void correctFileTest() throws IOException
        {
        	String numbers = "1,2,3,4,5";
            assertNotNull(StatisticalDataManager.getInstance().validateAndParse("", numbers));
        }
        
        @Test
        public void firstLineEmptyTest() throws IOException
        {
        	String numbers = "\r\n" + 
            		"1,2,3,4,5,6,7,8,9,10";
            assertThrows(IOException.class, () -> StatisticalDataManager.getInstance().validateAndParse("", numbers));
        }
    }
}
package mainTest;

import everest.Application;
import everest.common.CalculationTypeEnum;
import everest.common.StatisticalDataManager;
import java.io.IOException;
import java.util.NoSuchElementException;

import everest.model.StatisticalData;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
@SpringBootTest(classes = Application.class)
public class StatisticalDataManagerTest
{
	@Autowired
	StatisticalDataManager statisticalDataManager;
	
    @Nested
    class CalculateNumbers
    {
        StatisticalData data;
        
        @Test
        public void notExistingFileTest() throws IOException
        {
            assertThrows(IOException.class, () -> statisticalDataManager.validateAndParse("", null));
        }
        
        @Test
        public void notCsvFormatTest() throws IOException
        {
            String numbers = "1\r\n" + 
            		"2\r\n" + 
            		"3\r\n" + 
            		"4\r\n" + 
            		"5\r\n" + 
            		"6\r\n" + 
            		"7\r\n" + 
            		"8\r\n" + 
            		"9";
            assertThrows(IOException.class, () -> statisticalDataManager.validateAndParse("", numbers));
        }
        
        @Test
        public void notNumbersTest() throws IOException
        {
        	String numbers = "14, -7.5, 19A, TV";
            assertThrows(NumberFormatException.class, () -> statisticalDataManager.validateAndParse("", numbers));
        }
        
        @Test
        public void emptyFileTest() throws IOException
        {
            String numbers = "";
            assertThrows(NoSuchElementException.class, () -> statisticalDataManager.validateAndParse("", numbers));
        }
        
        @Test
        public void correctFileTest() throws IOException
        {
        	String numbers = "1,2,3,4,5";
            assertNotNull(statisticalDataManager.validateAndParse("", numbers));
        }
        
        @Test
        public void firstLineEmptyTest() throws IOException
        {
        	String numbers = "\r\n" + 
            		"1,2,3,4,5,6,7,8,9,10";
            assertThrows(IOException.class, () -> statisticalDataManager.validateAndParse("", numbers));
        }
        
        @Test
        public void allCalculationsTest() throws IOException
        {
        	String numbers = "1,2,3,4,5";
        	StatisticalData statisticalData = statisticalDataManager.validateAndParse("", numbers);
        	assertEquals(CalculationTypeEnum.values().length, statisticalDataManager.getStatisticalCalculations(statisticalData).size());
        }
        
        @Test
        public void zeroCalculationsTest() throws IOException
        {
        	String numbers = "0";
        	StatisticalData statisticalData = statisticalDataManager.validateAndParse("", numbers);
        	assertEquals(CalculationTypeEnum.values().length, statisticalDataManager.getStatisticalCalculations(statisticalData).size());
        }
    }
}
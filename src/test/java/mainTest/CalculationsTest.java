package mainTest;

import common.StatisticalCalculatorManager;
import common.StatisticalDataManager;
import common.StatisticalDataManager;
import java.io.File;
import java.io.IOException;
import model.StatisticalData;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class CalculationsTest 
{
    @Nested
    class CalculateNumbers
    {
        StatisticalData data;
        
        @BeforeEach
        public void createNewStatisticalManager() throws IOException
        {
            String numbers = "-5, -4, 7.5, 8.7, 3.4, 9.4, 0.8, 1.5, 2.6, 0.9, 0.6, 9.4, 8.4, 6.6 , 9.4";
            data = StatisticalDataManager.getInstance().validateAndParse("", numbers);
        }
        
        @Test
        void testAverage()
        {
            assertEquals(4.013333333333334, StatisticalCalculatorManager.getInstance().getAverageCalculation(data));
        }
        
        @Test
        void testMax()
        {
            assertEquals(9.4, StatisticalCalculatorManager.getInstance().getMaxCalculation(data));
        }
        
        @Test
        void testMin()
        {
            assertEquals(-5.0, StatisticalCalculatorManager.getInstance().getMinCalculation(data));
        }
        
        @Test
        void testMedianOdd()
        {
            assertEquals(3.4, StatisticalCalculatorManager.getInstance().getMedianCalculation(data));
        }
        
        @Test
        void testMedianPair() throws IOException
        {
        	String numbers = "-5, -4, 7.5, 8.7, 3.4, 9.4, 0.8, 1.5, 2.6, 0.9, 0.6, 9.4, 8.4, 6.6 , 9.4, 9.5";
            data = StatisticalDataManager.getInstance().validateAndParse("", numbers);
            assertEquals(5.0, StatisticalCalculatorManager.getInstance().getMedianCalculation(data));
        }

        @Test
        void testMidRange()
        {
            assertEquals(2.2, StatisticalCalculatorManager.getInstance().getMidRangeCalculation(data));
        }
        
        @Test
        void testMode() throws IOException
        {
        	String numbers = "1,1,1,2,2,3,3,3,3,4,4,4,4,4,4,5,5,6,6,6,6,6,7,7";
            data = StatisticalDataManager.getInstance().validateAndParse("", numbers);
            assertEquals(4.0, StatisticalCalculatorManager.getInstance().getModeCalculation(data));
        }
        
        @Test
        void testQuartileThree()
        {
            assertEquals(8.7, StatisticalCalculatorManager.getInstance().getQuartileThreeCalculation(data));
        }
        
        @Test
        void testQuartileOne()
        {
            assertEquals(0.8, StatisticalCalculatorManager.getInstance().getQuartileOneCalculation(data));
        }
        
        @Test
        void testVariance()
        {
            assertEquals(22.19448888888889, StatisticalCalculatorManager.getInstance().getVarianceCalculation(data));
        }
        
        @Test
        void testStandardDeviation()
        {
            assertEquals(4.711102725359413, StatisticalCalculatorManager.getInstance().getStandardDeviationCalculation(data));
        }
    }
}

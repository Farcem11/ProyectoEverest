package mainTest;

import common.StatisticalCalculatorManager;
import common.StatisticalFileManager;
import java.io.File;
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
        final String filesPath = "files/";
        
        @BeforeEach
        public void createNewStatisticalManager() 
        {
            File file = new File(filesPath + "Numbers.csv");
            data = StatisticalFileManager.getInstance().parseFileToStatisticalData(file);
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
        void testMedianPair()
        {
            File file = new File(filesPath + "NumbersPair.csv");
            data = StatisticalFileManager.getInstance().parseFileToStatisticalData(file);
            assertEquals(5.0, StatisticalCalculatorManager.getInstance().getMedianCalculation(data));
        }

        @Test
        void testMidRange()
        {
            assertEquals(2.2, StatisticalCalculatorManager.getInstance().getMidRangeCalculation(data));
        }
        
        @Test
        void testMode()
        {
            File file = new File(filesPath + "NumbersMultipleRepeats.csv");
            data = StatisticalFileManager.getInstance().parseFileToStatisticalData(file);
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

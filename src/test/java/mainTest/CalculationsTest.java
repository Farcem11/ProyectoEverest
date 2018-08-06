package mainTest;

import common.StatisticalCalculatorManager;
import common.StatisticalFileManager;
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
            data = StatisticalFileManager.getInstance().validateAndParseStatisticalData(filesPath + "Numbers.txt");
        }
        
        @Test
        void testAverage()
        {
            assertEquals(4.013333333333334, StatisticalCalculatorManager.getInstance().getAverageCalculator().calculate(data));
        }
        
        @Test
        void testMax()
        {
            assertEquals(9.4, StatisticalCalculatorManager.getInstance().getMaxCalculator().calculate(data));
        }
        
        @Test
        void testMin()
        {
            assertEquals(-5.0, StatisticalCalculatorManager.getInstance().getMinCalculator().calculate(data));
        }
        
        @Test
        void testMedianOdd()
        {
            assertEquals(3.4, StatisticalCalculatorManager.getInstance().getMedianCalculator().calculate(data));
        }
        
        @Test
        void testMedianPair()
        {
            data = StatisticalFileManager.getInstance().validateAndParseStatisticalData(filesPath + "NumbersPair.txt");
            assertEquals(5.0, StatisticalCalculatorManager.getInstance().getMedianCalculator().calculate(data));
        }

        @Test
        void testMidRange()
        {
            assertEquals(2.2, StatisticalCalculatorManager.getInstance().getMidRangeCalculator().calculate(data));
        }
        
        @Test
        void testMode()
        {
            data = StatisticalFileManager.getInstance().validateAndParseStatisticalData(filesPath + "NumbersMultipleRepeats.txt");
            assertEquals(4.0, StatisticalCalculatorManager.getInstance().getModeCalculator().calculate(data));
        }
        
        @Test
        void testQuartileThree()
        {
            assertEquals(8.7, StatisticalCalculatorManager.getInstance().getQuartileThreeCalculator().calculate(data));
        }
        
        @Test
        void testQuartileOne()
        {
            assertEquals(0.8, StatisticalCalculatorManager.getInstance().getQuartileOneCalculator().calculate(data));
        }
        
        @Test
        void testVariance()
        {
            assertEquals(22.19448888888889, StatisticalCalculatorManager.getInstance().getVarianceCalculator().calculate(data));
        }
        
        @Test
        void testStandardDeviation()
        {
            assertEquals(4.711102725359413, StatisticalCalculatorManager.getInstance().getStandardDeviationCalculator().calculate(data));
        }
    }
}

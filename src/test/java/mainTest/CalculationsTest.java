package mainTest;

import common.StatisticalCalculatorManager;
import common.StatisticalFileManager;
import model.StatisticalDataManager;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class CalculationsTest 
{
    @Nested
    class CalculateNumbers
    {
        StatisticalDataManager dataManger;
        final String filesPath = "files/";
        
        @BeforeEach
        public void createNewStatisticalManager() 
        {
            dataManger = StatisticalFileManager.getInstance().validateAndParseStatisticalData(filesPath + "Numbers.txt");
        }
        
        @Test
        void testAverage()
        {
            assertEquals(4.013333333333334, StatisticalCalculatorManager.getInstance().getAverageCalculator().calculate(dataManger));
        }
        
        @Test
        void testMax()
        {
            assertEquals(9.4, StatisticalCalculatorManager.getInstance().getMaxCalculator().calculate(dataManger));
        }
        
        @Test
        void testMin()
        {
            assertEquals(-5.0, StatisticalCalculatorManager.getInstance().getMinCalculator().calculate(dataManger));
        }
        
        @Test
        void testMedianOdd()
        {
            assertEquals(3.4, StatisticalCalculatorManager.getInstance().getMedianCalculator().calculate(dataManger));
        }
        
        @Test
        void testMedianPair()
        {
            dataManger = StatisticalFileManager.getInstance().validateAndParseStatisticalData(filesPath + "NumbersPair.txt");
            assertEquals(5.0, StatisticalCalculatorManager.getInstance().getMedianCalculator().calculate(dataManger));
        }

        @Test
        void testMidRange()
        {
            assertEquals(2.2, StatisticalCalculatorManager.getInstance().getMidRangeCalculator().calculate(dataManger));
        }
        
        @Test
        void testMode()
        {
            dataManger = StatisticalFileManager.getInstance().validateAndParseStatisticalData(filesPath + "NumbersMultipleRepeats.txt");
            assertEquals(4.0, StatisticalCalculatorManager.getInstance().getModeCalculator().calculate(dataManger));
        }
        
        @Test
        void testQuartileThree()
        {
            assertEquals(8.7, StatisticalCalculatorManager.getInstance().getQuartileThreeCalculator().calculate(dataManger));
        }
        
        @Test
        void testQuartileOne()
        {
            assertEquals(0.8, StatisticalCalculatorManager.getInstance().getQuartileOneCalculator().calculate(dataManger));
        }
        
        @Test
        void testVariance()
        {
            assertEquals(22.19448888888889, StatisticalCalculatorManager.getInstance().getVarianceCalculator().calculate(dataManger));
        }
        
        @Test
        void testStandardDeviation()
        {
            assertEquals(4.711102725359413, StatisticalCalculatorManager.getInstance().getStandardDeviationCalculator().calculate(dataManger));
        }
    }
}

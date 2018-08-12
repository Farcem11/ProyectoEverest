package mainTest;

import everest.common.CalculationTypeEnum;
import everest.common.StatisticalCalculator;
import everest.common.StatisticalDataManager;
import java.io.IOException;
import everest.model.StatisticalData;
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
            assertEquals(4.013333333333334, StatisticalCalculator.getInstance().calculate(CalculationTypeEnum.AVERAGE, data));
        }
        
        @Test
        void testMax()
        {
            assertEquals(9.4, StatisticalCalculator.getInstance().calculate(CalculationTypeEnum.MAX, data));
        }
        
        @Test
        void testMin()
        {
            assertEquals(-5.0, StatisticalCalculator.getInstance().calculate(CalculationTypeEnum.MIN, data));
        }
        
        @Test
        void testMedianOdd()
        {
            assertEquals(3.4, StatisticalCalculator.getInstance().calculate(CalculationTypeEnum.MEDIAN, data));
        }
        
        @Test
        void testMedianPair() throws IOException
        {
        	String numbers = "-5, -4, 7.5, 8.7, 3.4, 9.4, 0.8, 1.5, 2.6, 0.9, 0.6, 9.4, 8.4, 6.6 , 9.4, 9.5";
            data = StatisticalDataManager.getInstance().validateAndParse("", numbers);
            assertEquals(5.0, StatisticalCalculator.getInstance().calculate(CalculationTypeEnum.MEDIAN, data));
        }

        @Test
        void testMidRange()
        {
            assertEquals(2.2, StatisticalCalculator.getInstance().calculate(CalculationTypeEnum.MID_RANGE, data));
        }
        
        @Test
        void testMode() throws IOException
        {
        	String numbers = "1,1,1,2,2,3,3,3,3,4,4,4,4,4,4,5,5,6,6,6,6,6,7,7";
            data = StatisticalDataManager.getInstance().validateAndParse("", numbers);
            assertEquals(4.0, StatisticalCalculator.getInstance().calculate(CalculationTypeEnum.MODE, data));
        }
                
        @Nested
        class quartileOneTest
        {
            @Test
            void testQuartileOneOneValue() throws IOException
            {
            	String one = "1";
                data = StatisticalDataManager.getInstance().validateAndParse("", one);
            	assertEquals(1, StatisticalCalculator.getInstance().calculate(CalculationTypeEnum.QUARTILE_ONE, data));
            }
            
            @Test
            void testQuartilePairOne() throws IOException
            {
            	String numbers = "-5, -4, 7.5, 8.7, 3.4, 9.4, 0.8, 1.5, 2.6, 0.9, 0.6, 9.4, 8.4, 6.6 , 9.4, 9.5";
                data = StatisticalDataManager.getInstance().validateAndParse("", numbers);
                assertEquals(0.825, StatisticalCalculator.getInstance().calculate(CalculationTypeEnum.QUARTILE_ONE, data));
            }
            
            @Test
            void testQuartileOneOddTest() throws IOException
            {
                assertEquals(0.8, StatisticalCalculator.getInstance().calculate(CalculationTypeEnum.QUARTILE_ONE, data));
            }
        }

        @Nested
        class quartileThreeTest
        {
            @Test
            void testQuartileThreeOneValue() throws IOException
            {
            	String one = "1";
                data = StatisticalDataManager.getInstance().validateAndParse("", one);
            	assertEquals(1, StatisticalCalculator.getInstance().calculate(CalculationTypeEnum.QUARTILE_THREE, data));
            }
        
            @Test
            void testQuartilePairThree() throws IOException
            {
            	String numbers = "-5, -4, 7.5, 8.7, 3.4, 9.4, 0.8, 1.5, 2.6, 0.9, 0.6, 9.4, 8.4, 6.6 , 9.4, 9.5";
                data = StatisticalDataManager.getInstance().validateAndParse("", numbers);
                assertEquals(9.225, StatisticalCalculator.getInstance().calculate(CalculationTypeEnum.QUARTILE_THREE, data));
            }
            
            @Test
            void testQuartileOddThree() throws IOException
            {
                assertEquals(8.7, StatisticalCalculator.getInstance().calculate(CalculationTypeEnum.QUARTILE_THREE, data));
            }
        }
                
        @Test
        void testVariance()
        {
            assertEquals(22.19448888888889, StatisticalCalculator.getInstance().calculate(CalculationTypeEnum.VARIANCE, data));
        }
        
        @Test
        void testStandardDeviation()
        {
            assertEquals(4.711102725359413, StatisticalCalculator.getInstance().calculate(CalculationTypeEnum.STANDARD_DEVIATION, data));
        }
    }
}

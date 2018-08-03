package logic.operations.calculations;

import logic.StatisticalCalculator;
import logic.StatisticalManager;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class CalculationsTest 
{
    @Nested
    class CalculateNumbers
    {
        StatisticalManager manager;
        
        @BeforeEach
        public void createNewStatisticalManager() 
        {
            manager = new StatisticalManager("C:\\Users\\Fabian\\Documents\\Avantica\\Everest\\ProyectoEverest\\numbers.txt");
        }
        
        @Test
        void testAverage()
        {
            assertEquals(8.0, StatisticalCalculator.AVERAGE.calculate(manager));
        }
        
        @Test
        void testMax()
        {
            assertEquals(15.0, StatisticalCalculator.MAX.calculate(manager));
        }
        
        @Test
        void testMin()
        {
            assertEquals(1.0, StatisticalCalculator.MIN.calculate(manager));
        }
        
        @Test
        void testMedian()
        {
            assertEquals(8.0, StatisticalCalculator.MEDIAN.calculate(manager));
        }
        
        @Test
        void testRange()
        {
            assertEquals(8.0, StatisticalCalculator.MID_RANGE.calculate(manager));
        }
        
        @Test
        void testMode()
        {
            assertEquals(Double.NaN, StatisticalCalculator.MODE.calculate(manager));
        }
        
        @Test
        void testQuartileThree()
        {
            assertEquals(12.0, StatisticalCalculator.QUARTILE_THREE.calculate(manager));
        }
        
        @Test
        void testQuartileOne()
        {
            assertEquals(4.0, StatisticalCalculator.QUARTILE_ONE.calculate(manager));
        }
        
        @Test
        void testVariance()
        {
            assertEquals(18.666666666666668, StatisticalCalculator.VARIANCE.calculate(manager));
        }
        
        @Test
        void testStandardDeviation()
        {
            assertEquals(4.320493798938574, StatisticalCalculator.STANDARD_DEVIATION.calculate(manager));
        }
    }
}

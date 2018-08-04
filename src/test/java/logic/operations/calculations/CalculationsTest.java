package logic.operations.calculations;

import logic.StatisticalValidator;
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
            manager = StatisticalValidator.getStatisticalManager("C:\\Users\\Fabian\\Documents\\Avantica\\Everest\\ProyectoEverest\\files\\Numbers.txt");
        }
        
        @Test
        void testAverage()
        {
            assertEquals(4.013333333333334, StatisticalCalculator.AVERAGE.calculate(manager));
        }
        
        @Test
        void testMax()
        {
            assertEquals(9.4, StatisticalCalculator.MAX.calculate(manager));
        }
        
        @Test
        void testMin()
        {
            assertEquals(-5.0, StatisticalCalculator.MIN.calculate(manager));
        }
        
        @Test
        void testMedianOdd()
        {
            assertEquals(3.4, StatisticalCalculator.MEDIAN.calculate(manager));
        }
        
        @Test
        void testMedianPair()
        {
            manager = StatisticalValidator.getStatisticalManager("C:\\Users\\Fabian\\Documents\\Avantica\\Everest\\ProyectoEverest\\files\\NumbersPair.txt");
            assertEquals(5.0, StatisticalCalculator.MEDIAN.calculate(manager));
        }

        @Test
        void testRange()
        {
            assertEquals(2.2, StatisticalCalculator.MID_RANGE.calculate(manager));
        }
        
        @Test
        void testMode()
        {
            manager = StatisticalValidator.getStatisticalManager("C:\\Users\\Fabian\\Documents\\Avantica\\Everest\\ProyectoEverest\\files\\NumbersMultipleRepeats.txt");
            assertEquals(4.0, StatisticalCalculator.MODE.calculate(manager));
        }
        
        @Test
        void testQuartileThree()
        {
            assertEquals(8.7, StatisticalCalculator.QUARTILE_THREE.calculate(manager));
        }
        
        @Test
        void testQuartileOne()
        {
            assertEquals(0.8, StatisticalCalculator.QUARTILE_ONE.calculate(manager));
        }
        
        @Test
        void testVariance()
        {
            assertEquals(22.19448888888889, StatisticalCalculator.VARIANCE.calculate(manager));
        }
        
        @Test
        void testStandardDeviation()
        {
            assertEquals(4.711102725359413, StatisticalCalculator.STANDARD_DEVIATION.calculate(manager));
        }
    }
}

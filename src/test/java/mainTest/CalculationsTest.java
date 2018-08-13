package mainTest;

import everest.common.CalculationTypeEnum;
import everest.common.StatisticalCalculator;
import everest.common.StatisticalDataManager;
import java.io.IOException;
import everest.model.StatisticalData;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class CalculationsTest 
{
    static String numbersOdd = "-5, -4, 7.5, 8.7, 3.4, 9.4, 0.8, 1.5, 2.6, 0.9, 0.6, 9.4, 8.4, 6.6 , 9.4";
    static String numbersPair = "-5, -4, 7.5, 8.7, 3.4, 9.4, 0.8, 1.5, 2.6, 0.9, 0.6, 9.4, 8.4, 6.6 , 9.4, 9.5";
    static String numbersRepeated = "1,1,1,2,2,3,3,3,3,4,4,4,4,4,4,5,5,6,6,6,6,6,7,7";
    static String numbersNoRepeated = "1,2,3,4,5,6,7";	
    static String one = "1";

    static StatisticalData dataOne;
	static StatisticalData dataNumbersOdd;
	static StatisticalData dataNumbersPair;
	static StatisticalData dataRepeated;
	static StatisticalData dataNoRepeated;

	@BeforeAll
    public static void createNewStatisticalManager() throws IOException
    {
        dataNumbersOdd = StatisticalDataManager.getInstance().validateAndParse("", numbersOdd);
        dataNumbersPair = StatisticalDataManager.getInstance().validateAndParse("", numbersPair);
        dataOne = StatisticalDataManager.getInstance().validateAndParse("", one);
        dataRepeated = StatisticalDataManager.getInstance().validateAndParse("", numbersRepeated);
        dataNoRepeated = StatisticalDataManager.getInstance().validateAndParse("", numbersNoRepeated);
    }
    
    @Test
    void testAverage()
    {
        assertEquals(4.013333333333334, StatisticalCalculator.getInstance().calculate(CalculationTypeEnum.AVERAGE, dataNumbersOdd));
    }
    
    @Test
    void testMax()
    {
        assertEquals(9.4, StatisticalCalculator.getInstance().calculate(CalculationTypeEnum.MAX, dataNumbersOdd));
    }
    
    @Test
    void testMin()
    {
        assertEquals(-5.0, StatisticalCalculator.getInstance().calculate(CalculationTypeEnum.MIN, dataNumbersOdd));
    }
    
    @Test
    void testMedianOdd()
    {
        assertEquals(3.4, StatisticalCalculator.getInstance().calculate(CalculationTypeEnum.MEDIAN, dataNumbersOdd));
    }
    
    @Test
    void testMedianPair()
    {
        assertEquals(5.0, StatisticalCalculator.getInstance().calculate(CalculationTypeEnum.MEDIAN, dataNumbersPair));
    }

    @Test
    void testMidRange()
    {
        assertEquals(2.2, StatisticalCalculator.getInstance().calculate(CalculationTypeEnum.MID_RANGE, dataNumbersOdd));
    }
    
    @Nested
    class modeTest
    {
	    @Test
	    void testRepeatedMode() throws IOException
	    {
	        assertEquals(4.0, StatisticalCalculator.getInstance().calculate(CalculationTypeEnum.MODE, dataRepeated));
	    }
	    
	    @Test
	    void testNoRepeatedMode() throws IOException
	    {
	        assertEquals(Double.NaN, StatisticalCalculator.getInstance().calculate(CalculationTypeEnum.MODE, dataNoRepeated));
	    }	
    }
            
    @Nested
    class quartileOneTest
    {
        @Test
        void testQuartileOneOneValue() throws IOException
        {
        	assertEquals(1, StatisticalCalculator.getInstance().calculate(CalculationTypeEnum.QUARTILE_ONE, dataOne));
        }
        
        @Test
        void testQuartilePairOne() throws IOException
        {
            assertEquals(0.8, StatisticalCalculator.getInstance().calculate(CalculationTypeEnum.QUARTILE_ONE, dataNumbersPair));
        }
        
        @Test
        void testQuartileOneOddTest() throws IOException
        {
            assertEquals(0.8, StatisticalCalculator.getInstance().calculate(CalculationTypeEnum.QUARTILE_ONE, dataNumbersOdd));
        }
    }

    @Nested
    class quartileThreeTest
    {
        @Test
        void testQuartileThreeOneValue() throws IOException
        {
        	assertEquals(1, StatisticalCalculator.getInstance().calculate(CalculationTypeEnum.QUARTILE_THREE, dataOne));
        }
    
        @Test
        void testQuartilePairThree() throws IOException
        {
            assertEquals(8.7, StatisticalCalculator.getInstance().calculate(CalculationTypeEnum.QUARTILE_THREE, dataNumbersPair));
        }
        
        @Test
        void testQuartileOddThree() throws IOException
        {
            assertEquals(8.7, StatisticalCalculator.getInstance().calculate(CalculationTypeEnum.QUARTILE_THREE, dataNumbersOdd));
        }
    }
            
    @Test
    void testVariance()
    {
        assertEquals(22.19448888888889, StatisticalCalculator.getInstance().calculate(CalculationTypeEnum.VARIANCE, dataNumbersOdd));
    }
    
    @Test
    void testStandardDeviation()
    {
        assertEquals(4.711102725359413, StatisticalCalculator.getInstance().calculate(CalculationTypeEnum.STANDARD_DEVIATION, dataNumbersOdd));
    }
}

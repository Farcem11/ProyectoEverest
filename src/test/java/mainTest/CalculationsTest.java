package mainTest;

import everest.Application;
import everest.common.CalculationTypeEnum;
import everest.common.StatisticalCalculator;
import everest.common.StatisticalDataManager;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import javax.annotation.PostConstruct;

import everest.model.StatisticalData;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
@SpringBootTest(classes = Application.class)
public class CalculationsTest 
{
	@Autowired
	private StatisticalCalculator statisticalCalculator;
	
	@Autowired
	private StatisticalDataManager statisticalDataManager;
	
    static String numbersOdd = "-5, -4, 7.5, 8.7, 3.4, 9.4, 0.8, 1.5, 2.6, 0.9, 0.6, 9.4, 8.4, 6.6, 9.4";
    private String numbersPair = "-5, -4, 7.5, 8.7, 3.4, 9.4, 0.8, 1.5, 2.6, 0.9, 0.6, 9.4, 8.4, 6.6 , 9.4, 9.5";
    private String numbersMultipleRepeated = "1,1,1,2,2,3,3,3,4,5,5,5,6,6,7,7";
    private String numbersNoRepeated = "1,2,3,4,5,6,7";
    private String one = "1";
    private String twoNumbers = "1,2";
    private String threeNumbers = "1,2,3";

    private StatisticalData dataOne;
	private StatisticalData dataTwoNumbers;
	private StatisticalData dataThreeNumbers;
	private StatisticalData dataNumbersOdd;
	private StatisticalData dataNumbersPair;
	private StatisticalData dataMultipleRepeated;
	private StatisticalData dataNoRepeated;
	
	private <T> boolean listEqualsIgnoreOrder(List<T> list1, List<T> list2) 
    {
        return new HashSet<>(list1).equals(new HashSet<>(list2));
    }
	
	@PostConstruct
	private void init() throws IOException
	{
        dataNumbersOdd = statisticalDataManager.validateAndParse("", numbersOdd);
        dataNumbersPair = statisticalDataManager.validateAndParse("", numbersPair);
        dataOne = statisticalDataManager.validateAndParse("", one);
        dataMultipleRepeated = statisticalDataManager.validateAndParse("", numbersMultipleRepeated);
        dataNoRepeated = statisticalDataManager.validateAndParse("", numbersNoRepeated);	
        dataTwoNumbers = statisticalDataManager.validateAndParse("", twoNumbers);
        dataThreeNumbers = statisticalDataManager.validateAndParse("", threeNumbers);
	}
    
    @Test
    void testAverage()
    {
        assertEquals(Arrays.asList(4.013333333333334), statisticalCalculator.calculate(CalculationTypeEnum.AVERAGE, dataNumbersOdd));
    }
    
    @Test
    void testMax()
    {
        assertEquals(Arrays.asList(9.4), statisticalCalculator.calculate(CalculationTypeEnum.MAX, dataNumbersOdd));
    }
    
    @Test
    void testMin()
    {
        assertEquals(Arrays.asList(-5.0), statisticalCalculator.calculate(CalculationTypeEnum.MIN, dataNumbersOdd));
    }
    
    @Test
    void testMedianOdd()
    {
        assertEquals(Arrays.asList(3.4), statisticalCalculator.calculate(CalculationTypeEnum.MEDIAN, dataNumbersOdd));
    }
    
    @Test
    void testMedianPair()
    {
        assertEquals(Arrays.asList(5.0), statisticalCalculator.calculate(CalculationTypeEnum.MEDIAN, dataNumbersPair));
    }

    @Test
    void testMidRange()
    {
        assertEquals(Arrays.asList(2.2), statisticalCalculator.calculate(CalculationTypeEnum.MID_RANGE, dataNumbersOdd));
    }
    
    @Nested
    class modeTest
    {
	    @Test
	    void testMultipleRepeatedMode() throws IOException
	    {
	    	List<Double> expectedResults = Arrays.asList(1.0, 3.0, 5.0);
	    	List<Double> actualResults = statisticalCalculator.calculate(CalculationTypeEnum.MODE, dataMultipleRepeated);
	        assertTrue(listEqualsIgnoreOrder(expectedResults, actualResults));
	    }
	    
	    @Test
	    void testNoRepeatedMode() throws IOException
	    {
	        assertEquals(Collections.emptyList(), statisticalCalculator.calculate(CalculationTypeEnum.MODE, dataNoRepeated));
	    }
	    
	    @Test
	    void testRepeatedMode()
	    {
	        assertEquals(Arrays.asList(9.4), statisticalCalculator.calculate(CalculationTypeEnum.MODE, dataNumbersOdd));
	    }
    }
            
    @Nested
    class quartileOneTest
    {
        @Test
        void testQuartileOneOneValue() throws IOException
        {
        	assertEquals(Arrays.asList(1.0), statisticalCalculator.calculate(CalculationTypeEnum.QUARTILE_ONE, dataOne));
        }
        
        @Test
        void testQuartileOneTwoNumbers() throws IOException
        {
            assertEquals(Arrays.asList(1.0), statisticalCalculator.calculate(CalculationTypeEnum.QUARTILE_ONE, dataTwoNumbers));
        }
        
        @Test
        void testQuartileOneThreeNumbers() throws IOException
        {
        	assertEquals(Arrays.asList(1.0), statisticalCalculator.calculate(CalculationTypeEnum.QUARTILE_ONE, dataThreeNumbers));
        }
        
        @Test
        void testQuartileOnePair() throws IOException
        {
            assertEquals(Arrays.asList(0.8250000000000001), statisticalCalculator.calculate(CalculationTypeEnum.QUARTILE_ONE, dataNumbersPair));
        }
        
        @Test
        void testQuartileOneOdd() throws IOException
        {
            assertEquals(Arrays.asList(0.8), statisticalCalculator.calculate(CalculationTypeEnum.QUARTILE_ONE, dataNumbersOdd));
        }
    }

    @Nested
    class quartileThreeTest
    {
        @Test
        void testQuartileThreeOneValue() throws IOException
        {
        	assertEquals(Arrays.asList(1.0), statisticalCalculator.calculate(CalculationTypeEnum.QUARTILE_THREE, dataOne));
        }
        
        @Test
        void testQuartileThreeTwoNumbers() throws IOException
        {
            assertEquals(Arrays.asList(2.0), statisticalCalculator.calculate(CalculationTypeEnum.QUARTILE_THREE, dataTwoNumbers));
        }
        
        @Test
        void testQuartileThreeThreeNumbers() throws IOException
        {
        	assertEquals(Arrays.asList(3.0), statisticalCalculator.calculate(CalculationTypeEnum.QUARTILE_THREE, dataThreeNumbers));
        }
    
        @Test
        void testQuartileThreePair() throws IOException
        {
            assertEquals(Arrays.asList(9.225), statisticalCalculator.calculate(CalculationTypeEnum.QUARTILE_THREE, dataNumbersPair));
        }
        
        @Test
        void testQuartileThreeOdd() throws IOException
        {
            assertEquals(Arrays.asList(8.7), statisticalCalculator.calculate(CalculationTypeEnum.QUARTILE_THREE, dataNumbersOdd));
        }
    }
            
    @Test
    void testVariance()
    {
        assertEquals(Arrays.asList(22.19448888888889), statisticalCalculator.calculate(CalculationTypeEnum.VARIANCE, dataNumbersOdd));
    }
    
    @Test
    void testStandardDeviation()
    {
        assertEquals(Arrays.asList(4.711102725359413), statisticalCalculator.calculate(CalculationTypeEnum.STANDARD_DEVIATION, dataNumbersOdd));
    }
}

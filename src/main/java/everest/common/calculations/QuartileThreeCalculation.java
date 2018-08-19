package everest.common.calculations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import everest.model.StatisticalData;

public class QuartileThreeCalculation implements CalculationStrategy
{
    @Override
    public List<Double> doCalculation(StatisticalData statisticalData) 
    {
    	double[] numbers = statisticalData.getNumbersArray();

    	if(numbers.length < 4)
    	{
    		return Arrays.asList(numbers[numbers.length-1]);
    	}
    	
    	double quartileThreeIndex = (3.0 * (numbers.length + 1.0)) / 4.0;

		if(quartileThreeIndex == Math.floor(quartileThreeIndex))
    	{
			// Is integer
            return Arrays.asList(numbers[(int)quartileThreeIndex-1]);
    	}
    	else
    	{
    		int quartileThreeInteger = (int)Math.floor(quartileThreeIndex);
    		double numberInIndex = numbers[quartileThreeInteger-1];
    		double nextNumberInIndex = numbers[quartileThreeInteger];
    		double decimalPart = quartileThreeIndex - quartileThreeInteger;
    		return Arrays.asList(numberInIndex + decimalPart * (nextNumberInIndex - numberInIndex));
    	}
    }
}

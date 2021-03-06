package everest.common.calculations;

import java.util.Arrays;
import java.util.List;

import everest.model.StatisticalData;

public class QuartileOneCalculation implements CalculationStrategy
{
    @Override
    public List<Double> doCalculation(StatisticalData statisticalData) 
    {
    	double[] numbers = statisticalData.getNumbersArray();

    	if(numbers.length < 4)
    	{
    		return Arrays.asList(numbers[0]);
    	}
    	
    	double quartileOneIndex = (numbers.length + 1.0) / 4.0;

		if(quartileOneIndex == Math.floor(quartileOneIndex))
    	{
			// Is integer
            return Arrays.asList(numbers[(int)quartileOneIndex-1]);
    	}
    	else
    	{
    		int quartileOneInteger = (int)Math.floor(quartileOneIndex);
    		double numberInIndex = numbers[quartileOneInteger-1];
    		double nextNumberInIndex = numbers[quartileOneInteger];
    		double decimalPart = quartileOneIndex - quartileOneInteger;
    		return Arrays.asList(numberInIndex + decimalPart * (nextNumberInIndex - numberInIndex));
    	}
    }
}

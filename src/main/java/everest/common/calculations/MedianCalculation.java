package everest.common.calculations;

import java.util.Arrays;
import java.util.List;

import everest.model.StatisticalData;

public class MedianCalculation implements CalculationStrategy
{
    @Override
    public List<Double> doCalculation(StatisticalData statisticalData) 
    {
        double[] numbers = statisticalData.getNumbersArray();
        int lenght = numbers.length;
        int halfLength = lenght / 2;
        
        if(lenght % 2 == 0)
        {
        	return Arrays.asList((numbers[halfLength - 1] + numbers[halfLength]) / 2); 
        }
        else
        {
        	return Arrays.asList(numbers[halfLength]);
        }
    }
}

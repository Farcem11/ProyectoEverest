package everest.common.calculations;

import java.util.Arrays;
import java.util.List;

import everest.model.StatisticalData;

public class QuartileOneCalculation implements CalculationStrategy
{
    @Override
    public List<Double> doCalculation(StatisticalData statisticalData) 
    {
    	double quartileOneDouble = (statisticalData.getNumbersArray().length + 1) / 4;

		if((quartileOneDouble == Math.floor(quartileOneDouble))) 
    	{
            return Arrays.asList(statisticalData.getNumbersArray()[(int) Math.rint(quartileOneDouble - 1)]);
    	}
    	else
    	{
    		double quartileOneInteger = Math.floor(quartileOneDouble);

    		quartileOneDouble = (quartileOneInteger + (quartileOneInteger + 1)) / 2;
    		return Arrays.asList(statisticalData.getNumbersArray()[(int) Math.rint(quartileOneDouble - 1)]);
    	}
    }
}

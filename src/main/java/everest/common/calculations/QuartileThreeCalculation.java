package everest.common.calculations;

import java.util.Arrays;

import everest.common.CalculationTypeEnum;
import everest.common.StatisticalCalculator;
import everest.model.StatisticalData;

public class QuartileThreeCalculation implements CalculationStrategy
{
    @Override
    public double doCalculation(StatisticalData statisticalData) 
    {
    	double[] originalArray = statisticalData.getNumbersArray();
    	double[] secondHalf;
    	if(originalArray.length == 1)
    	{
    		return originalArray[0];
    	}
    	else if(originalArray.length % 2 == 0)
    	{
    		secondHalf = Arrays.copyOfRange(originalArray, originalArray.length/2, originalArray.length);
    	}
    	else
    	{
    		secondHalf = Arrays.copyOfRange(originalArray, originalArray.length/2+1, originalArray.length);
    	}
    	statisticalData.setNumbersArray(secondHalf);
    	return StatisticalCalculator.getInstance().calculate(CalculationTypeEnum.MEDIAN, statisticalData);
    }
}
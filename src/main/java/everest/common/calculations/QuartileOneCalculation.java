package everest.common.calculations;

import java.util.Arrays;

import everest.common.CalculationTypeEnum;
import everest.common.StatisticalCalculator;
import everest.model.StatisticalData;

public class QuartileOneCalculation implements CalculationStrategy
{
    @Override
    public double doCalculation(StatisticalData statisticalData) 
    {
    	double[] originalArray = statisticalData.getNumbersArray();
    	if(originalArray.length == 1)
    	{
    		return originalArray[0];
    	}
    	double[] firstHalf = Arrays.copyOfRange(originalArray, 0, (originalArray.length/2));
    	statisticalData.setNumbersArray(firstHalf);
    	return StatisticalCalculator.getInstance().calculate(CalculationTypeEnum.MEDIAN, statisticalData);
    }
}

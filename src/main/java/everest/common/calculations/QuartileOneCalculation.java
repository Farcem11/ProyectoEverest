package everest.common.calculations;

import java.util.Arrays;
import java.util.List;

import everest.model.StatisticalData;

public class QuartileOneCalculation implements CalculationStrategy
{
    @Override
    public List<Double> doCalculation(StatisticalData statisticalData) 
    {
    	if(statisticalData.getNumbersArray().length == 1)
    	{
    		return Arrays.asList(statisticalData.getNumbersArray()[0]);
    	}
        int quartileOneIndex = (statisticalData.getNumbersArray().length + 1) / 4;
        return Arrays.asList(statisticalData.getNumbersArray()[quartileOneIndex - 1]);
    }
}

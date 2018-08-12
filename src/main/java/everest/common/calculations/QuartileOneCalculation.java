package everest.common.calculations;

import everest.model.StatisticalData;

public class QuartileOneCalculation implements CalculationStrategy
{
    @Override
    public double doCalculation(StatisticalData statisticalData) 
    {
    	if(statisticalData.getNumbersArray().length == 1)
    	{
    		return statisticalData.getNumbersArray()[0];
    	}
        int quartileOneIndex = (statisticalData.getNumbersArray().length + 1) / 4;
        return statisticalData.getNumbersArray()[quartileOneIndex - 1];
    }
}

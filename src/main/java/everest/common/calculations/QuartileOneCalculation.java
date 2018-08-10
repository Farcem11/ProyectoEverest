package everest.common.calculations;

import everest.model.StatisticalData;

public class QuartileOneCalculation implements CalculationStrategy
{
    @Override
    public double doCalculation(StatisticalData statisticalData) 
    {
        int quartileOneIndex = (statisticalData.getNumbersArray().length + 1) / 4;
        return statisticalData.getNumbersArray()[quartileOneIndex - 1];
    }
}

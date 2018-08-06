package common.calculations;

import model.StatisticalData;

public class QuartileOneCalculation implements CalculationStrategy
{
    @Override
    public double doCalculation(StatisticalData statisticalDataManager) 
    {
        int quartileOneIndex = (statisticalDataManager.getNumbersArray().length + 1) / 4;
        return statisticalDataManager.getNumbersArray()[quartileOneIndex - 1];
    }
}

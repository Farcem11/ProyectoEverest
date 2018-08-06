package common.calculations;

import model.StatisticalData;

public class AverageCalculation implements CalculationStrategy
{
    @Override
    public double doCalculation(StatisticalData statisticalDataManager) 
    {
        return statisticalDataManager.getTotal() / statisticalDataManager.getNumbersArray().length;
    }
}

package common.calculations;

import model.StatisticalData;

public class MaxCalculation implements CalculationStrategy
{
    @Override
    public double doCalculation(StatisticalData statisticalDataManager) 
    {
        return statisticalDataManager.getMax();
    }
}

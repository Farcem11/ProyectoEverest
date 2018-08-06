package common.calculations;

import model.StatisticalDataManager;

public class MaxCalculation implements CalculationStrategy
{
    @Override
    public double doCalculation(StatisticalDataManager statisticalDataManager) 
    {
        return statisticalDataManager.getMax();
    }
}

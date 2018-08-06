package common.calculations;

import model.StatisticalDataManager;

public class MinCalculation implements CalculationStrategy
{
    @Override
    public double doCalculation(StatisticalDataManager statisticalDataManager) 
    {
        return statisticalDataManager.getMin();
    }
}

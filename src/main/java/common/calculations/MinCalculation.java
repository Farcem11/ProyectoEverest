package common.calculations;

import model.StatisticalData;

public class MinCalculation implements CalculationStrategy
{
    @Override
    public double doCalculation(StatisticalData statisticalDataManager) 
    {
        return statisticalDataManager.getMin();
    }
}

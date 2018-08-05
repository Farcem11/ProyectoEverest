package logic.statistical.calculations;

import model.object.StatisticalDataManager;

public class MinCalculation implements CalculationStrategy
{
    @Override
    public double doCalculation(StatisticalDataManager statisticalDataManager) 
    {
        return statisticalDataManager.getMin();
    }
}

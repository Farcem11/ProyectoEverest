package logic.statistical.calculations;

import model.object.StatisticalDataManager;

public class MaxCalculation implements CalculationStrategy
{
    @Override
    public double doCalculation(StatisticalDataManager statisticalDataManager) 
    {
        return statisticalDataManager.getMax();
    }
}

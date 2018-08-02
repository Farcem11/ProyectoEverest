package logic.Operations;

import logic.StatisticalManager;

public class AverageCalculation implements CalculationStrategy
{
    @Override
    public double doCalculation(StatisticalManager statisticalManager) 
    {
        return statisticalManager.getSum() / statisticalManager.getSize();
    }
}

package logic.Operations;

import logic.StatisticalManager;

public class MiddleRangeCalculation  implements CalculationStrategy 
{
    @Override
    public double doCalculation(StatisticalManager statisticalManager) 
    {
        return (statisticalManager.getMax() + statisticalManager.getMin()) / 2;
    }
}

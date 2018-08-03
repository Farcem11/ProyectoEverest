package logic.operations.calculations;

import logic.operations.CalculationStrategy;
import logic.StatisticalManager;

public class MidRangeCalculation  implements CalculationStrategy 
{
    @Override
    public double doCalculation(StatisticalManager statisticalManager) 
    {
        return (statisticalManager.getMax() + statisticalManager.getMin()) / 2;
    }
}

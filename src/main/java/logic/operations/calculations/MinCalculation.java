package logic.operations.calculations;

import logic.operations.CalculationStrategy;
import logic.StatisticalManager;

public class MinCalculation implements CalculationStrategy
{
    @Override
    public double doCalculation(StatisticalManager statisticalManager) 
    {
        return statisticalManager.getMin();
    }
}

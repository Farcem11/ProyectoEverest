package logic.operations.calculations;

import logic.operations.CalculationStrategy;
import logic.StatisticalManager;

public class MaxCalculation implements CalculationStrategy
{
    @Override
    public double doCalculation(StatisticalManager statisticalManager) 
    {
        return statisticalManager.getMax();
    }
}

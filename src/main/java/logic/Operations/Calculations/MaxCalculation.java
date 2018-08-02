package logic.Operations.Calculations;

import logic.Operations.CalculationStrategy;
import logic.StatisticalManager;

public class MaxCalculation implements CalculationStrategy
{
    @Override
    public double doCalculation(StatisticalManager statisticalManager) 
    {
        return statisticalManager.getMax();
    }
}

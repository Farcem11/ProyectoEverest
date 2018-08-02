package logic.Operations.Calculations;

import logic.Operations.CalculationStrategy;
import logic.StatisticalManager;

public class MinCalculation implements CalculationStrategy
{
    @Override
    public double doCalculation(StatisticalManager statisticalManager) 
    {
        return statisticalManager.getMin();
    }
}

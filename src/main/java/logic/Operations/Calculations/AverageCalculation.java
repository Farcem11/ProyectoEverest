package logic.Operations.Calculations;

import logic.Operations.CalculationStrategy;
import logic.StatisticalManager;

public class AverageCalculation implements CalculationStrategy
{
    @Override
    public double doCalculation(StatisticalManager statisticalManager) 
    {
        return statisticalManager.getTotal() / statisticalManager.getNumbers().length;
    }
}

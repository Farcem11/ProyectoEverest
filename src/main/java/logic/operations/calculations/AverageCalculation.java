package logic.operations.calculations;

import logic.operations.CalculationStrategy;
import logic.StatisticalManager;

public class AverageCalculation implements CalculationStrategy
{
    @Override
    public double doCalculation(StatisticalManager statisticalManager) 
    {
        return statisticalManager.getTotal() / statisticalManager.getNumbers().length;
    }
}

package logic.operations.calculations;

import logic.operations.CalculationStrategy;
import logic.StatisticalCalculator;
import logic.StatisticalManager;

public class StandardDeviationCalculation implements CalculationStrategy
{
    @Override
    public double doCalculation(StatisticalManager statisticalManager) 
    {
        double variance = StatisticalCalculator.VARIANCE.calculate(statisticalManager);
        return Math.sqrt(variance);
    }
}

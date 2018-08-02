package logic.Operations.Calculations;

import logic.Operations.CalculationStrategy;
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

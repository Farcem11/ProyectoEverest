package logic.statistical.calculations;

import logic.statistical.StatisticalCalculatorManager;
import model.object.StatisticalDataManager;

public class StandardDeviationCalculation implements CalculationStrategy
{
    @Override
    public double doCalculation(StatisticalDataManager statisticalDataManager) 
    {
        double variance = StatisticalCalculatorManager.getInstance().getVarianceCalculator().calculate(statisticalDataManager);
        return Math.sqrt(variance);
    }
}

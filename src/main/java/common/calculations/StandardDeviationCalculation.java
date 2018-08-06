package common.calculations;

import common.StatisticalCalculatorManager;
import model.StatisticalData;

public class StandardDeviationCalculation implements CalculationStrategy
{
    @Override
    public double doCalculation(StatisticalData statisticalDataManager) 
    {
        double variance = StatisticalCalculatorManager.getInstance().getVarianceCalculation(statisticalDataManager);
        return Math.sqrt(variance);
    }
}

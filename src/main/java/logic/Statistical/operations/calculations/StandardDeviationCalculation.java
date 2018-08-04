package logic.Statistical.operations.calculations;

import logic.Statistical.operations.CalculationStrategy;
import logic.Statistical.StatisticalCalculatorManager;
import model.database.object.StatisticalDataManager;

public class StandardDeviationCalculation implements CalculationStrategy
{
    @Override
    public double doCalculation(StatisticalDataManager statisticalDataManager) 
    {
        double variance = StatisticalCalculatorManager.getInstance().getVarianceCalculator().calculate(statisticalDataManager);
        return Math.sqrt(variance);
    }
}

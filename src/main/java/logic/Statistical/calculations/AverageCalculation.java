package logic.statistical.calculations;

import logic.statistical.calculations.CalculationStrategy;
import model.object.StatisticalDataManager;

public class AverageCalculation implements CalculationStrategy
{
    @Override
    public double doCalculation(StatisticalDataManager statisticalDataManager) 
    {
        return statisticalDataManager.getTotal() / statisticalDataManager.getNumbers().length;
    }
}

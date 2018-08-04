package logic.Statistical.operations.calculations;

import logic.Statistical.operations.CalculationStrategy;
import model.StatisticalDataManager;

public class AverageCalculation implements CalculationStrategy
{
    @Override
    public double doCalculation(StatisticalDataManager statisticalDataManager) 
    {
        return statisticalDataManager.getTotal() / statisticalDataManager.getNumbers().length;
    }
}

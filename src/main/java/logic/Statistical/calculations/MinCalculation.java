package logic.statistical.calculations;

import logic.statistical.calculations.CalculationStrategy;
import model.object.StatisticalDataManager;

public class MinCalculation implements CalculationStrategy
{
    @Override
    public double doCalculation(StatisticalDataManager statisticalDataManager) 
    {
        return statisticalDataManager.getMin();
    }
}

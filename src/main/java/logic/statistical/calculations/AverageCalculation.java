package logic.statistical.calculations;

import model.object.StatisticalDataManager;

public class AverageCalculation implements CalculationStrategy
{
    @Override
    public double doCalculation(StatisticalDataManager statisticalDataManager) 
    {
        return statisticalDataManager.getTotal() / statisticalDataManager.getNumbersArray().length;
    }
}

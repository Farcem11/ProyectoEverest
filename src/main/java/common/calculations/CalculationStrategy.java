package common.calculations;

import model.StatisticalData;

public interface CalculationStrategy 
{
    public double doCalculation(StatisticalData statisticalDataManager);
}
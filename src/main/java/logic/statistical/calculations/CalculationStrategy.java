package logic.statistical.calculations;

import model.object.StatisticalDataManager;

public interface CalculationStrategy 
{
    public double doCalculation(StatisticalDataManager statisticalDataManager);
}
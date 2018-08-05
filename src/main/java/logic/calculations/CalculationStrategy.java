package logic.calculations;

import model.StatisticalDataManager;

public interface CalculationStrategy 
{
    public double doCalculation(StatisticalDataManager statisticalDataManager);
}
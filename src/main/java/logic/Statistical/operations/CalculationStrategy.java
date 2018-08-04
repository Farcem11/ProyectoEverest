package logic.Statistical.operations;

import model.StatisticalDataManager;

public interface CalculationStrategy 
{
    public double doCalculation(StatisticalDataManager statisticalDataManager);
}
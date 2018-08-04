package logic.Statistical.operations;

import model.database.object.StatisticalDataManager;

public interface CalculationStrategy 
{
    public double doCalculation(StatisticalDataManager statisticalDataManager);
}
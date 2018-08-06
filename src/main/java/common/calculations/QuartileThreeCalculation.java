package common.calculations;

import model.StatisticalDataManager;

public class QuartileThreeCalculation implements CalculationStrategy
{
    @Override
    public double doCalculation(StatisticalDataManager statisticalDataManager) 
    {
        int quartileThreeIndex = (3*(statisticalDataManager.getNumbersArray().length + 1)) / 4;
        return statisticalDataManager.getNumbersArray()[quartileThreeIndex - 1];
    }
}
package common.calculations;

import model.StatisticalData;

public class QuartileThreeCalculation implements CalculationStrategy
{
    @Override
    public double doCalculation(StatisticalData statisticalDataManager) 
    {
        int quartileThreeIndex = (3*(statisticalDataManager.getNumbersArray().length + 1)) / 4;
        return statisticalDataManager.getNumbersArray()[quartileThreeIndex - 1];
    }
}
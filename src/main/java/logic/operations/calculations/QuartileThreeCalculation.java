package logic.operations.calculations;

import logic.operations.CalculationStrategy;
import logic.StatisticalManager;

public class QuartileThreeCalculation implements CalculationStrategy
{
    @Override
    public double doCalculation(StatisticalManager statisticalManager) 
    {
        int quartileThreeIndex = (3*(statisticalManager.getNumbers().length + 1)) / 4;
        return statisticalManager.getNumbers()[quartileThreeIndex - 1];
    }
}
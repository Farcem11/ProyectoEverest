package logic.Operations.Calculations;

import logic.Operations.CalculationStrategy;
import logic.StatisticalManager;

public class QuartileThreeCalculation implements CalculationStrategy
{
    @Override
    public double doCalculation(StatisticalManager statisticalManager) 
    {
        int quartileThreeIndex = 3/4 * (statisticalManager.getNumbers().length + 1);
        return statisticalManager.getNumbers()[quartileThreeIndex];
    }
}
package logic.Operations.Calculations;

import logic.Operations.CalculationStrategy;
import logic.StatisticalManager;

public class QuartileOneCalculation implements CalculationStrategy
{
    @Override
    public double doCalculation(StatisticalManager statisticalManager) 
    {
        int quartileOneIndex = 1/4 * (statisticalManager.getNumbers().length + 1);
        return statisticalManager.getNumbers()[quartileOneIndex];
    }
}

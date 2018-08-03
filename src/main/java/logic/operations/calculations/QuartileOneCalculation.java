package logic.operations.calculations;

import logic.operations.CalculationStrategy;
import logic.StatisticalManager;

public class QuartileOneCalculation implements CalculationStrategy
{
    @Override
    public double doCalculation(StatisticalManager statisticalManager) 
    {
        int quartileOneIndex = (statisticalManager.getNumbers().length + 1) / 4;
        return statisticalManager.getNumbers()[quartileOneIndex - 1];
    }
}

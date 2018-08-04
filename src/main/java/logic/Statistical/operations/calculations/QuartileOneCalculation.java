package logic.Statistical.operations.calculations;

import logic.Statistical.operations.CalculationStrategy;
import model.StatisticalDataManager;

public class QuartileOneCalculation implements CalculationStrategy
{
    @Override
    public double doCalculation(StatisticalDataManager statisticalDataManager) 
    {
        int quartileOneIndex = (statisticalDataManager.getNumbers().length + 1) / 4;
        return statisticalDataManager.getNumbers()[quartileOneIndex - 1];
    }
}

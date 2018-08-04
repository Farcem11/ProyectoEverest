package logic.statistical.calculations;

import logic.statistical.calculations.CalculationStrategy;
import model.object.StatisticalDataManager;

public class QuartileOneCalculation implements CalculationStrategy
{
    @Override
    public double doCalculation(StatisticalDataManager statisticalDataManager) 
    {
        int quartileOneIndex = (statisticalDataManager.getNumbers().length + 1) / 4;
        return statisticalDataManager.getNumbers()[quartileOneIndex - 1];
    }
}

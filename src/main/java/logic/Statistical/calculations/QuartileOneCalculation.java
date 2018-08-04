package logic.statistical.calculations;

import model.object.StatisticalDataManager;

public class QuartileOneCalculation implements CalculationStrategy
{
    @Override
    public double doCalculation(StatisticalDataManager statisticalDataManager) 
    {
        int quartileOneIndex = (statisticalDataManager.getNumbersArray().length + 1) / 4;
        return statisticalDataManager.getNumbersArray()[quartileOneIndex - 1];
    }
}

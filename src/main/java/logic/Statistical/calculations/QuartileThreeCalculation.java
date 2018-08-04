package logic.statistical.calculations;

import logic.statistical.calculations.CalculationStrategy;
import model.object.StatisticalDataManager;

public class QuartileThreeCalculation implements CalculationStrategy
{
    @Override
    public double doCalculation(StatisticalDataManager statisticalDataManager) 
    {
        int quartileThreeIndex = (3*(statisticalDataManager.getNumbers().length + 1)) / 4;
        return statisticalDataManager.getNumbers()[quartileThreeIndex - 1];
    }
}
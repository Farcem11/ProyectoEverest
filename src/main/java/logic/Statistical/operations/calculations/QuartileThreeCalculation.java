package logic.Statistical.operations.calculations;

import logic.Statistical.operations.CalculationStrategy;
import model.database.object.StatisticalDataManager;

public class QuartileThreeCalculation implements CalculationStrategy
{
    @Override
    public double doCalculation(StatisticalDataManager statisticalDataManager) 
    {
        int quartileThreeIndex = (3*(statisticalDataManager.getNumbers().length + 1)) / 4;
        return statisticalDataManager.getNumbers()[quartileThreeIndex - 1];
    }
}
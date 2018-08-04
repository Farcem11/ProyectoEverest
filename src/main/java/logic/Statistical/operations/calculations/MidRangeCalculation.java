package logic.Statistical.operations.calculations;

import logic.Statistical.operations.CalculationStrategy;
import model.database.object.StatisticalDataManager;

public class MidRangeCalculation  implements CalculationStrategy 
{
    @Override
    public double doCalculation(StatisticalDataManager statisticalDataManager) 
    {
        return (statisticalDataManager.getMax() + statisticalDataManager.getMin()) / 2;
    }
}

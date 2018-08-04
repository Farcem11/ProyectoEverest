package logic.statistical.calculations;

import logic.statistical.calculations.CalculationStrategy;
import model.object.StatisticalDataManager;

public class MidRangeCalculation  implements CalculationStrategy 
{
    @Override
    public double doCalculation(StatisticalDataManager statisticalDataManager) 
    {
        return (statisticalDataManager.getMax() + statisticalDataManager.getMin()) / 2;
    }
}

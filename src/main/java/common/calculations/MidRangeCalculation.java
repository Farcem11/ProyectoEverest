package common.calculations;

import model.StatisticalDataManager;

public class MidRangeCalculation  implements CalculationStrategy 
{
    @Override
    public double doCalculation(StatisticalDataManager statisticalDataManager) 
    {
        return (statisticalDataManager.getMax() + statisticalDataManager.getMin()) / 2;
    }
}

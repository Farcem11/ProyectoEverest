package common.calculations;

import model.StatisticalData;

public class MidRangeCalculation  implements CalculationStrategy 
{
    @Override
    public double doCalculation(StatisticalData statisticalDataManager) 
    {
        return (statisticalDataManager.getMax() + statisticalDataManager.getMin()) / 2;
    }
}

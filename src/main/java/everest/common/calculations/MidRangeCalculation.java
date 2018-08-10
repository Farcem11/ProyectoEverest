package everest.common.calculations;

import everest.model.StatisticalData;

public class MidRangeCalculation  implements CalculationStrategy 
{
    @Override
    public double doCalculation(StatisticalData statisticalData) 
    {
        return (statisticalData.getMax() + statisticalData.getMin()) / 2;
    }
}

package everest.common.calculations;

import everest.model.StatisticalData;

public class MinCalculation implements CalculationStrategy
{
    @Override
    public double doCalculation(StatisticalData statisticalData) 
    {
        return statisticalData.getMin();
    }
}

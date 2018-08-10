package everest.common.calculations;

import everest.model.StatisticalData;

public class MaxCalculation implements CalculationStrategy
{
    @Override
    public double doCalculation(StatisticalData statisticalData) 
    {
        return statisticalData.getMax();
    }
}

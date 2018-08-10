package everest.common.calculations;

import everest.model.StatisticalData;

public class AverageCalculation implements CalculationStrategy
{
    @Override
    public double doCalculation(StatisticalData statisticalData) 
    {
        return statisticalData.getTotal() / statisticalData.getNumbersArray().length;
    }
}

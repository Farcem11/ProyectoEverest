package everest.common.calculations;

import everest.model.StatisticalData;

public interface CalculationStrategy 
{
    public double doCalculation(StatisticalData statisticalData);
}
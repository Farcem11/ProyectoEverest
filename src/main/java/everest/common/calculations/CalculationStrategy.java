package everest.common.calculations;

import java.util.List;

import everest.model.StatisticalData;

public interface CalculationStrategy 
{
    public List<Double> doCalculation(StatisticalData statisticalData);
}
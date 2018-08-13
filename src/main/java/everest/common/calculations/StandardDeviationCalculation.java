package everest.common.calculations;

import java.util.Arrays;
import java.util.List;

import everest.model.StatisticalData;

public class StandardDeviationCalculation implements CalculationStrategy
{
	private final CalculationStrategy varianceCalculation = new VarianceCalculation();
	
    @Override
    public List<Double> doCalculation(StatisticalData statisticalData) 
    {
        double variance = varianceCalculation.doCalculation(statisticalData).get(0);
        return Arrays.asList(Math.sqrt(variance));
    }
}

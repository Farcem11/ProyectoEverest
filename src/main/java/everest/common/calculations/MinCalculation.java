package everest.common.calculations;

import java.util.Arrays;
import java.util.List;

import everest.model.StatisticalData;

public class MinCalculation implements CalculationStrategy
{
	@Override
    public List<Double> doCalculation(StatisticalData statisticalData) 
    {
		return Arrays.asList(statisticalData.getMin());
    }
}

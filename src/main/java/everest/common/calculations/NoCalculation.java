package everest.common.calculations;

import everest.model.StatisticalData;

public class NoCalculation implements CalculationStrategy
{
	@Override
	public double doCalculation(StatisticalData statisticalData) 
	{
		return 0;
	}
}

package everest.common.calculations;

import everest.common.CalculationType;
import everest.common.StatisticalCalculator;
import everest.model.StatisticalData;

public class StandardDeviationCalculation implements CalculationStrategy
{
    @Override
    public double doCalculation(StatisticalData statisticalData) 
    {
        double variance = StatisticalCalculator.getInstance().calculate(CalculationType.VARIANCE, statisticalData);
        return Math.sqrt(variance);
    }
}

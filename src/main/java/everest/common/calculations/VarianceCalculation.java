package everest.common.calculations;

import java.util.Arrays;
import java.util.List;

import everest.model.StatisticalData;

public class VarianceCalculation implements CalculationStrategy
{
	private final CalculationStrategy averageCalculation = new AverageCalculation();
	
    @Override
    public List<Double> doCalculation(StatisticalData statisticalData) 
    {
        double[] numbers = statisticalData.getNumbersArray();
        double average = averageCalculation.doCalculation(statisticalData).get(0);

        double variance = 0;
        for(double number : numbers)
        {
            variance += Math.pow((number - average), 2);
        }
        return Arrays.asList(variance / numbers.length);
    }   
}

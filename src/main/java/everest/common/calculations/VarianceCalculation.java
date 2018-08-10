package everest.common.calculations;

import everest.common.CalculationType;
import everest.common.StatisticalCalculator;
import everest.model.StatisticalData;

public class VarianceCalculation implements CalculationStrategy
{
    @Override
    public double doCalculation(StatisticalData statisticalData) 
    {
        double[] numbers = statisticalData.getNumbersArray();
        double average = StatisticalCalculator.getInstance().calculate(CalculationType.AVERAGE, statisticalData);

        double variance = 0;
        for(double number : numbers)
        {
            variance += Math.pow((number - average), 2);
        }
        
        return variance / numbers.length;
    }   
}

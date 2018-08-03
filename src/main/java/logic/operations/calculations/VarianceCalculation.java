package logic.operations.calculations;

import logic.operations.CalculationStrategy;
import logic.StatisticalCalculator;
import logic.StatisticalManager;

public class VarianceCalculation implements CalculationStrategy
{
    @Override
    public double doCalculation(StatisticalManager statisticalManager) 
    {
        Double[] numbers = statisticalManager.getNumbers();
        double average = StatisticalCalculator.AVERAGE.calculate(statisticalManager);
        double variance = 0;
        for(double number : numbers)
        {
            variance += Math.pow((number - average), 2);
        }
        
        return variance / numbers.length;
    }   
}

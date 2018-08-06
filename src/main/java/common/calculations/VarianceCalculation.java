package common.calculations;

import common.StatisticalCalculatorManager;
import model.StatisticalData;

public class VarianceCalculation implements CalculationStrategy
{
    @Override
    public double doCalculation(StatisticalData statisticalDataManager) 
    {
        double[] numbers = statisticalDataManager.getNumbersArray();
        double average = StatisticalCalculatorManager.getInstance().getAverageCalculation(statisticalDataManager);

        double variance = 0;
        for(double number : numbers)
        {
            variance += Math.pow((number - average), 2);
        }
        
        return variance / numbers.length;
    }   
}

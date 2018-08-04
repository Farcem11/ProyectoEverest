package logic.statistical.calculations;

import logic.statistical.StatisticalCalculatorManager;
import model.object.StatisticalDataManager;

public class VarianceCalculation implements CalculationStrategy
{
    @Override
    public double doCalculation(StatisticalDataManager statisticalDataManager) 
    {
        double[] numbers = statisticalDataManager.getNumbersArray();
        double average = StatisticalCalculatorManager.getInstance().getAverageCalculator().calculate(statisticalDataManager);
        double variance = 0;
        for(double number : numbers)
        {
            variance += Math.pow((number - average), 2);
        }
        
        return variance / numbers.length;
    }   
}

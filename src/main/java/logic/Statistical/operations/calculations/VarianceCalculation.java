package logic.Statistical.operations.calculations;

import logic.Statistical.operations.CalculationStrategy;
import logic.Statistical.StatisticalCalculatorManager;
import model.database.object.StatisticalDataManager;

public class VarianceCalculation implements CalculationStrategy
{
    @Override
    public double doCalculation(StatisticalDataManager statisticalDataManager) 
    {
        double[] numbers = statisticalDataManager.getNumbers();
        double average = StatisticalCalculatorManager.getInstance().getAverageCalculator().calculate(statisticalDataManager);
        double variance = 0;
        for(double number : numbers)
        {
            variance += Math.pow((number - average), 2);
        }
        
        return variance / numbers.length;
    }   
}

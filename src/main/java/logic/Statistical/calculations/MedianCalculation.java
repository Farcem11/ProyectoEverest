package logic.statistical.calculations;

import model.object.StatisticalDataManager;
import logic.statistical.calculations.CalculationStrategy;

public class MedianCalculation implements CalculationStrategy
{
    @Override
    public double doCalculation(StatisticalDataManager statisticalDataManager) 
    {
        double[] numbers = statisticalDataManager.getNumbers();
        int lenght = numbers.length;
        int halfLength = lenght / 2;
        
        if(lenght % 2 == 0)
        {
            return (numbers[halfLength - 1] + numbers[halfLength]) / 2; 
        }
        else
        {
            return numbers[halfLength];
        }
    }
}

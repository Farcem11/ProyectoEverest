package logic.Statistical.operations.calculations;

import model.StatisticalDataManager;
import logic.Statistical.operations.CalculationStrategy;

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

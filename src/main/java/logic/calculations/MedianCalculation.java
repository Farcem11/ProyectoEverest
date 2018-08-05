package logic.calculations;

import model.StatisticalDataManager;

public class MedianCalculation implements CalculationStrategy
{
    @Override
    public double doCalculation(StatisticalDataManager statisticalDataManager) 
    {
        double[] numbers = statisticalDataManager.getNumbersArray();
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

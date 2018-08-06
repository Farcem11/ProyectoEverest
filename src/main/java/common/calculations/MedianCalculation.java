package common.calculations;

import model.StatisticalData;

public class MedianCalculation implements CalculationStrategy
{
    @Override
    public double doCalculation(StatisticalData statisticalDataManager) 
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

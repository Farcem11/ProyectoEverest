package logic.operations.calculations;

import logic.StatisticalManager;
import logic.operations.CalculationStrategy;

public class MedianCalculation implements CalculationStrategy
{
    @Override
    public double doCalculation(StatisticalManager statisticalManager) 
    {
        int lenght = statisticalManager.getNumbers().length;
        int halfLength = lenght / 2;
        
        if(lenght % 2 == 0)
        {
            return (statisticalManager.getNumbers()[halfLength - 1] + statisticalManager.getNumbers()[halfLength]) / 2; 
        }
        else
        {
            return statisticalManager.getNumbers()[halfLength];
        }
    }
}

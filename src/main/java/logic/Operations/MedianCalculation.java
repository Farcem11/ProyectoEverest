package logic.Operations;

import logic.StatisticalManager;
import logic.Algorithms.Sorting.QuickSort;

public class MedianCalculation implements CalculationStrategy
{
    @Override
    public double doCalculation(StatisticalManager statisticalManager) 
    {
        Double[] array = new Double[statisticalManager.getSize()];
        statisticalManager.getNumbers().toArray(array);
        int halfSize = statisticalManager.getSize() / 2;
        new QuickSort().sort(array);
        
        if(statisticalManager.getSize() % 2 == 0)
        {
            return (array[halfSize - 1] + array[halfSize]) / 2; 
        }
        else
        {
            return array[halfSize];
        }
    }
}

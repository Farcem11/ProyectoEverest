package logic;

import java.util.ArrayList;
import logic.algorithms.sorting.QuickSort;
public class StatisticalManager 
{
    private final Double[] numbers;
    private double total;
    private final double max;
    private final double min;

    public StatisticalManager(String[] textNumbers)
    {       
        ArrayList<Double> numbersList = new ArrayList<>();
        total = 0;

        for(String textNumber : textNumbers)
        {
            double number = Double.parseDouble(textNumber);
            total += number;             
            numbersList.add(number);                
        }

        numbers = new Double[numbersList.size()];
        numbersList.toArray(numbers);
        new QuickSort().sort(numbers);

        max = numbers[numbers.length - 1];
        min = numbers[0];
    }
    
    /**
     * @return the numbersList
     */
    public Double[] getNumbers() 
    {
        return numbers;
    }

    /**
     * @return the total
     */
    public double getTotal() 
    {
        return total;
    }

    /**
     * @return the max
     */
    public double getMax() 
    {
        return max;
    }

    /**
     * @return the min
     */
    public double getMin() 
    {
        return min;
    }  
}

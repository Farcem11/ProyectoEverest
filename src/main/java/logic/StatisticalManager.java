package logic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import logic.algorithms.sorting.QuickSort;

public class StatisticalManager 
{
    private Double[] numbers;
    private double total;
    private double max;
    private double min;
    
    public StatisticalManager(String filePath)
    {
        ArrayList<Double> numbersList = new ArrayList<>();
        total = 0;
        
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) 
        {
            String line = br.readLine(); 
            String[] textNumbers = line.split(",");
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
        catch(IOException e) 
        {
            e.printStackTrace();
        }
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

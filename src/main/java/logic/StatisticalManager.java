package logic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class StatisticalManager 
{
    private ArrayList<Double> numbers;
    private double sum;
    private double max;
    private double min;
    private int size;
    
    public StatisticalManager(String filePath)
    {
        numbers = new ArrayList<>();
        sum = 0;
        max = Double.NEGATIVE_INFINITY;
        min = Double.POSITIVE_INFINITY;
        size = 0;
        
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) 
        {
            String line = br.readLine(); 
            String[] textNumbers = line.split(",");
            for(String textNumber : textNumbers)
            {
                double number = Double.valueOf(textNumber);
                
                sum += number;
                
                if(number > max)
                    max = number;
                
                if(number < min)
                    min = number;
                
                numbers.add(number);
                
                size++;
            }
        } 
        catch(IOException e) 
        {
            e.printStackTrace();
        }
    }

    /**
     * @return the numbers
     */
    public ArrayList<Double> getNumbers() 
    {
        return numbers;
    }

    /**
     * @return the sum
     */
    public double getSum() 
    {
        return sum;
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

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }
}

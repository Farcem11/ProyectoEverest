package model;

import java.util.ArrayList;
import java.util.List;
import logic.algorithms.sorting.QuickSort;

public class StatisticalDataManager
{
    private final double[] numbers;
    private double total;
    private final double max;
    private final double min;
    private final String fileName;
    private final String filePath;

    public StatisticalDataManager(double[] numbers, double total, double max, double min, String fileName, String filePath) 
    {
        this.numbers = numbers;
        this.total = total;
        this.max = max;
        this.min = min;
        this.fileName = fileName;
        this.filePath = filePath;
    }
    
    /**
     * @return the numbersList
     */
    public double[] getNumbers() 
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

    public String getFileName() 
    {
        return fileName;
    }

    public String getFilePath() 
    {
        return filePath;
    }
}

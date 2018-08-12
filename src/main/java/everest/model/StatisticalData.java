package everest.model;

import java.util.logging.Level;
import java.util.logging.Logger;

public class StatisticalData implements Cloneable
{
    private long id;
    private final String name;
    private final String numbers;
    private double[] numbersArray;
    private final double total;
    private final double max;
    private final double min;

    public StatisticalData(long id, String name, double[] numbersArray, String numbers, double total, double max, double min) 
    {
        this.id = id;
        this.numbersArray = numbersArray;
        this.total = total;
        this.max = max;
        this.min = min;
        this.name = name;
        this.numbers = numbers;
    }
    
    public StatisticalData(String name, double[] numbersArray, String numbers, double total, double max, double min) 
    {
        this.id = 0L;
        this.numbersArray = numbersArray;
        this.total = total;
        this.max = max;
        this.min = min;
        this.name = name;
        this.numbers = numbers;
    }
    
    @Override
    public StatisticalData clone() 
    {
        try 
        {
			return (StatisticalData)super.clone();
		} 
        catch (CloneNotSupportedException e) 
        {
        	Logger.getLogger(StatisticalData.class.getName()).log(Level.SEVERE, "Clone Not Supported Exception {0}", e.getMessage());
			return null;
		}
    }
    
    public String getName() 
    {
		return name;
	}

	public String getNumbers() 
	{
		return numbers;
	}

	public double[] getNumbersArray() 
    {
        return numbersArray;
    }
    
    public double getTotal() 
    {
        return total;
    }

    public double getMax() 
    {
        return max;
    }

    public double getMin() 
    {
        return min;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) 
    {
        this.id = id;
    }
    
    public void setNumbersArray(double[] numbersArray) 
    {
    	this.numbersArray = numbersArray;
    }
}

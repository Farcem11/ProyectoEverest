package model;

public class StatisticalData
{
    private long id;
    private String name;
    private String numbers;
    private double[] numbersArray;
    private double total;
    private double max;
    private double min;

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
    
    /**
     * @return the numbersList
     */
    public double[] getNumbersArray() 
    {
        return numbersArray;
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

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param numbersArray the numbersArray to set
     */
    public void setNumbersArray(double[] numbersArray) {
        this.numbersArray = numbersArray;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * @param max the max to set
     */
    public void setMax(double max) {
        this.max = max;
    }

    /**
     * @param min the min to set
     */
    public void setMin(double min) {
        this.min = min;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumbers() {
		return numbers;
	}

	public void setNumbers(String numbers) {
		this.numbers = numbers;
	}
}

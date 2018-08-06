package model;

import java.io.File;

public class StatisticalData
{
    private long id;
    private String fileContent;
    private double[] numbersArray;
    private double total;
    private double max;
    private double min;
    private final File file;

    public StatisticalData(double[] numbers, double total, double max, double min, File file, String fileContent) 
    {
        this.id = 0L;
        this.numbersArray = numbers;
        this.total = total;
        this.max = max;
        this.min = min;
        this.file = file;
        this.fileContent = fileContent ;
    }
    
    public StatisticalData(long idStatisticalManager, double[] numbers, double total, double max, double min, File file, String fileContent) 
    {
        this.id = idStatisticalManager; 
        this.numbersArray = numbers;
        this.total = total;
        this.max = max;
        this.min = min;
        this.file = file;
        this.fileContent = fileContent;
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
     * @return the fileContent
     */
    public String getFileContent() {
        return fileContent;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param fileContent the fileContent to set
     */
    public void setFileContent(String fileContent) {
        this.fileContent = fileContent;
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
     * @return the file
     */
    public File getFile() {
        return file;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }
}

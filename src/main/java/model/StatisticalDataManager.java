package model;

public class StatisticalDataManager
{
    private final String fileContent;
    private final double[] numbersArray;
    private final double total;
    private final double max;
    private final double min;
    private final String fileName;
    private final String filePath;

    public StatisticalDataManager(double[] numbers, double total, double max, double min, String fileName, String filePath, String fileContent) 
    {
        this.numbersArray = numbers;
        this.total = total;
        this.max = max;
        this.min = min;
        this.fileName = fileName;
        this.filePath = filePath;
        this.fileContent = fileContent ;
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
     * @return the fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @return the filePath
     */
    public String getFilePath() {
        return filePath;
    }
}

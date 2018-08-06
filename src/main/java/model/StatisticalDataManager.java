package model;

public class StatisticalDataManager
{
    private String fileContent;
    private double[] numbersArray;
    private double total;
    private double max;
    private double min;
    private String fileName;
    private String filePath;

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

    public void setFileContent(String fileContent) {
        this.fileContent = fileContent;
    }

    public void setNumbersArray(double[] numbersArray) {
        this.numbersArray = numbersArray;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}

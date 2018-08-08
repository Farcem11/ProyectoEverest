package common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.DoubleStream;
import common.algorithms.sorting.QuickSort;
import model.StatisticalData;
import service.StatisticalDataService;

public class StatisticalDataManager 
{
    private static final StatisticalDataManager instance = new StatisticalDataManager();
    private final StatisticalDataService statisticalDataService = new StatisticalDataService();
    private final Map<Long, StatisticalData> statisticalDataMap = statisticalDataService.getStatisticalDataMap();
    
    private StatisticalDataManager(){}
    
    public static StatisticalDataManager getInstance()
    {
        return instance;
    }
    
    public Map<Long, StatisticalData> getStatisticalDataMap() 
	{
		return statisticalDataMap;
	}
    
    public StatisticalData validateAndParse(String name, String fileContent) throws IOException
    {
    	try(Scanner scanner = new Scanner(fileContent))
    	{
            String numbers = scanner.nextLine();
            
            if(numbers.isEmpty())
            {
                throw new IOException("First line is empty: " + name);
            }
            else if(scanner.hasNextLine())
            {
                throw new IOException("File has more than one line: " + name);
            }
            double[] numbersArray = castStringToNumbers(numbers);
            double total = DoubleStream.of(numbersArray).sum();
            double max = numbersArray[numbersArray.length - 1];
            double min = numbersArray[0];

            return new StatisticalData(name, numbersArray, numbers, total, max, min);	
    	}
    }
    
    public double[] castStringToNumbers(String textNumbers)
    {
        List<Double> numbersList = new ArrayList<>();
        String[] textNumbersList = textNumbers.split(",");
        for(String textNumber : textNumbersList)
        {
            double number = Double.parseDouble(textNumber);
            numbersList.add(number);
        }
        return castListToArray(numbersList);        
    }
    
    private double[] castListToArray(List<Double> numbersList)
    {
        int listSize = numbersList.size();
        double[] numbers = new double[listSize];
        for(int i = 0; i < listSize; i++)
        {
            numbers[i] = numbersList.get(i);
        }
        QuickSort.getInstance().sort(numbers);
        return numbers;
    }
}

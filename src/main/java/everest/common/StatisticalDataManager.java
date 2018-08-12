package everest.common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.DoubleStream;
import everest.common.algorithms.sorting.QuickSort;
import everest.model.StatisticalData;

public class StatisticalDataManager 
{
    private StatisticalDataManager() {}

	private static final StatisticalDataManager instance = new StatisticalDataManager();
	
    public static synchronized StatisticalDataManager getInstance()
    {
        return instance;
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
    	catch(NullPointerException ex)
    	{
    		throw new NullPointerException("File content is empty");
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
    
    public Map<String, Double> getStatisticalCalculations(StatisticalData statisticalData)
    {
    	Map<String, Double> calculationsMap = new HashMap<>();
    	
    	for(CalculationTypeEnum calculationType : CalculationTypeEnum.values()) 
    	{
        	calculationsMap.put(calculationType.name(), StatisticalCalculator.getInstance().calculate(calculationType, statisticalData));
		}
    	
    	return calculationsMap;
    }
}
package everest.common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.DoubleStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import everest.common.algorithms.sorting.QuickSort;
import everest.model.StatisticalData;

@Component
public class StatisticalDataManager 
{
	@Autowired
	private StatisticalCalculator statisticalCalculator;
	
	@Autowired
	private QuickSort quickSort;
	
    public StatisticalData validateAndParse(String name, String fileContent) throws IOException
    {
    	if(fileContent == null)
    	{
    		throw new IOException("The file can't be null");
    	}
    	try(Scanner scanner = new Scanner(fileContent))
    	{
            String numbers = scanner.nextLine();
            
            if(numbers.isEmpty())
            {
                throw new IOException("The first line of the file is empty");
            }
            else if(scanner.hasNextLine())
            {
                throw new IOException("The file has more than one line");
            }
            double[] numbersArray = castStringToNumbers(numbers);
            double total = DoubleStream.of(numbersArray).sum();
            double max = numbersArray[numbersArray.length - 1];
            double min = numbersArray[0];

            return new StatisticalData(name, numbersArray, numbers, total, max, min);	
    	}
    	catch(NoSuchElementException ex)
    	{
    		throw new NoSuchElementException("The file is empty");
    	}
    }
    
    public double[] castStringToNumbers(String textNumbers)
    {
        List<Double> numbersList = new ArrayList<>();
        String[] textNumbersList = textNumbers.split(",");
        try 
        {
            for(String textNumber : textNumbersList)
            {
                double number = Double.parseDouble(textNumber);
                numbersList.add(number);
            }
            return castListToArray(numbersList);        	
        }
        catch(NumberFormatException ex)
        {
        	throw new NumberFormatException("The file needs to have only numbers");
        }
    }
    
    private double[] castListToArray(List<Double> numbersList)
    {
        int listSize = numbersList.size();
        double[] numbers = new double[listSize];
        for(int i = 0; i < listSize; i++)
        {
            numbers[i] = numbersList.get(i);
        }
        quickSort.sort(numbers);
        return numbers;
    }
    
    public Map<String, List<Double>> getStatisticalCalculations(StatisticalData statisticalData)
    {
    	Map<String, List<Double>> calculationsMap = new HashMap<>();
    	
    	for(CalculationTypeEnum calculationType : CalculationTypeEnum.values()) 
    	{
        	calculationsMap.put(calculationType.name(), statisticalCalculator.calculate(calculationType, statisticalData));
		}
    	
    	return calculationsMap;
    }
}

package logic.statistical;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.DoubleStream;
import logic.algorithms.sorting.QuickSort;
import model.object.StatisticalDataManager;

public class StatisticalFileManager 
{
    private static final StatisticalFileManager instance = new StatisticalFileManager();

    private StatisticalFileManager(){}

    public static StatisticalFileManager getInstance()
    {
        return instance;
    }
    
    public StatisticalDataManager validateAndParseStatisticalData(String fileFullPath)
    {
        File file = new File(fileFullPath);
        try(BufferedReader br = new BufferedReader(new FileReader(file))) 
        {
            String textFile = br.readLine();
            String nextLine = br.readLine();
            
            if(textFile == null)
            {
                Logger.getLogger(StatisticalDataManager.class.getName()).log(Level.WARNING, "File is empty {0}", file.getAbsolutePath());
                return null;
            }
            else if(textFile.isEmpty())
            {
                Logger.getLogger(StatisticalDataManager.class.getName()).log(Level.WARNING, "First line is empty {0}", file.getAbsolutePath());
                return null;
            }
            else if(nextLine != null)
            {
                Logger.getLogger(StatisticalDataManager.class.getName()).log(Level.WARNING, "File has more than one line {0}", file.getAbsolutePath());
                return null;
            }
            double[] numbers = castStringToNumbers(textFile);
            double total = DoubleStream.of(numbers).sum();
            double max = numbers[numbers.length - 1];
            double min = numbers[0];
            String filePath = file.getAbsolutePath();
            String fileName = file.getName();
            return new StatisticalDataManager(numbers, total, max, min, fileName, filePath);
        }
        catch(IOException e) 
        {
            Logger.getLogger(StatisticalDataManager.class.getName()).log(Level.WARNING, "IO Exception {0}", e.getMessage());
            return null;
        }
        catch(NumberFormatException e)
        {
            Logger.getLogger(StatisticalDataManager.class.getName()).log(Level.WARNING, "Is not a list of numbers {0}", e.getMessage());
            return null;
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

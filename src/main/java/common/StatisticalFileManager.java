package common;

import com.google.common.io.Files;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.DoubleStream;
import common.algorithms.sorting.QuickSort;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.IllegalFormatException;
import model.StatisticalData;

public class StatisticalFileManager 
{
    private static final StatisticalFileManager instance = new StatisticalFileManager();

    private StatisticalFileManager(){}

    public static StatisticalFileManager getInstance()
    {
        return instance;
    }
    
    public StatisticalData parseFileToStatisticalData(File file) throws IOException
    {
        try(BufferedReader br = new BufferedReader(new FileReader(file))) 
        {
            String textNumbers = br.readLine();
            String nextLine = br.readLine();
            
            if(textNumbers == null)
            {
                throw new IOException("File is empty: " + file.getAbsolutePath());
            }
            else if(textNumbers.isEmpty())
            {
                throw new IOException("First line is empty: " + file.getAbsolutePath());
            }
            else if(nextLine != null)
            {
                throw new IOException("File has more than one line: " + file.getAbsolutePath());
            }
            double[] numbers = castStringToNumbers(textNumbers);
            double total = DoubleStream.of(numbers).sum();
            double max = numbers[numbers.length - 1];
            double min = numbers[0];

            return new StatisticalData(numbers, total, max, min, file, textNumbers);
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

    public File updateFileSystem(String currentFilePath, String newFilePath, String newFileContent) throws IOException 
    {
        File currentFile = new File(currentFilePath);
        
        if(newFileContent != null)
            overwriteFile(currentFile, newFileContent);
        
        if(newFilePath != null)
        {
            File newFile = new File(newFilePath);
            Files.move(currentFile, newFile); // Move file to new location
            return newFile;
        }
        return currentFile;
    }
    
    private void overwriteFile(File file, String newFileContent) throws IOException
    {
        try(FileWriter fileWriter = new FileWriter(file, false)) // false to overwrite. 
        {
            fileWriter.write(newFileContent);
            fileWriter.close();
        }        
    }
}

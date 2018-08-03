package logic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class FileValidator 
{
    private static final Logger logger = Logger.getLogger(StatisticalManager.class.getName());
    
    public static StatisticalManager newStatisticalManager(String filePath)
    {
        String[] numbers = getNumbers(filePath);
        if(numbers != null)
        {
            return new StatisticalManager(numbers);
        }
        return null;
    }
    
    public static String[] getNumbers(String filePath)
    {
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) 
        {
            String textFile = br.readLine();
            String nextLine = br.readLine();
            
            if(textFile == null || textFile.isEmpty())
            {
                logger.log(Level.WARNING, "File is empty", filePath);
                return null;
            }
            
            if(nextLine != null)
            {
                logger.log(Level.WARNING, "File has more than one line", filePath);
                return null;
            }
            
            String[] textNumbers = textFile.split(",");
            for(String textNumber : textNumbers)
            {
                Double.parseDouble(textNumber);
            }
            return textNumbers;
        }
        catch(FileNotFoundException e) 
        {
            logger.log(Level.WARNING, "File not found", filePath);
            return null;
        } 
        catch(IOException e) 
        {
            logger.log(Level.WARNING, "IO Exception", filePath);
            return null;
        }
        catch(NumberFormatException e)
        {
            logger.log(Level.WARNING, "Not a number", filePath);
            return null;
        }
    }
}

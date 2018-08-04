package logic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class StatisticalValidator 
{
    private static final Logger logger = Logger.getLogger(StatisticalManager.class.getName());
    
    public static StatisticalManager getStatisticalManager(String filePath)
    {
        String[] numbers = validateAndGetNumbers(filePath);
        if(numbers != null)
        {
            return new StatisticalManager(numbers);
        }
        return null;
    }
    
    public static String[] validateAndGetNumbers(String filePath)
    {
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) 
        {
            String textFile = br.readLine();
            String nextLine = br.readLine();
            
            if(textFile == null)
            {
                logger.log(Level.WARNING, "File is empty", filePath);
                return null;
            }
            else if(textFile.isEmpty())
            {
                logger.log(Level.WARNING, "First line is empty", filePath);
                return null;
            }
            else if(nextLine != null)
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
            logger.log(Level.WARNING, "File not found", e.getMessage());
            return null;
        } 
        catch(IOException e) 
        {
            logger.log(Level.WARNING, "IO Exception", e.getMessage());
            return null;
        }
        catch(NumberFormatException e)
        {
            logger.log(Level.WARNING, "Is not a list of numbers", e.getMessage());
            return null;
        }
    }
}

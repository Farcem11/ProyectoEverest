package logic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StatisticalValidator 
{
    private StatisticalValidator() 
    {
        throw new IllegalStateException("Statistical Validator");
    }
    
    private static final Logger logger = Logger.getLogger(StatisticalManager.class.getName());
    
    public static StatisticalManager getStatisticalManager(String filePath)
    {
        String[] numbers = validateAndGetNumbers(filePath);
        if(numbers.length > 0)
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
                logger.log(Level.WARNING, "File is empty {0}", filePath);
                return new String[0];
            }
            else if(textFile.isEmpty())
            {
                logger.log(Level.WARNING, "First line is empty {0}", filePath);
                return new String[0];
            }
            else if(nextLine != null)
            {
                logger.log(Level.WARNING, "File has more than one line {0}", filePath);
                return new String[0];
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
            logger.log(Level.WARNING, "File not found {0}", e.getMessage());
            return new String[0];
        } 
        catch(IOException e) 
        {
            logger.log(Level.WARNING, "IO Exception {0}", e.getMessage());
            return new String[0];
        }
        catch(NumberFormatException e)
        {
            logger.log(Level.WARNING, "Is not a list of numbers {0}", e.getMessage());
            return new String[0];
        }
    }
}

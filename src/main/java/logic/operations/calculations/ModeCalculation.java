package logic.operations.calculations;

import logic.operations.CalculationStrategy;
import logic.StatisticalManager;

public class ModeCalculation implements CalculationStrategy
{
    @Override
    public double doCalculation(StatisticalManager statisticalManager) 
    {
        double mostRepeatedNumber = Double.NaN;
        double previousNumber = Double.NaN;
        int maxCount = 1;
        int currentCount = 1;
        
        for(Double number : statisticalManager.getNumbers())
        {
            if(number == previousNumber)
            {
                currentCount++;
                if(currentCount > maxCount)
                {
                    maxCount = currentCount;
                    mostRepeatedNumber = previousNumber;
                }
            }
            else
            {
                currentCount = 1;
            }

            previousNumber = number;
        }
        return mostRepeatedNumber;
    }
}

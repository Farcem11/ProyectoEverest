package logic.Statistical.operations.calculations;

import logic.Statistical.operations.CalculationStrategy;
import model.database.object.StatisticalDataManager;

public class ModeCalculation implements CalculationStrategy
{
    @Override
    public double doCalculation(StatisticalDataManager statisticalDataManager) 
    {
        double mostRepeatedNumber = Double.NaN;
        double previousNumber = Double.NaN;
        int maxCount = 1;
        int currentCount = 1;
        
        for(Double number : statisticalDataManager.getNumbers())
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

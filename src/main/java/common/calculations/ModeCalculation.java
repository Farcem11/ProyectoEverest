package common.calculations;

import model.StatisticalData;

public class ModeCalculation implements CalculationStrategy
{
    @Override
    public double doCalculation(StatisticalData statisticalDataManager) 
    {
        double mostRepeatedNumber = Double.NaN;
        double previousNumber = Double.NaN;
        int maxCount = 1;
        int currentCount = 1;
        
        for(Double number : statisticalDataManager.getNumbersArray())
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

package everest.common.calculations;

import everest.model.StatisticalData;

public class QuartileThreeCalculation implements CalculationStrategy
{
    @Override
    public double doCalculation(StatisticalData statisticalData) 
    {
        int quartileThreeIndex = (3*(statisticalData.getNumbersArray().length + 1)) / 4;
        return statisticalData.getNumbersArray()[quartileThreeIndex - 1];
    }
}
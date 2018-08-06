package common.calculations;

import model.StatisticalData;

public class CalculationContext 
{
    private final CalculationStrategy strategy;
    
    public CalculationContext(CalculationStrategy strategy)
    {
        this.strategy = strategy;
    }
    
    public double calculate(StatisticalData statisticalData)
    {
        return strategy.doCalculation(statisticalData);
    }    
}

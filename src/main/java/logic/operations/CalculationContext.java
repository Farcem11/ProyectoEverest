package logic.operations;

import logic.StatisticalManager;

public class CalculationContext 
{
    private final CalculationStrategy strategy;
    
    public CalculationContext(CalculationStrategy strategy)
    {
        this.strategy = strategy;
    }
    
    public double calculate(StatisticalManager statisticalManager)
    {
        return strategy.doCalculation(statisticalManager);
    }    
}

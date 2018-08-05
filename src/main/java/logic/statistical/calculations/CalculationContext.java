package logic.statistical.calculations;

import model.object.StatisticalDataManager;

public class CalculationContext 
{
    private final CalculationStrategy strategy;
    
    public CalculationContext(CalculationStrategy strategy)
    {
        this.strategy = strategy;
    }
    
    public double calculate(StatisticalDataManager statisticalManager)
    {
        return strategy.doCalculation(statisticalManager);
    }    
}

package logic;

import logic.Operations.CalculationStrategy;
import logic.Operations.Calculations.*;

public enum StatisticalCalculator 
{
    AVERAGE(new AverageCalculation()),
    MEDIAN(new MedianCalculation()),
    MODE(new ModeCalculation()),
    MIDDLE_RANGE(new MiddleRangeCalculation()),
    MAX(new MaxCalculation()),
    MIN(new MinCalculation()),
    QUARTILE_ONE(new QuartileOneCalculation()),
    QUARTILE_THREE(new QuartileThreeCalculation()),
    VARIANCE(new VarianceCalculation());
    
    StatisticalCalculator(CalculationStrategy strategy)
    {
        this.strategy = strategy;
    }
    
    private final CalculationStrategy strategy;

    /**
     * @param statisticalManager
     * @return the strategy
     */
    public double calculate(StatisticalManager statisticalManager)
    {
        return strategy.doCalculation(statisticalManager);
    }
}

package logic;

import logic.operations.calculations.VarianceCalculation;
import logic.operations.calculations.QuartileThreeCalculation;
import logic.operations.calculations.MaxCalculation;
import logic.operations.calculations.ModeCalculation;
import logic.operations.calculations.StandardDeviationCalculation;
import logic.operations.calculations.QuartileOneCalculation;
import logic.operations.calculations.MidRangeCalculation;
import logic.operations.calculations.MedianCalculation;
import logic.operations.calculations.AverageCalculation;
import logic.operations.calculations.MinCalculation;
import logic.operations.CalculationStrategy;

public enum StatisticalCalculator 
{
    AVERAGE(new AverageCalculation()),
    MEDIAN(new MedianCalculation()),
    MODE(new ModeCalculation()),
    MID_RANGE(new MidRangeCalculation()),
    MAX(new MaxCalculation()),
    MIN(new MinCalculation()),
    QUARTILE_ONE(new QuartileOneCalculation()),
    QUARTILE_THREE(new QuartileThreeCalculation()),
    VARIANCE(new VarianceCalculation()),
    STANDARD_DEVIATION(new StandardDeviationCalculation());
    
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

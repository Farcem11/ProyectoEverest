package everest.common;

import everest.common.calculations.CalculationStrategy;
import everest.model.StatisticalData;

public class StatisticalCalculator 
{
	private StatisticalCalculator() {}

	private static final StatisticalCalculator instance = new StatisticalCalculator();
	
    public synchronized static StatisticalCalculator getInstance()
    {
        return instance;
    }
    
	private final StatisticalCalculatorStrategyFactory statisticalCalculatorStrategyFactory = new StatisticalCalculatorStrategyFactory();

	public double calculate(CalculationType calculationType, StatisticalData statisticalData) 
	{
        CalculationStrategy calculationStrategy = statisticalCalculatorStrategyFactory.getCalculationStrategy(calculationType);
        
        return calculationStrategy.doCalculation(statisticalData);
    }
}

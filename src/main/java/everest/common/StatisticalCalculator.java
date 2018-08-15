package everest.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import everest.common.calculations.CalculationStrategy;
import everest.model.StatisticalData;

@Component
public class StatisticalCalculator 
{
	@Autowired
	private StatisticalCalculatorStrategyFactory statisticalCalculatorStrategyFactory;

	public List<Double> calculate(CalculationTypeEnum calculationTypeEnum, StatisticalData statisticalData) 
	{
        CalculationStrategy calculationStrategy = statisticalCalculatorStrategyFactory.getCalculationStrategy(calculationTypeEnum);
        
        return calculationStrategy.doCalculation(statisticalData);
    }
}
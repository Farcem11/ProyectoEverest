package everest.common;

import java.util.EnumMap;
import org.springframework.stereotype.Component;

import everest.common.calculations.AverageCalculation;
import everest.common.calculations.CalculationStrategy;
import everest.common.calculations.VarianceCalculation;
import everest.common.calculations.QuartileThreeCalculation;
import everest.common.calculations.MaxCalculation;
import everest.common.calculations.ModeCalculation;
import everest.common.calculations.StandardDeviationCalculation;
import everest.common.calculations.QuartileOneCalculation;
import everest.common.calculations.MidRangeCalculation;
import everest.common.calculations.MedianCalculation;
import everest.common.calculations.MinCalculation;

@Component
public class StatisticalCalculatorStrategyFactory
{
    private final EnumMap<CalculationTypeEnum, CalculationStrategy> calculationStrategyMap = new EnumMap<>(CalculationTypeEnum.class);
    
    public StatisticalCalculatorStrategyFactory()
    {
    	calculationStrategyMap.put(CalculationTypeEnum.AVERAGE, new AverageCalculation());
    	calculationStrategyMap.put(CalculationTypeEnum.MEDIAN, new MedianCalculation());
    	calculationStrategyMap.put(CalculationTypeEnum.MODE, new ModeCalculation());
    	calculationStrategyMap.put(CalculationTypeEnum.MID_RANGE, new MidRangeCalculation());
    	calculationStrategyMap.put(CalculationTypeEnum.MAX, new MaxCalculation());
    	calculationStrategyMap.put(CalculationTypeEnum.MIN, new MinCalculation());
    	calculationStrategyMap.put(CalculationTypeEnum.QUARTILE_ONE, new QuartileOneCalculation());
    	calculationStrategyMap.put(CalculationTypeEnum.QUARTILE_THREE, new QuartileThreeCalculation());
    	calculationStrategyMap.put(CalculationTypeEnum.VARIANCE, new VarianceCalculation());
    	calculationStrategyMap.put(CalculationTypeEnum.STANDARD_DEVIATION, new StandardDeviationCalculation());
    }
    
    public CalculationStrategy getCalculationStrategy(CalculationTypeEnum calculationTypeEnum) 
    {
        return calculationStrategyMap.get(calculationTypeEnum);
    }
}

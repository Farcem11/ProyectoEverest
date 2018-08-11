package everest.common;

import everest.common.calculations.AverageCalculation;
import everest.common.calculations.CalculationStrategy;
import everest.common.calculations.VarianceCalculation;
import everest.common.calculations.QuartileThreeCalculation;
import everest.common.calculations.MaxCalculation;
import everest.common.calculations.ModeCalculation;
import everest.common.calculations.NoCalculation;
import everest.common.calculations.StandardDeviationCalculation;
import everest.common.calculations.QuartileOneCalculation;
import everest.common.calculations.MidRangeCalculation;
import everest.common.calculations.MedianCalculation;
import everest.common.calculations.MinCalculation;

public class StatisticalCalculatorStrategyFactory
{
	private final CalculationStrategy averageCalculation = new AverageCalculation();
    private final CalculationStrategy medianCalculation = new MedianCalculation();
    private final CalculationStrategy modeCalculation = new ModeCalculation();
    private final CalculationStrategy midRangeCalculation = new MidRangeCalculation();
    private final CalculationStrategy maxCalculation = new MaxCalculation();
    private final CalculationStrategy minCalculation = new MinCalculation();
    private final CalculationStrategy quartileOneCalculation = new QuartileOneCalculation();
    private final CalculationStrategy quartileThreeCalculation = new QuartileThreeCalculation();
    private final CalculationStrategy varianceCalculation = new VarianceCalculation();
    private final CalculationStrategy standardDeviationCalculation = new StandardDeviationCalculation();
    private final CalculationStrategy noCalculation = new NoCalculation();
    
    public CalculationStrategy getCalculationStrategy(CalculationType calculationType) 
    {
        switch (calculationType) 
        {
            case AVERAGE: 
            	return averageCalculation;
            case MEDIAN: 
            	return medianCalculation;
            case MODE: 
            	return modeCalculation;
            case MID_RANGE:
            	return midRangeCalculation;
            case MAX:
            	return maxCalculation;
            case MIN:
            	return minCalculation;
            case QUARTILE_ONE:
            	return quartileOneCalculation;
            case QUARTILE_THREE:
            	return quartileThreeCalculation;
            case VARIANCE:
            	return varianceCalculation;
            case STANDARD_DEVIATION:
            	return standardDeviationCalculation;
            default:
            	return noCalculation;
        }
    }
}

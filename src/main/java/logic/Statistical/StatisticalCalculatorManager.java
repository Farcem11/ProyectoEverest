package logic.Statistical;

import logic.Statistical.operations.CalculationContext;
import logic.Statistical.operations.calculations.VarianceCalculation;
import logic.Statistical.operations.calculations.QuartileThreeCalculation;
import logic.Statistical.operations.calculations.MaxCalculation;
import logic.Statistical.operations.calculations.ModeCalculation;
import logic.Statistical.operations.calculations.StandardDeviationCalculation;
import logic.Statistical.operations.calculations.QuartileOneCalculation;
import logic.Statistical.operations.calculations.MidRangeCalculation;
import logic.Statistical.operations.calculations.MedianCalculation;
import logic.Statistical.operations.calculations.AverageCalculation;
import logic.Statistical.operations.calculations.MinCalculation;

public class StatisticalCalculatorManager 
{
    private static final StatisticalCalculatorManager instance = new StatisticalCalculatorManager();

    private StatisticalCalculatorManager() {}
    
    public static StatisticalCalculatorManager getInstance()
    {
        return instance;
    }
    
    private final CalculationContext averageCalculator = new CalculationContext(new AverageCalculation());
    private final CalculationContext medianCalculator = new CalculationContext(new MedianCalculation());
    private final CalculationContext modeCalculator = new CalculationContext(new ModeCalculation());
    private final CalculationContext midRangeCalculator = new CalculationContext(new MidRangeCalculation());
    private final CalculationContext maxCalculator = new CalculationContext(new MaxCalculation());
    private final CalculationContext minCalculator = new CalculationContext(new MinCalculation());
    private final CalculationContext quartileOneCalculator = new CalculationContext(new QuartileOneCalculation());
    private final CalculationContext quartileThreeCalculator = new CalculationContext(new QuartileThreeCalculation());
    private final CalculationContext varianceCalculator = new CalculationContext(new VarianceCalculation());
    private final CalculationContext standardDeviationCalculator = new CalculationContext(new StandardDeviationCalculation());

    /**
     * @return the averageCalculator
     */
    public CalculationContext getAverageCalculator() {
        return averageCalculator;
    }

    /**
     * @return the medianCalculator
     */
    public CalculationContext getMedianCalculator() {
        return medianCalculator;
    }

    /**
     * @return the modeCalculator
     */
    public CalculationContext getModeCalculator() {
        return modeCalculator;
    }

    /**
     * @return the midRangeCalculator
     */
    public CalculationContext getMidRangeCalculator() {
        return midRangeCalculator;
    }

    /**
     * @return the maxCalculator
     */
    public CalculationContext getMaxCalculator() {
        return maxCalculator;
    }

    /**
     * @return the minCalculator
     */
    public CalculationContext getMinCalculator() {
        return minCalculator;
    }

    /**
     * @return the quartileOneCalculator
     */
    public CalculationContext getQuartileOneCalculator() {
        return quartileOneCalculator;
    }

    /**
     * @return the quartileThreeCalculator
     */
    public CalculationContext getQuartileThreeCalculator() {
        return quartileThreeCalculator;
    }

    /**
     * @return the varianceCalculator
     */
    public CalculationContext getVarianceCalculator() {
        return varianceCalculator;
    }

    /**
     * @return the standardDeviationCalculator
     */
    public CalculationContext getStandardDeviationCalculator() {
        return standardDeviationCalculator;
    }
}

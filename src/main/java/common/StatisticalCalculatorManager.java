package common;

import common.calculations.CalculationContext;
import common.calculations.VarianceCalculation;
import common.calculations.QuartileThreeCalculation;
import common.calculations.MaxCalculation;
import common.calculations.ModeCalculation;
import common.calculations.StandardDeviationCalculation;
import common.calculations.QuartileOneCalculation;
import common.calculations.MidRangeCalculation;
import common.calculations.MedianCalculation;
import common.calculations.AverageCalculation;
import common.calculations.MinCalculation;
import model.StatisticalData;

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

    public double getAverageCalculation(StatisticalData statisticalData) {
        return averageCalculator.calculate(statisticalData);
    }

    public double getMedianCalculation(StatisticalData statisticalData) {
        return medianCalculator.calculate(statisticalData);
    }

    public double getModeCalculation(StatisticalData statisticalData) {
        return modeCalculator.calculate(statisticalData);
    }

    public double getMidRangeCalculation(StatisticalData statisticalData) {
        return midRangeCalculator.calculate(statisticalData);
    }

    public double getMaxCalculation(StatisticalData statisticalData) {
        return maxCalculator.calculate(statisticalData);
    }

    public double getMinCalculation(StatisticalData statisticalData) {
        return minCalculator.calculate(statisticalData);
    }

    public double getQuartileOneCalculation(StatisticalData statisticalData) {
        return quartileOneCalculator.calculate(statisticalData);
    }

    public double getQuartileThreeCalculation(StatisticalData statisticalData) {
        return quartileThreeCalculator.calculate(statisticalData);
    }

    public double getVarianceCalculation(StatisticalData statisticalData) {
        return varianceCalculator.calculate(statisticalData);
    }

    public double getStandardDeviationCalculation(StatisticalData statisticalData) {
        return standardDeviationCalculator.calculate(statisticalData);
    }
}

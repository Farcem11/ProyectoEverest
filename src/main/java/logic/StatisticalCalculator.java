package logic;

import logic.operations.CalculationContext;
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

public abstract class StatisticalCalculator 
{
    public static final CalculationContext AVERAGE = new CalculationContext(new AverageCalculation());
    public static final CalculationContext MEDIAN = new CalculationContext(new MedianCalculation());
    public static final CalculationContext MODE = new CalculationContext(new ModeCalculation());
    public static final CalculationContext MID_RANGE = new CalculationContext(new MidRangeCalculation());
    public static final CalculationContext MAX = new CalculationContext(new MaxCalculation());
    public static final CalculationContext MIN = new CalculationContext(new MinCalculation());
    public static final CalculationContext QUARTILE_ONE = new CalculationContext(new QuartileOneCalculation());
    public static final CalculationContext QUARTILE_THREE = new CalculationContext(new QuartileThreeCalculation());
    public static final CalculationContext VARIANCE = new CalculationContext(new VarianceCalculation());
    public static final CalculationContext STANDARD_DEVIATION = new CalculationContext(new StandardDeviationCalculation());
}

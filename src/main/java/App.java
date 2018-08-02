
import logic.StatisticalCalculator;
import logic.StatisticalManager;

public class App 
{
    public static void main(String[] args) 
    {
        StatisticalManager statisticalManager = new StatisticalManager("C:\\Users\\Fabian\\Documents\\Avantica\\Everest\\ProyectoEverest\\numbers.txt");
        double num = StatisticalCalculator.AVERAGE.calculate(statisticalManager);
        num = StatisticalCalculator.MEDIAN.calculate(statisticalManager);
         num = StatisticalCalculator.MIDDLE_RANGE.calculate(statisticalManager);
         num = StatisticalCalculator.MODE.calculate(statisticalManager);
         num = StatisticalCalculator.QUARTILE_ONE.calculate(statisticalManager);
         num = StatisticalCalculator.QUARTILE_THREE.calculate(statisticalManager);
         num = StatisticalCalculator.MAX.calculate(statisticalManager);
         num = StatisticalCalculator.MIN.calculate(statisticalManager);
         num = StatisticalCalculator.VARIANCE.calculate(statisticalManager);
         num = StatisticalCalculator.STANDARD_DEVIATION.calculate(statisticalManager);
    }
}

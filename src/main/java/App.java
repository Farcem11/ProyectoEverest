
import logic.StatisticalCalculator;
import logic.StatisticalManager;

public class App 
{
    public static void main(String[] args) 
    {
        StatisticalManager manager = new StatisticalManager("C:\\Users\\Fabian\\Documents\\Avantica\\Everest\\ProyectoEverest\\numbers.txt");
        
        StatisticalCalculator.MODE.calculate(manager); 

    }
}

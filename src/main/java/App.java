import logic.FileValidator;
import logic.StatisticalManager;

public class App 
{
    public static void main(String[] args) 
    {
        StatisticalManager manager = FileValidator.newStatisticalManager("C:\\Users\\Fabian\\Documents\\Avantica\\Everest\\ProyectoEverest\\files\\Numbers.txt");
    }
}

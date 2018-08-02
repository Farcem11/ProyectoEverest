package logic.Operations;

import java.util.HashMap;
import java.util.Map;
import logic.StatisticalManager;

public class ModeCalculation implements CalculationStrategy
{
    HashMap<Double, Integer> map = new HashMap<>();
    @Override
    public double doCalculation(StatisticalManager statisticalManager) 
    {
        map.clear();
        
        for(Double number : statisticalManager.getNumbers())
        {
            if(map.containsKey(number))
            {
                map.put(number, map.get(number) + 1);
            }
            else
            {
                map.put(number, 1);
            }
        }
        
        double mostRepeatedNumber = 0;
        int highestNumber = 0;
        
        for(Map.Entry<Double, Integer> entry : map.entrySet())
        {
            if(entry.getValue() > highestNumber)
            {
                highestNumber = entry.getValue();
                mostRepeatedNumber = entry.getKey();
            }
        }
        
        return mostRepeatedNumber;
    }
}

package everest.common.calculations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import everest.model.StatisticalData;

public class ModeCalculation implements CalculationStrategy
{
    @Override
    public List<Double> doCalculation(StatisticalData statisticalData) 
    {
    	List<Double> results = new ArrayList<>();
    	Map<Double, Integer> repeatedNumberCountsMap = new HashMap<>();
    	
        int maxCount = 1;
        
        for(Double number : statisticalData.getNumbersArray())
        {
    		if(repeatedNumberCountsMap.containsKey(number))
    		{
    			int count = repeatedNumberCountsMap.get(number) + 1;
    			repeatedNumberCountsMap.put(number, count);
    			if(count > maxCount)
    			{
    				maxCount = count;
    			}
    		}
    		else
    		{
    			repeatedNumberCountsMap.put(number, 1);
    		}
        }
        
        if(maxCount == 1)
        {
        	return results;
        }
        
        for(Map.Entry<Double, Integer> entry : repeatedNumberCountsMap.entrySet())
        {
        	if(entry.getValue() == maxCount)
        	{
        		results.add(entry.getKey());
        	}
        }
        
        return results;
    }
}

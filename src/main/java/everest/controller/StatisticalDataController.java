package everest.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import everest.model.StatisticalData;
import everest.service.StatisticalDataService;
import everest.common.CalculationType;
import everest.common.StatisticalCalculator;
import everest.common.StatisticalDataManager;

import java.sql.SQLException;

@RestController
@RequestMapping("StatisticalData")
public class StatisticalDataController 
{
    @Autowired
    private StatisticalDataService statisticalDataService;
	
    private Map<Long, StatisticalData> statisticalDataMap;

    @PostConstruct
    private void initializeMap()
    {
        statisticalDataMap = statisticalDataService.getStatisticalDataMap();
    }
	
    @GetMapping("/get")
    public Collection<StatisticalData> getStatisticalData()
    {
    	return statisticalDataMap.values();
    }
    
    @PostMapping("/save")
    public void saveStatisticalData(@RequestBody Map<String, String> request) throws IOException, SQLException
    {
        String fileName = request.get("fileName");
        String fileContent = request.get("fileContent");
        StatisticalData statisticalData = StatisticalDataManager.getInstance().validateAndParse(fileName, fileContent);
        Long uniqueDatabaseId = statisticalDataService.saveStatisticalData(statisticalData);
        statisticalData.setId(uniqueDatabaseId);
        statisticalDataMap.put(uniqueDatabaseId, statisticalData); // Add new
    }
    
    @PostMapping("/update")
    public void updateStatisticalData(@RequestBody Map<String, String> request) throws IOException, SQLException
    {
        Long id = Long.parseLong(request.get("id"));
        String newName = request.get("newName");
        String newNumbers = request.get("newNumbers");
        StatisticalData newStatisticalData = StatisticalDataManager.getInstance().validateAndParse(newName, newNumbers);
        newStatisticalData.setId(id);
        statisticalDataService.updateStatisticalData(newStatisticalData);
        statisticalDataMap.put(id, newStatisticalData); //Overwrite               
    }
    
    @PostMapping("/delete")
    public void deleteStatisticalData(@RequestBody Map<String, String> request) throws SQLException
    {
        Long id = Long.parseLong(request.get("id"));
        statisticalDataService.deleteStatisticalData(id);
        statisticalDataMap.remove(id);           
    }
    
    @PostMapping("/calculate")
    public Map<String, Double> getStatisticalDataCalculations(@RequestBody Map<String, String> request) throws SQLException
    {
    	Long id = Long.parseLong(request.get("id"));
    	Map<String, Double> calculationsMap = new HashMap<>();
    	StatisticalData statisticalData = statisticalDataMap.get(id);
    	
    	calculationsMap.put(
    			CalculationType.AVERAGE.name(), 
    			StatisticalCalculator.getInstance().calculate(CalculationType.AVERAGE, statisticalData));
    	
    	calculationsMap.put(
    			CalculationType.MEDIAN.name(), 
    			StatisticalCalculator.getInstance().calculate(CalculationType.MEDIAN, statisticalData));
    	
    	calculationsMap.put(
    			CalculationType.MODE.name(), 
    			StatisticalCalculator.getInstance().calculate(CalculationType.MODE, statisticalData));

    	calculationsMap.put(
    			CalculationType.MID_RANGE.name(), 
    			StatisticalCalculator.getInstance().calculate(CalculationType.MID_RANGE, statisticalData));
    	
    	calculationsMap.put(
    			CalculationType.MAX.name(), 
    			StatisticalCalculator.getInstance().calculate(CalculationType.MAX, statisticalData));

    	calculationsMap.put(
    			CalculationType.MIN.name(), 
    			StatisticalCalculator.getInstance().calculate(CalculationType.MIN, statisticalData));

    	calculationsMap.put(
    			CalculationType.QUARTILE_ONE.name(), 
    			StatisticalCalculator.getInstance().calculate(CalculationType.QUARTILE_ONE, statisticalData));

    	calculationsMap.put(
    			CalculationType.QUARTILE_THREE.name(), 
    			StatisticalCalculator.getInstance().calculate(CalculationType.QUARTILE_THREE, statisticalData));

    	calculationsMap.put(
    			CalculationType.VARIANCE.name(), 
    			StatisticalCalculator.getInstance().calculate(CalculationType.VARIANCE, statisticalData));

    	calculationsMap.put(
    			CalculationType.STANDARD_DEVIATION.name(), 
    			StatisticalCalculator.getInstance().calculate(CalculationType.STANDARD_DEVIATION, statisticalData));

        return calculationsMap; 
    }
}

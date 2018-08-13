package everest.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
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
import everest.common.StatisticalDataManager;

import java.sql.SQLException;

@RestController
@RequestMapping("StatisticalData")
public class StatisticalDataController 
{
    @Autowired
    private StatisticalDataService statisticalDataService;
    
    @Autowired
	StatisticalDataManager statisticalDataManager;
	
    private Map<Long, StatisticalData> statisticalDataMap;

    @PostConstruct
    private void initializeMap() throws SQLException
    {
        statisticalDataMap = statisticalDataService.getStatisticalDataMap();
    }
	
    @GetMapping("/get")
    public Collection<StatisticalData> getStatisticalData()
    {
    	return statisticalDataMap.values();
    }
    
    @PostMapping("/save")
    public Long saveStatisticalData(@RequestBody Map<String, String> request) throws IOException, SQLException
    {
        String fileName = request.get("fileName");
        String fileContent = request.get("fileContent");
        StatisticalData statisticalData = statisticalDataManager.validateAndParse(fileName, fileContent);
        Long uniqueDatabaseId = statisticalDataService.saveStatisticalData(statisticalData);
        statisticalData.setId(uniqueDatabaseId);
        statisticalDataMap.put(uniqueDatabaseId, statisticalData); // Add new
        return uniqueDatabaseId;
    }
    
    @PostMapping("/update")
    public Long updateStatisticalData(@RequestBody Map<String, String> request) throws IOException, SQLException
    {
        Long id = Long.parseLong(request.get("id"));
        String newName = request.get("newName");
        String newNumbers = request.get("newNumbers");
        StatisticalData newStatisticalData = statisticalDataManager.validateAndParse(newName, newNumbers);
        newStatisticalData.setId(id);
        statisticalDataService.updateStatisticalData(newStatisticalData);
        statisticalDataMap.put(id, newStatisticalData); //Overwrite
        return id;
    }
    
    @PostMapping("/delete")
    public void deleteStatisticalData(@RequestBody Map<String, String> request) throws SQLException
    {
        Long id = Long.parseLong(request.get("id"));
        statisticalDataService.deleteStatisticalData(id);
        statisticalDataMap.remove(id);           
    }
    
    @PostMapping("/calculate")
    public Map<String, List<Double>> getStatisticalDataCalculations(@RequestBody Map<String, String> request)
    {
    	Long id = Long.parseLong(request.get("id"));
    	StatisticalData statisticalData = statisticalDataMap.get(id);
    	return statisticalDataManager.getStatisticalCalculations(statisticalData);
    }
}

package controller;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.StatisticalData;
import service.StatisticalDataService;
import common.StatisticalDataManager;

import java.sql.SQLException;

@RestController
@RequestMapping("StatisticalData")
public class StatisticalDataController 
{
    private StatisticalDataService StatisticalDataManagerService = new StatisticalDataService();
    
    @GetMapping("/get")
    public Collection<StatisticalData> getStatisticalData()
    {
    	return StatisticalDataManager.statisticalDataMap.values();
    }
    
    @PostMapping("/save")
    public void saveStatisticalData(@RequestBody Map<String, String> request) throws IOException, SQLException
    {
        String fileName = request.get("fileName");
        String fileContent = request.get("fileContent");
        StatisticalData statisticalData = StatisticalDataManager.getInstance().validateAndParse(fileName, fileContent);
        Long uniqueDatabaseId = StatisticalDataManagerService.saveStatisticalData(statisticalData);
        statisticalData.setId(uniqueDatabaseId);
        StatisticalDataManager.statisticalDataMap.put(uniqueDatabaseId, statisticalData); // Add new
    }
    
    @PostMapping("/update")
    public void updateStatisticalData(@RequestBody Map<String, String> request) throws IOException, SQLException
    {
        Long id = Long.parseLong(request.get("id"));
        String newName = request.get("newName");
        String newNumbers = request.get("newNumbers");
        StatisticalData newStatisticalDataManager = StatisticalDataManager.getInstance().validateAndParse(newName, newNumbers);
        newStatisticalDataManager.setId(id);
        StatisticalDataManagerService.updateStatisticalData(newStatisticalDataManager);
        StatisticalDataManager.statisticalDataMap.put(id, newStatisticalDataManager); //Overwrite               
    }
    
    @PostMapping("/delete")
    public void deleteStatisticalData(@RequestBody Map<String, String> request) throws SQLException
    {
        Long id = Long.parseLong(request.get("id"));
        StatisticalDataManagerService.deleteStatisticalData(id);
        StatisticalDataManager.statisticalDataMap.remove(id);           
    }
}

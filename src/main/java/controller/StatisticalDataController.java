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
import common.StatisticalFileManager;
import java.sql.SQLException;

@RestController
@RequestMapping("StatisticalData")
public class StatisticalDataController 
{
    private final StatisticalDataService statisticalDataManagerService = new StatisticalDataService();
    
    @GetMapping("/get")
    public Collection<StatisticalData> getStatisticalData()
    {
    	return StatisticalDataManager.getInstance().getStatisticalDataMap().values();
    }
    
    @PostMapping("/save")
    public void saveStatisticalData(@RequestBody Map<String, String> request) throws IOException, SQLException
    {
        String fileName = request.get("fileName");
        String fileContent = request.get("fileContent");
        StatisticalData statisticalDataManager = StatisticalDataManager.getInstance().validateAndParse(fileName, fileContent);
        Long uniqueDatabaseId = statisticalDataManagerService.saveStatisticalData(statisticalDataManager);
        statisticalDataManager.setId(uniqueDatabaseId);
        StatisticalDataManager.getInstance().getStatisticalDataMap().put(uniqueDatabaseId, statisticalDataManager); // Add new
    }
    
    @PostMapping("/update")
    public void updateStatisticalData(@RequestBody Map<String, String> request) throws IOException, SQLException
    {
        Long id = Long.parseLong(request.get("id"));
        String newName = request.get("newName");
        String newNumbers = request.get("newNumbers");
        StatisticalData newStatisticalDataManager = StatisticalDataManager.getInstance().validateAndParse(newName, newNumbers);
        newStatisticalDataManager.setId(id);
        statisticalDataManagerService.updateStatisticalData(newStatisticalDataManager);
        StatisticalDataManager.getInstance().getStatisticalDataMap().put(id, newStatisticalDataManager); //Overwrite               
    }
    
    @PostMapping("/delete")
    public void deleteStatisticalData(@RequestBody Map<String, String> request) throws SQLException
    {
        Long id = Long.parseLong(request.get("id"));
        statisticalDataManagerService.deleteStatisticalData(id);
        StatisticalDataManager.getInstance().getStatisticalDataMap().remove(id);           
    }
}

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
import java.io.File;
import java.sql.SQLException;

@RestController
@RequestMapping("StatisticalData")
public class StatisticalDataController 
{
    private final StatisticalDataService statisticalDataManagerService = new StatisticalDataService();
    
    @GetMapping("/get")
    public Collection<StatisticalData> getStatisticalData()
    {
    	return StatisticalDataManager.getInstance().statisticalDataMap.values();
    }
    
    @PostMapping("/save")
    public void saveStatisticalData(@RequestBody Map<String, String> request) throws IOException, SQLException
    {
        File file = new File(request.get("filePath"));
        StatisticalData statisticalDataManager = StatisticalFileManager.getInstance().parseFileToStatisticalData(file);
        Long uniqueDatabaseId = statisticalDataManagerService.saveStatisticalData(statisticalDataManager);
        statisticalDataManager.setId(uniqueDatabaseId);
        StatisticalDataManager.getInstance().statisticalDataMap.put(uniqueDatabaseId, statisticalDataManager);
    }
    
    @PostMapping("/update")
    public void updateStatisticalData(@RequestBody Map<String, String> request) throws IOException, SQLException
    {
        Long id = Long.parseLong(request.get("id"));
        String newFilePath = request.get("newFilePath");
        String newFileContent = request.get("newFileContent");
        File file = StatisticalFileManager.getInstance().updateFile(newFilePath, newFileContent);
        StatisticalData newStatisticalDataManager = StatisticalFileManager.getInstance().parseFileToStatisticalData(file);
        newStatisticalDataManager.setId(id);
        statisticalDataManagerService.updateStatisticalData(newStatisticalDataManager);
        StatisticalDataManager.getInstance().statisticalDataMap.put(id, newStatisticalDataManager);                
    }
    
    @PostMapping("/delete")
    public void deleteStatisticalData(@RequestBody Map<String, String> request) throws SQLException
    {
        Long id = Long.parseLong(request.get("id"));
        statisticalDataManagerService.deleteStatisticalData(id);
        StatisticalDataManager.getInstance().statisticalDataMap.remove(id);           
    }
}

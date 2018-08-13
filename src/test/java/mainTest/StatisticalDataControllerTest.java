package mainTest;

import everest.Application;
import everest.common.StatisticalDataManager;
import everest.dao.StatisticalDataDao;
import everest.model.StatisticalData;
import everest.service.StatisticalDataService;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;

@SpringJUnitConfig
@AutoConfigureMockMvc
@SpringBootTest(classes = Application.class)
public class StatisticalDataControllerTest
{   
    @Autowired
    private MockMvc mvc;
    
    @Autowired
    private StatisticalDataService statisticalDataService;
    
    @Autowired
    private StatisticalDataDao statisticalDataDao;
    
    @Autowired
	private StatisticalDataManager statisticalDataManager;
    
    @Test
    public void getStatisticalDataRestTest() throws Exception
    {
        mvc.perform(MockMvcRequestBuilders.get("/StatisticalData/get"))
        .andExpect(status().isOk());
    }

    @Test
    public void saveStatisticalDataRestTest() throws Exception 
    {
    	Map<String, String> request = new HashMap<>();
        request.put("fileName", "NewFileName");
        request.put("fileContent", "1,2,3,4,5");
        
        String json = new ObjectMapper().writeValueAsString(request);
        
        MvcResult result = mvc.perform(post("/StatisticalData/save")
        .contentType(MediaType.APPLICATION_JSON)
        .content(json))
        .andExpect(status().isOk())
        .andReturn();
        
        Long id = Long.parseLong(result.getResponse().getContentAsString());
        statisticalDataService.deleteStatisticalData(id);
    }
    
    @Test
    public void updateStatisticalDataRestTest() throws Exception 
    {
    	StatisticalData savedStatisticalData = statisticalDataManager.validateAndParse("", "1,2,3,4,5");
        Long lastInsertedId = statisticalDataService.saveStatisticalData(savedStatisticalData);
        
    	Map<String, String> request = new HashMap<>();
        request.put("newName", "NewFileName");
        request.put("newNumbers", "5,6,7,8,9");
        request.put("id", Long.toString(lastInsertedId));
        
        String json = new ObjectMapper().writeValueAsString(request);
        
        mvc.perform(post("/StatisticalData/update")
        .contentType(MediaType.APPLICATION_JSON)
        .content(json))
        .andExpect(status().isOk());
        
        statisticalDataService.deleteStatisticalData(lastInsertedId);
    }
    
    @Test
    public void deleteStatisticalDataRestTest() throws Exception 
    {
    	StatisticalData savedStatisticalData = statisticalDataManager.validateAndParse("", "1,2,3,4,5");
        Long lastInsertedId = statisticalDataService.saveStatisticalData(savedStatisticalData);
        
    	Map<String, String> request = new HashMap<>();
        request.put("id", Long.toString(lastInsertedId));
        
        String json = new ObjectMapper().writeValueAsString(request);
        
        mvc.perform(post("/StatisticalData/delete")
        .contentType(MediaType.APPLICATION_JSON)
        .content(json))
        .andExpect(status().isOk());
    }
    
    @Test
    public void calculateStatisticalDataRestTest() throws Exception 
    {
    	StatisticalData statisticalDataInDatabase = statisticalDataDao.get().get(0);
        
    	Map<String, String> request = new HashMap<>();
        request.put("id", Long.toString(statisticalDataInDatabase.getId()));
        
        String json = new ObjectMapper().writeValueAsString(request);
        
        mvc.perform(post("/StatisticalData/calculate")
        .contentType(MediaType.APPLICATION_JSON)
        .content(json))
        .andExpect(status().isOk());
    }
}
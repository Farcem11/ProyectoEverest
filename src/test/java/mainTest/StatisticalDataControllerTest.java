package mainTest;

import everest.Application;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
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
    
    @Test
    public void getStatisticalDataTest() throws Exception 
    {
        mvc.perform(MockMvcRequestBuilders.get("/StatisticalData/get"))
        .andExpect(status().isOk());
    }
    
    @Test
    public void saveStatisticalDataTest() throws Exception 
    {
    	Map<String, String> request = new HashMap<>();
        request.put("fileName", "NewFileName");
        request.put("fileContent", "1,2,3,4,5");
        
        String json = new ObjectMapper().writeValueAsString(request);
        
        mvc.perform(post("/StatisticalData/save")
        .contentType(MediaType.APPLICATION_JSON)
        .content(json))
        .andExpect(status().isOk());
    }
}

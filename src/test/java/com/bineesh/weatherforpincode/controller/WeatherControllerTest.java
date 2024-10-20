package com.bineesh.weatherforpincode.controller;


import com.bineesh.weatherforpincode.entity.WeatherDetails;
import com.bineesh.weatherforpincode.service.WeatherInfoService;
import org.junit.jupiter.api.BeforeEach;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.Date;

@WebMvcTest(controllers = {WeatherPincodeController.class})
public class WeatherControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    WeatherInfoService weatherInfoService;

    @InjectMocks
    WeatherControllerTest weatherControllerTest;

    WeatherDetails weatherDetails;

    @BeforeEach
    public void init(){
        weatherDetails = new WeatherDetails(
                1261470, "Nagercoil", 8.3155, 77.2069,
                "Clouds", "scattered clouds", 302.05,
                308.26, 302.05, 302.05, 1010, 83,
                1010, 1008, 0.0, "IN", "629151"
        );
        when(weatherInfoService.getWeatherInfo(any(String.class),any(Date.class)))
                .thenReturn(weatherDetails);
    }

    @Test
    public void testGetWeatherInfo() throws Exception {
        System.out.println(weatherDetails);
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/weather-info").param("pincode","629151").param("for_date","21/10/2024")
                        .accept(MediaType.APPLICATION_JSON)
                )
                .andDo(res -> System.out.println(res.getResponse().getContentLength()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.pincode").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.pincode").value("629151"));

    }

}

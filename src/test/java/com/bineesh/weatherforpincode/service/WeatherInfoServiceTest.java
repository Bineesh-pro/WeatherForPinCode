package com.bineesh.weatherforpincode.service;

import com.bineesh.weatherforpincode.entity.WeatherDetails;
import com.bineesh.weatherforpincode.repo.WeatherRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.Date;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class WeatherInfoServiceTest {

    @Autowired
    WeatherInfoService weatherInfoService;

    @MockBean
    WeatherRepo weatherRepo;

    WeatherDetails weatherDetails;


    @BeforeEach
    public void init(){
        weatherDetails = new WeatherDetails(
                1261470, "Nagercoil", 8.3155, 77.2069,
                "Clouds", "scattered clouds", 302.05,
                308.26, 302.05, 302.05, 1010, 83,
                1010, 1008, 0.0, "IN", "629151"
        );
        when(weatherRepo.findByPincode("629151"))
                .thenReturn(weatherDetails);
        when(weatherRepo.existsByPincode(any(String.class)))
                .thenReturn(true);
    }

    @Test
    public void getWeatherInfoTest(){
       WeatherDetails weatherDetails = weatherInfoService.getWeatherInfo("629151",new Date());
        Assertions.assertNotNull(weatherDetails);
        Assertions.assertEquals("629151",weatherDetails.getPincode());
    }
}

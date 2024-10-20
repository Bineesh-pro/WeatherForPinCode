package com.bineesh.weatherforpincode.service;

import com.bineesh.weatherforpincode.dto.WeatherInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class ApiServiceTest {

    @Autowired
    ApiService apiService;

    @Test
    public void fetchWeatherByPin(){
        WeatherInfo weatherInfo1 = apiService.fetchWeatherByPin("629151");
        Assertions.assertNotNull(weatherInfo1);
        Assertions.assertThrows(Exception.class,() -> {
            apiService.fetchWeatherByPin("123009");
        });
    }
}

package com.bineesh.weatherforpincode;

import com.bineesh.weatherforpincode.entity.WeatherDetails;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class WeatherForPinCodeApplicationTests {


    @Test
    void testGetWeatherInfo() {
        RestTemplate restTemplate = new RestTemplate();
        Map<String,String> params = new HashMap<>();
        params.put("pincode","629151");
        params.put("for_date","21/10/2024");
        WeatherDetails weatherDetails = restTemplate.getForObject("http://localhost:8080/weather-info?pincode={pincode}&for_date={for_date}", WeatherDetails.class,params);
        Assertions.assertNotNull(weatherDetails);
        Assertions.assertEquals("629151",weatherDetails.getPincode());
    }

}

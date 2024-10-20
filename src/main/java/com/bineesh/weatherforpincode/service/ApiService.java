package com.bineesh.weatherforpincode.service;


import com.bineesh.weatherforpincode.dto.WeatherInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class ApiService {

    @Value("${api.open-weather.key}")
    private String openWeatherKey;

    @Value("${api.open-weather.url}")
    private String openWeatherApiUrl;


    public WeatherInfo fetchWeatherByLatLon(double lat,double lon){
        RestTemplate restTemplate = new RestTemplate();
        Map<String,String> reqs = new HashMap<>();
        reqs.put("lat",String.valueOf(lat));
        reqs.put("lon",String.valueOf(lon));
        reqs.put("appid",openWeatherKey);
        restTemplate.setDefaultUriVariables(reqs);
        return restTemplate.getForObject(openWeatherApiUrl+"?lat={lat}&lon={lon}&appid={appid}", WeatherInfo.class,reqs);
    }

    public WeatherInfo fetchWeatherByPin(String pin){
        System.out.println("inside third party . .");
        RestTemplate restTemplate = new RestTemplate();
        Map<String,String> params = new HashMap<>();
        params.put("q",pin);
        params.put("appid",openWeatherKey);
        restTemplate.setDefaultUriVariables(params);
        return restTemplate.getForObject(openWeatherApiUrl+"?q={q}&appid={appid}", WeatherInfo.class);
    }

}

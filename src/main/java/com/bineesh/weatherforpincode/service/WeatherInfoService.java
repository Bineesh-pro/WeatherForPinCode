package com.bineesh.weatherforpincode.service;

import com.bineesh.weatherforpincode.dto.WeatherInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class WeatherInfoService {

    @Autowired
    ApiService apiService;

    public WeatherInfo getWeatherInfo(String pincode, Date date){
        return apiService.fetchWeatherByPin(pincode);
    }
}

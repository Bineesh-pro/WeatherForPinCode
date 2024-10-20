package com.bineesh.weatherforpincode.service;

import com.bineesh.weatherforpincode.WeatherRepo;
import com.bineesh.weatherforpincode.dto.WeatherInfo;
import com.bineesh.weatherforpincode.entity.WeatherDetails;
import com.bineesh.weatherforpincode.utils.WeatherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class WeatherInfoService {

    @Autowired
    ApiService apiService;

    @Autowired
    WeatherRepo weatherRepo;

    public WeatherDetails getWeatherInfo(String pincode, Date date){
        if(weatherRepo.existsByPincode(pincode)){
            return weatherRepo.findByPincode(pincode);
        }
        WeatherInfo weatherInfo =  apiService.fetchWeatherByPin(pincode);
        WeatherDetails weather =  WeatherMapper.mapToWeather(weatherInfo);
        weather.setPincode(pincode);
        return weatherRepo.save(weather);
    }
}

package com.bineesh.weatherforpincode.controller;


import com.bineesh.weatherforpincode.dto.WeatherInfo;
import com.bineesh.weatherforpincode.service.WeatherInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;

@RestController
public class WeatherPincodeController {

    @Autowired
    WeatherInfoService weatherInfoService;


    @GetMapping("weather-info")
    public ResponseEntity<WeatherInfo> getWeatherInfo(
            @RequestParam String pincode,
            @RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy") Date for_date
   ){
        return ResponseEntity.ok(weatherInfoService.getWeatherInfo(pincode,for_date));
    }
}

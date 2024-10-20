package com.bineesh.weatherforpincode.utils;

import com.bineesh.weatherforpincode.dto.Weather;
import com.bineesh.weatherforpincode.dto.WeatherInfo;
import com.bineesh.weatherforpincode.entity.WeatherDetails;

public class WeatherMapper {

    public static WeatherDetails mapToWeather(WeatherInfo weatherInfo){
        WeatherDetails weather = new WeatherDetails();
        Weather weatherInf = weatherInfo.getWeather().get(0);

        weather.setWeatherId(weatherInfo.getId());
        weather.setWeatherDes(weatherInf.getDescription());
        weather.setWeatherMain(weatherInf.getMain());
        weather.setLat(weatherInfo.getCoord().getLat());
        weather.setLon(weatherInfo.getCoord().getLon());

        weather.setTemp(weatherInfo.getMain().getTemp());
        weather.setFeels_like(weatherInfo.getMain().getFeels_like());
        weather.setTemp_min(weatherInfo.getMain().getTemp_min());
        weather.setTemp_max(weatherInfo.getMain().getTemp_max());
        weather.setPressure(weatherInfo.getMain().getPressure());
        weather.setHumidity(weatherInfo.getMain().getHumidity());
        weather.setSea_level(weatherInfo.getMain().getSea_level());
        weather.setGrnd_level(weatherInfo.getMain().getGrnd_level());

        weather.setLocation_name(weatherInfo.getName());
        weather.setCountry(weatherInfo.getSys().getCountry());

        return weather;

    }
}

package com.bineesh.weatherforpincode.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class WeatherDetails {

    @Id
    int weatherId;

    String location_name;
    double lat;
    double lon;
    String weatherMain;
    String weatherDes;
    double temp;
    double feels_like;
    double temp_min;
    double temp_max;
    int pressure;
    int humidity;
    int sea_level;
    int grnd_level;
    double wind_speed;
    String country;
    String pincode;

}

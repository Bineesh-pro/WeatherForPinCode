package com.bineesh.weatherforpincode.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Weather {
    public int id;
    public String main;
    public String description;
    public String icon;
}

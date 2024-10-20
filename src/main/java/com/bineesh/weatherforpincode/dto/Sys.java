package com.bineesh.weatherforpincode.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Sys {
    public String country;
    public int sunrise;
    public int sunset;
}

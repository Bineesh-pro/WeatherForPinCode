package com.bineesh.weatherforpincode.repo;

import com.bineesh.weatherforpincode.entity.WeatherDetails;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class WeatherRepoTest {

    @Autowired
    WeatherRepo weatherRepo;

    WeatherDetails weatherDetails;

    @BeforeEach
    public void init(){
        weatherDetails = new WeatherDetails(
                1261470, "Nagercoil", 8.3155, 77.2069,
                "Clouds", "scattered clouds", 302.05,
                308.26, 302.05, 302.05, 1010, 83,
                1010, 1008, 0.0, "IN", "629156"
        );
        weatherRepo.save(weatherDetails);
    }

    @Test
    public void testIsAvailableMethod(){
        boolean b1 = weatherRepo.existsByPincode("629156");
        boolean b2 = weatherRepo.existsByPincode("234876");
        Assertions.assertTrue(b1);
        Assertions.assertFalse(b2);
    }

    @Test
    public void testFindByPincode(){
        WeatherDetails currentWeather1 = weatherRepo.findByPincode("629156");
        WeatherDetails currentWeather2 = weatherRepo.findByPincode("123908");
        Assertions.assertNotNull(currentWeather1);
        Assertions.assertNull(currentWeather2);
    }
}

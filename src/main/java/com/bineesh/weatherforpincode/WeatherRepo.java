package com.bineesh.weatherforpincode;

import com.bineesh.weatherforpincode.entity.WeatherDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepo extends JpaRepository<WeatherDetails,Integer> {
    boolean existsByPincode(String pincode);
    WeatherDetails findByPincode(String pincode);
}

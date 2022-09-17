package com.kasperxms.kasperweather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class WeatherController {
    @Autowired
    private CurrentWeatherService cws;
    @GetMapping(value = "/getRegionalTemp")
    public List<RegionalTemperature> getAllRegionTemp(){
        return cws.getAllCurrentRegionTemp();
    }

    @GetMapping(value = "/getCurrentWeather")
    public LatestWeather getCurrentWeather(){
        return cws.getCurrentWeather();
    }
}

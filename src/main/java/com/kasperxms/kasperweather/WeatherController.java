package com.kasperxms.kasperweather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WeatherController {
    @Autowired
    private CurrentWeatherService cws;
    @GetMapping(value = "/getRegionalTemp")
    public List<RegionalTemperature> getAllRegionTemp(){
        List<RegionalTemperature> info = cws.getAllRegionTemp();
        return info;
    }

    @GetMapping(value = "/getCurrentWeather")
    public LatestWeather getCurrentWeather(){
        LatestWeather lw = cws.getCurrentWeather();
        return lw;
    }
}

package com.kasperxms.kasperweather;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class WeatherController {
    @Autowired
    private CurrentWeatherService cws;

    @GetMapping(value = "/getRegionalTemp")
    public List<RegionalTemperature> getAllRegionTemp() {
        return cws.getAllCurrentRegionTemp();
    }

    @GetMapping(value = "/getCurrentWeather")
    public LatestWeather getCurrentWeather() {
        return cws.getCurrentWeather();
    }

    @GetMapping(value = "/getTop5HotRegion")
    public List<RegionalTemperature> getTop5HotRegion() {
        return cws.getTop5HotRegion();
    }

    @GetMapping(value = "/getPastAvg24hTemp")
    public List<HourValue> getPastAvg24hTemp() {
        return cws.getPastAvg24hTemp();
    }

    @GetMapping(value = "/getPastAvg24hHumid")
    public List<HourValue> getPastAvg24hHumid() {
        return cws.getPastAvg24hHumid();
    }

    @GetMapping(value = "/getPastAvg24hByRegion")
    public List<HourValue> getPastAvg24hByRegion(@RequestParam("regionName") String regionName){
        return cws.getPastAvg24hByRegion(regionName);
    }
}

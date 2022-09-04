package com.kasperxms.kasperweather;

import org.springframework.stereotype.Service;

import java.util.List;

public interface CurrentWeatherService {
    public LatestWeather getCurrentWeather();
    public List<RegionalTemperature> getAllRegionTemp();
}

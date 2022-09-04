package com.kasperxms.kasperweather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrentWeatherServiceImpl implements CurrentWeatherService{
    @Autowired
    private LatestWeatherMapper lwm;
    @Autowired
    private RegionalTempMapper rtm;
    @Override
    public LatestWeather getCurrentWeather() {
        int id = lwm.getMaxCWId();
        LatestWeather lw = lwm.getLWById(id);
        return lw;
    }

    @Override
    public List<RegionalTemperature> getAllRegionTemp() {
        return rtm.getTempOfAllRegion();
    }
}

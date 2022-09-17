package com.kasperxms.kasperweather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
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
        return lwm.getLWById(id);
    }

    @Override
    public List<RegionalTemperature> getAllCurrentRegionTemp() {
        LatestWeather latestLW = lwm.getLWById(lwm.getMaxCWId());
        Date dNow = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(latestLW.getTime());
        System.out.println(sdf.format(dNow));
        return rtm.getAllRegionalTempInPeriod(latestLW.getTime(), sdf.format(dNow));
    }
}

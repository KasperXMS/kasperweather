package com.kasperxms.kasperweather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

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

    @Override
    public List<RegionalTemperature> getTop5HotRegion() {
        List<RegionalTemperature> allRegions = getAllCurrentRegionTemp();
        allRegions.sort(Comparator.comparing(RegionalTemperature::getTemp).reversed());
        return allRegions.subList(0, 5);
    }

    @Override
    public List<HourValue> getPastAvg24hTemp() {
        String past24hString = getCertainDateString("24h past");
        String nowString = getCertainDateString("");
        return lwm.getAvgHourTemp(past24hString, nowString);
    }

    @Override
    public List<HourValue> getPastAvg24hHumid() {
        String past24hString = getCertainDateString("24h past");
        String nowString = getCertainDateString("");
        return lwm.getAvgHourHumid(past24hString, nowString);
    }

    @Override
    public List<HourValue> getPastAvg24hByRegion(String regionName) {
        String past24hString = getCertainDateString("24h past");
        String nowString = getCertainDateString("");
        return rtm.getAvgHourByRegion(past24hString, nowString, regionName);
    }

    private String getCertainDateString(String option){
        Date dNow = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dNow);
        if(option.equals("24h past")){
            calendar.add(Calendar.DAY_OF_MONTH, -1);
        }
        Date date = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }
}

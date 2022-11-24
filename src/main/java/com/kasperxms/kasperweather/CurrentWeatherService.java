package com.kasperxms.kasperweather;

import java.util.List;

public interface CurrentWeatherService {
    public LatestWeather getCurrentWeather();
    public List<RegionalTemperature> getAllCurrentRegionTemp();
    public List<RegionalTemperature> getTop5HotRegion();
    public List<HourValue> getPastAvg24hTemp();
    public List<HourValue> getPastAvg24hHumid();
    public List<HourValue> getPastAvg24hByRegion(String regionName);

}

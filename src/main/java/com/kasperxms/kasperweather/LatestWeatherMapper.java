package com.kasperxms.kasperweather;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LatestWeatherMapper {

    @Select("select max(id) from current_weather")
    public int getMaxCWId();

    @Select("select * from current_weather where id=#{id}")
    public LatestWeather getLWById(int id);

    @Select("select * from current_weather where date(time) between #{startDateStr} and #{endDateStr}")
    public List<LatestWeather> getLWinDatePeriod(String startDateStr, String endDateStr);

    @Select("select * from current_weather where unix_timestamp(time) >= unix_timestamp(#{startTimeStr}) and unix_timestamp(time) <= unix_timestamp(#{endTimeStr})")
    public List<LatestWeather> getLWinTimePeriod(String startTimeStr, String endTimeStr);
}

package com.kasperxms.kasperweather;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LatestWeatherMapper {

    @Select("select max(id) from current_weather")
    public int getMaxCWId();

    @Select("select * from current_weather where id=#{id}")
    public LatestWeather getLWById(int id);
}

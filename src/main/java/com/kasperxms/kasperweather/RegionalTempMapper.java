package com.kasperxms.kasperweather;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RegionalTempMapper {

    @Select("select * from regional_temp where unix_timestamp(time) >= unix_timestamp(#{startTimeStr}) and unix_timestamp(time) <= unix_timestamp(#{endTimeStr})")
    public List<RegionalTemperature> getAllRegionalTempInPeriod(String startTimeStr, String endTimeStr);

    @Select("select * from regional_temp where name=#{regionName} and unix_timestamp(time) >= unix_timestamp(#{startTimeStr}) and unix_timestamp(time) <= unix_timestamp(#{endTimeStr})")
    public List<RegionalTemperature> getRegionalTempInPeriodByRegion(String regionName, String startTimeStr, String endTimeStr);

}

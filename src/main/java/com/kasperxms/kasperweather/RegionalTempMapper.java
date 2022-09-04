package com.kasperxms.kasperweather;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RegionalTempMapper {

    @Select("select * from regional_temp")
    public List<RegionalTemperature> getTempOfAllRegion();

}

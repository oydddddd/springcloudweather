package com.oyd.springcloud.weather.weatherdataserver.service;


import com.oyd.springcloud.weather.weatherdataserver.vo.WeatherResponse;

public interface WeatherDataService {
    /**
     * 根据城市id查找天气数据
     * @param cityId
     * @return WeatherResponse
     */
    WeatherResponse getDataByCityId(String cityId);

    /**
     * 根据城市名称查询天气数据
     * @param cityName
     * @return
     */
    WeatherResponse getDataByCityName(String cityName);

}

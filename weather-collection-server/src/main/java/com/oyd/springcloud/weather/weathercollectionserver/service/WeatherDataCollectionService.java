package com.oyd.springcloud.weather.weathercollectionserver.service;

public interface WeatherDataCollectionService {
    /**
     * 根据城市id同步天气
     * @param cityId
     */
    void sysncDataByCityId(String cityId);
}

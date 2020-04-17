package com.oyd.springcloud.weatherreportserver.service;


import com.oyd.springcloud.weatherreportserver.vo.Weather;

public interface WeatherReportService {

    /**
     * 根据城市id查询天气信息
     * @param cityId
     * @return
     */
    Weather getDataByCityId(String cityId);
}

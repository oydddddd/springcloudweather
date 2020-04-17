package com.oyd.springcloud.weather.microweatherbasic.service;

import com.oyd.springcloud.weather.microweatherbasic.vo.Weather;

public interface WeatherReportService {

    /**
     * 根据城市id查询天气信息
     * @param cityId
     * @return
     */
    Weather getDataByCityId(String cityId);
}

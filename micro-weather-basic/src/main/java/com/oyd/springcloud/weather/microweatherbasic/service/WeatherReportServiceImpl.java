package com.oyd.springcloud.weather.microweatherbasic.service;

import com.oyd.springcloud.weather.microweatherbasic.vo.Weather;
import com.oyd.springcloud.weather.microweatherbasic.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherReportServiceImpl implements WeatherReportService {

    @Autowired
    private WeatherDataService weatherDataService;
    @Override
    public Weather getDataByCityId(String cityId) {
        WeatherResponse data = weatherDataService.getDataByCityId(cityId);
        return data.getData();
    }
}

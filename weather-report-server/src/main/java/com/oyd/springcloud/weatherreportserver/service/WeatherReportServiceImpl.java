package com.oyd.springcloud.weatherreportserver.service;

import com.oyd.springcloud.weatherreportserver.vo.City;
import com.oyd.springcloud.weatherreportserver.vo.Weather;
import com.oyd.springcloud.weatherreportserver.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherReportServiceImpl implements WeatherReportService {

    @Autowired
    private WeatherDataClient weatherDataClient;
//    @Autowired
//    private DataClient dataClient;

    @Override
    public Weather getDataByCityId(String cityId) {
        WeatherResponse data = weatherDataClient.getDataByCityId(cityId);
        return data.getData();
    }
}

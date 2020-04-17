package com.oyd.springcloud.weatherreportserver.service;

import com.oyd.springcloud.weatherreportserver.vo.City;
import com.oyd.springcloud.weatherreportserver.vo.WeatherResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataClientFallBack implements  DataClient{
    @Override
    public List<City> listCity() {
        List<City> cities = null;
        cities = new ArrayList<>();

        City city = new City();
        city.setCityId("101280601");
        city.setCityName("深圳");
        cities.add(city);

        City city1 = new City();
        city1.setCityId("101280301");
        city1.setCityName("惠州");
        cities.add(city1);
        return cities;
    }

    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        return null;
    }
}

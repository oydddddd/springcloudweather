package com.oyd.springcloud.weather.microweatherbasic.service;

import com.oyd.springcloud.weather.microweatherbasic.vo.City;

import java.util.List;

public interface CityDataService {

    List<City>  listCity() throws Exception;
}

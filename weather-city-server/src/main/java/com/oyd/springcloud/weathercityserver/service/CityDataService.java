package com.oyd.springcloud.weathercityserver.service;


import com.oyd.springcloud.weathercityserver.vo.City;

import java.util.List;

public interface CityDataService {

    List<City>  listCity() throws Exception;
}

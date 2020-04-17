package com.oyd.springcloud.weatherreportserver.service;

import com.oyd.springcloud.weatherreportserver.vo.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("weather-city-server")
public interface CityClient {

    @GetMapping("/cities")
    List<City> listCity() throws Exception;
}

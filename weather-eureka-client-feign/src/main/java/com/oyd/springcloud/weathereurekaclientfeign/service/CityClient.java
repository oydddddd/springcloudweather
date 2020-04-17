package com.oyd.springcloud.weathereurekaclientfeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient("weather-city-server")
public interface CityClient {

    @GetMapping("/cities")
    String listCity();
}



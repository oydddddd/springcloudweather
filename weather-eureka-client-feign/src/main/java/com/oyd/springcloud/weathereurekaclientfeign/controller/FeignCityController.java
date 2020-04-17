package com.oyd.springcloud.weathereurekaclientfeign.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.oyd.springcloud.weathereurekaclientfeign.service.CityClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignCityController {

    @Autowired
    private CityClient cityClient;

    @GetMapping("/cities")
    @HystrixCommand(fallbackMethod = "defaultCities")
    public String listCity(){
        //通过feign客户端查找的
        String listCity = cityClient.listCity();
        return listCity;
    }


    public String defaultCities(){
        return "City Server is down!";
    }
}

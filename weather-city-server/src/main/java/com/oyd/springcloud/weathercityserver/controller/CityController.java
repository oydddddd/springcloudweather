package com.oyd.springcloud.weathercityserver.controller;

import com.oyd.springcloud.weathercityserver.service.CityDataService;
import com.oyd.springcloud.weathercityserver.vo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityDataService cityDataService;

    @GetMapping
    public List<City> listCity(){
        List<City> cities = null;
        try {
            cities = cityDataService.listCity();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cities;
    }
}

package com.oyd.springcloud.weather.microweatherbasic.controller;

import com.oyd.springcloud.weather.microweatherbasic.service.CityDataService;
import com.oyd.springcloud.weather.microweatherbasic.service.WeatherDataService;
import com.oyd.springcloud.weather.microweatherbasic.service.WeatherReportService;
import com.oyd.springcloud.weather.microweatherbasic.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/report")
public class WeatherReportController {

    @Autowired
    private WeatherReportService weatherReportService;

    @Autowired
    private CityDataService cityDataService;

    @GetMapping("/cityId/{cityId}")
    public ModelAndView getWeatherByCityId(@PathVariable("cityId") String cityId, Model model){
        model.addAttribute("title", "oyd的天气预报");
        model.addAttribute("cityId", cityId);
        try {
            model.addAttribute("cityList", cityDataService.listCity());
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("report", weatherReportService.getDataByCityId(cityId));
        return new ModelAndView("weather/report","reportModel",model);
//        return weatherReportService.getDataByCityId(cityId);
    }
}

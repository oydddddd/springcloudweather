package com.oyd.springcloud.weatherreportserver.controller;

import com.oyd.springcloud.weatherreportserver.service.DataClient;
import com.oyd.springcloud.weatherreportserver.service.WeatherReportService;
import com.oyd.springcloud.weatherreportserver.vo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/report")
public class WeatherReportController {

    @Autowired
    private WeatherReportService weatherReportService;

//    @Autowired
//    private CityClient cityClient;
    @Autowired
    private DataClient dataClient;


    @GetMapping("/cityId/{cityId}")
    public ModelAndView getWeatherByCityId(@PathVariable("cityId") String cityId, Model model){
        model.addAttribute("title", "oyd的天气预报");
        model.addAttribute("cityId", cityId);
        try {
            List<City> cityList = null;
            try {
                cityList = dataClient.listCity();
            } catch (Exception e) {
                throw new RuntimeException();
            }
            model.addAttribute("cityList", cityList);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        model.addAttribute("report", weatherReportService.getDataByCityId(cityId));
        model.addAttribute("report", weatherReportService.getDataByCityId(cityId));
        return new ModelAndView("weather/report","reportModel",model);
//        return weatherReportService.getDataByCityId(cityId);
    }
}

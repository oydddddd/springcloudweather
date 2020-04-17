package com.oyd.springcloud.weather.microweatherbasic.job;

import com.oyd.springcloud.weather.microweatherbasic.service.CityDataService;
import com.oyd.springcloud.weather.microweatherbasic.service.WeatherDataService;
import com.oyd.springcloud.weather.microweatherbasic.vo.City;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;

public class WeatherDataSynJob extends QuartzJobBean {

    private final static Logger logger = LoggerFactory.getLogger(WeatherDataSynJob.class);

    @Autowired
    private CityDataService cityDataService;

    @Autowired
    private WeatherDataService weatherDataService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("Weather Data Sync Job");
        List<City> cityList = null;
        try {
            cityList = cityDataService.listCity();
        } catch (Exception e) {
            logger.error("Exception!");
        }
        for (City city : cityList) {
            String cityId = city.getCityId();
            logger.info("city is: "+cityId);
            weatherDataService.syncDateByCityId(cityId);
        }
    }
}

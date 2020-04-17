package com.oyd.springcloud.weather.weathercollectionserver.job;

import com.oyd.springcloud.weather.weathercollectionserver.service.CityClient;
import com.oyd.springcloud.weather.weathercollectionserver.service.WeatherDataCollectionService;
import com.oyd.springcloud.weather.weathercollectionserver.vo.City;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.ArrayList;
import java.util.List;

public class WeatherDataSynJob extends QuartzJobBean {

    private final static Logger logger = LoggerFactory.getLogger(WeatherDataSynJob.class);

    @Autowired
    private WeatherDataCollectionService weatherDataCollectionService;

    @Autowired
    private CityClient cityClient;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("Weather Data Sync Job");
        List<City> cityList = null;
        try {
            cityList = cityClient.listCity();
        } catch (Exception e) {
            logger.error("Exception!");
        }
        for (City city : cityList) {
            String cityId = city.getCityId();
            logger.info("city is: "+cityId);
            weatherDataCollectionService.sysncDataByCityId(cityId);
        }
    }
}

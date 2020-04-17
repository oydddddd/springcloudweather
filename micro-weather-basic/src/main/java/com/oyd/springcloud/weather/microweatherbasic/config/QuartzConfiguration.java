package com.oyd.springcloud.weather.microweatherbasic.config;

import com.oyd.springcloud.weather.microweatherbasic.job.WeatherDataSynJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfiguration {
    @Bean
    public JobDetail weatherDataSynJobDetail(){
        return JobBuilder.newJob(WeatherDataSynJob.class).withIdentity("weatherDataSynJob")
                .storeDurably().build();
    }

    @Bean
    public Trigger weatherDataSynTrigger(){
        //半小时同步一次
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(1800).repeatForever();
        return TriggerBuilder.newTrigger().forJob(weatherDataSynJobDetail()).withIdentity("weatherDataSynTrigger")
                .withSchedule(scheduleBuilder).build();
    }
}

package com.oyd.springcloud.weathereurekaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class WeathereurekaclientApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeathereurekaclientApplication.class, args);
    }

}

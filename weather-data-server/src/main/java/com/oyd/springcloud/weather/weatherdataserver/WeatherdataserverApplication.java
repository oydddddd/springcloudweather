package com.oyd.springcloud.weather.weatherdataserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class WeatherdataserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherdataserverApplication.class, args);
    }

}

package com.oyd.springcloud.weathercityserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class WeathercityserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeathercityserverApplication.class, args);
    }

}

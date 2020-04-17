package com.oyd.springcloud.weathereurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class WeathereurekaserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeathereurekaserverApplication.class, args);
    }

}

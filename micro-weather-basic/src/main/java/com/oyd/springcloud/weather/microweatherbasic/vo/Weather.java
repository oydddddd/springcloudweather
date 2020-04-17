package com.oyd.springcloud.weather.microweatherbasic.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Weather implements Serializable {
    private static final long serialVersionUID = -6042494222066296677L;

    private String city;
    private String aqi;
    private String ganmao;
    private String wendu;

    private Yesterday yesterday;
    private List<Forecast> forecast;

}

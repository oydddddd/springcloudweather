package com.oyd.springcloud.weather.microweatherbasic.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class WeatherResponse  implements Serializable {
    private static final long serialVersionUID = -8617238623767645304L;
    private Weather data;
    private Integer status;
    private String desc;
}

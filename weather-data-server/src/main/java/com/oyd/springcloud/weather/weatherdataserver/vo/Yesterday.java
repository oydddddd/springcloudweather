package com.oyd.springcloud.weather.weatherdataserver.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Yesterday implements Serializable {
    private static final long serialVersionUID = -2829054924753218716L;
    private String date;
    private String high;
    private String fx;
    private String low;
    private String fl;
    private String type;
}


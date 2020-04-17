package com.oyd.springcloud.weatherreportserver.vo;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@Data
public class City {

    public String cityId;

    public String cityName;

    public String cityCode;

    public String province;
}

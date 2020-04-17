package com.oyd.springcloud.weather.microweatherbasic.vo;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement(name = "d")
@XmlAccessorType(XmlAccessType.FIELD)
public class City {

    @XmlAttribute(name = "d1")
    public String cityId;

    @XmlAttribute(name = "d2")
    public String cityName;

    @XmlAttribute(name = "d3")
    public String cityCode;

    @XmlAttribute(name = "d4")
    public String province;
}

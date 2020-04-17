package com.oyd.springcloud.weatherreportserver.service;

import com.oyd.springcloud.weatherreportserver.vo.City;
import com.oyd.springcloud.weatherreportserver.vo.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="weather-zuul",fallback = DataClientFallBack.class)
public interface DataClient {
    /**\
     * 获取城市列表
     * @return
     * @throws Exception
     */
    @GetMapping("/city/cities")
    List<City> listCity() throws Exception;

    /**
     * 根据城市id查询天气
     * @param cityId
     * @return
     */
    @GetMapping("/weather/cityId/{cityId}")
    WeatherResponse getDataByCityId(@PathVariable("cityId") String cityId);
}

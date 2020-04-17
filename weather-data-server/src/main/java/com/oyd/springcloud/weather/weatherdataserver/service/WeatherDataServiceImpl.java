package com.oyd.springcloud.weather.weatherdataserver.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oyd.springcloud.weather.weatherdataserver.vo.WeatherResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

@Service
public class WeatherDataServiceImpl implements WeatherDataService {
    private final static Logger logger = LoggerFactory.getLogger(WeatherDataServiceImpl.class);

    private static  final String WEATHER_URI="http://wthrcdn.etouch.cn/weather_mini?=";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        String uri = WEATHER_URI + "citykey=" + cityId;
        return this.doGetWeather(uri);
    }

    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        String uri = WEATHER_URI + "city=" + cityName;
        return this.doGetWeather(uri);
    }

    private WeatherResponse doGetWeather(String uri){
        WeatherResponse weatherResponse = null;
        String stringBody = null;
        String key = uri;
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        if(stringRedisTemplate.hasKey(key)){
            logger.info("redis has data");
            stringBody = ops.get(key);
        }else{
            throw new RuntimeException("does't has data");
        }
        ObjectMapper mapper = new ObjectMapper();
        try {
            weatherResponse = mapper.readValue(stringBody, WeatherResponse.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return weatherResponse;
    }
}

package com.oyd.springcloud.weather.weathercollectionserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

@Service
public class WeatherDataCollectionServiceImpl implements WeatherDataCollectionService {

    private static  final String WEATHER_URI="http://wthrcdn.etouch.cn/weather_mini?=";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void sysncDataByCityId(String cityId) {
        String uri = WEATHER_URI + "citykey=" + cityId;
        this.saveWeatherData(uri);
    }

    /**
     * 把天气数据放到缓存中
     * @param uri
     */
    private void saveWeatherData(String uri){
//        WeatherResponse weatherResponse = null;
        String stringBody = null;
        String key = uri;
        ValueOperations<String,String> ops = stringRedisTemplate.opsForValue();
        ResponseEntity<String> respString = restTemplate.getForEntity(uri, String.class);
        if (respString.getStatusCodeValue() == 200) {
            stringBody = respString.getBody();
        }
        ops.set(key, stringBody, 1800L, TimeUnit.SECONDS);
    }
}

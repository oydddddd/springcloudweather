package com.oyd.springcloud.weather.microweatherbasic.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oyd.springcloud.weather.microweatherbasic.vo.WeatherResponse;
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
    private RestTemplate restTemplate;

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

    @Override
    public void syncDateByCityId(String cityId) {
        String uri = WEATHER_URI + "citykey=" + cityId;
        this.saveWeatherData(uri);
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
            logger.info("redis does't has data");
            ResponseEntity<String> respString = restTemplate.getForEntity(uri, String.class);
            if (respString.getStatusCodeValue() == 200) {
                stringBody = respString.getBody();
            }
            ops.set(key, stringBody, 1800L, TimeUnit.SECONDS);
        }
        ObjectMapper mapper = new ObjectMapper();
        try {
            weatherResponse = mapper.readValue(stringBody, WeatherResponse.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return weatherResponse;
    }

    /**
     * 把天气数据放到缓存中
     * @param uri
     */
    private void saveWeatherData(String uri){
        WeatherResponse weatherResponse = null;
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

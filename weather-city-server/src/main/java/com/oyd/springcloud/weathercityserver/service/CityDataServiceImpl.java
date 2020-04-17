package com.oyd.springcloud.weathercityserver.service;

import com.oyd.springcloud.weathercityserver.util.XmlBuilder;
import com.oyd.springcloud.weathercityserver.vo.City;
import com.oyd.springcloud.weathercityserver.vo.CityList;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class CityDataServiceImpl implements CityDataService {

    @Override
    public List<City> listCity() throws Exception {
        ClassPathResource resource = new ClassPathResource("citylist.xml");
        BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream(),"utf-8"));
        StringBuffer buffer = new StringBuffer();
        String line = "";

        while((line = reader.readLine()) != null){
            buffer.append(line);
        }
        reader.close();

        CityList cityList = (CityList) XmlBuilder.xmlStrToObject(CityList.class, buffer.toString());
        return cityList.getCityList();
    }
}

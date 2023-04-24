package com.inz.pasieka.ExternalServicesAPI.Services;

import com.inz.pasieka.ExternalServicesAPI.Helpers.WeatherDataForWidgetCombined;
import com.inz.pasieka.ExternalServicesAPI.dao.WeatherCurrentWrapper;
import com.inz.pasieka.tmpPakiet.Exception.ExistanceValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

//@RestController
//@RequestMapping("externalApi/tests/weather")
@Service
public class WeatherServiceImpl implements WeatherService {
    private final RestTemplate restTemplate;

    @Autowired
    public WeatherServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public WeatherDataForWidgetCombined getWeatherData(String lat, String lon){
        WeatherCurrentWrapper currentWeatherDTO = restTemplate.getForObject(
                "https://api.openweathermap.org/data/2.5/weather?lat=" +
                        lat +
                        "&" +
                        "lon=" +
                        lon +
                        "&appid=xxxxxxxxxx &units=metric", // aby uruchomić należy dodać klucz
               WeatherCurrentWrapper.class);
        if (currentWeatherDTO==null) {
            throw new ExistanceValidationException("nie można pobrać danych pogodowych!");
        }
        return new WeatherDataForWidgetCombined(currentWeatherDTO.id,currentWeatherDTO.name);
    }





}

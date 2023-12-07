package models;

import java.util.ArrayList;

public class Current {
    public String observation_time;
    public Integer temperature;
    public Integer weather_code;
    public ArrayList<String> weather_icons;
    public ArrayList<String> weather_descriptions;
    public Integer wind_speed;
    public Integer wind_degree;
    public String wind_dir;
    public Integer pressure;
    public Double precip;
    public Integer humidity;
    public Integer cloudcover;
    public Integer feelslike;
    public Integer uv_index;
    public Integer visibility;
    public String is_day;

    public Current() {
    }

    public Current(String observation_time, Integer temperature, Integer weather_code, ArrayList<String> weather_icons,
                   ArrayList<String> weather_descriptions, Integer wind_speed, Integer wind_degree, String wind_dir,
                   Integer pressure, Double precip, Integer humidity, Integer cloudcover, Integer feelslike, Integer uv_index,
                   Integer visibility, String is_day) {
        this.observation_time = observation_time;
        this.temperature = temperature;
        this.weather_code = weather_code;
        this.weather_icons = weather_icons;
        this.weather_descriptions = weather_descriptions;
        this.wind_speed = wind_speed;
        this.wind_degree = wind_degree;
        this.wind_dir = wind_dir;
        this.pressure = pressure;
        this.precip = precip;
        this.humidity = humidity;
        this.cloudcover = cloudcover;
        this.feelslike = feelslike;
        this.uv_index = uv_index;
        this.visibility = visibility;
        this.is_day = is_day;
    }

    public String getObservation_time() {
        return observation_time;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public Integer getWeather_code() {
        return weather_code;
    }

    public ArrayList<String> getWeather_icons() {
        return weather_icons;
    }

    public ArrayList<String> getWeather_descriptions() {
        return weather_descriptions;
    }

    public Integer getWind_speed() {
        return wind_speed;
    }

    public Integer getWind_degree() {
        return wind_degree;
    }

    public String getWind_dir() {
        return wind_dir;
    }

    public Integer getPressure() {
        return pressure;
    }

    public Double getPrecip() {
        return precip;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public Integer getCloudcover() {
        return cloudcover;
    }

    public Integer getFeelslike() {
        return feelslike;
    }

    public Integer getUv_index() {
        return uv_index;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public String getIs_day() {
        return is_day;
    }
}

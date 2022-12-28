package org.example.v1.repository;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Weather {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "weather_id", nullable = false)
    private int weatherId;
    @Basic
    @Column(name = "state_of_weather", nullable = true, length = 35)
    private String stateOfWeather;
    @Basic
    @Column(name = "temperature", nullable = true, precision = 0)
    private Double temperature;
    @Basic
    @Column(name = "humidity", nullable = true, precision = 0)
    private Double humidity;
    @Basic
    @Column(name = "Wind", nullable = true, precision = 0)
    private Double wind;
    @Basic
    @Column(name = "city", nullable = true, length = 35)
    private String city;
    @Basic
    @Column(name = "city_fk", nullable = true)
    private Integer cityFk;
    @Basic
    @Column(name = "date_time", nullable = true)
    private Timestamp dateTime;

    public int getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(int weatherId) {
        this.weatherId = weatherId;
    }

    public String getStateOfWeather() {
        return stateOfWeather;
    }

    public void setStateOfWeather(String stateOfWeather) {
        this.stateOfWeather = stateOfWeather;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getWind() {
        return wind;
    }

    public void setWind(Double wind) {
        this.wind = wind;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getCityFk() {
        return cityFk;
    }

    public void setCityFk(Integer cityFk) {
        this.cityFk = cityFk;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Weather weather = (Weather) o;

        if (weatherId != weather.weatherId) return false;
        if (!Objects.equals(stateOfWeather, weather.stateOfWeather))
            return false;
        if (!Objects.equals(temperature, weather.temperature)) return false;
        if (!Objects.equals(humidity, weather.humidity)) return false;
        if (!Objects.equals(wind, weather.wind)) return false;
        if (!Objects.equals(city, weather.city)) return false;
        if (!Objects.equals(cityFk, weather.cityFk)) return false;
        return Objects.equals(dateTime, weather.dateTime);
    }

    @Override
    public int hashCode() {
        int result = weatherId;
        result = 31 * result + (stateOfWeather != null ? stateOfWeather.hashCode() : 0);
        result = 31 * result + (temperature != null ? temperature.hashCode() : 0);
        result = 31 * result + (humidity != null ? humidity.hashCode() : 0);
        result = 31 * result + (wind != null ? wind.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (cityFk != null ? cityFk.hashCode() : 0);
        result = 31 * result + (dateTime != null ? dateTime.hashCode() : 0);
        return result;
    }
}
